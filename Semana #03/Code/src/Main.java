import Models.Character;
import Models.Enums.Gender;
import Models.Enums.Status;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Main {
    public static Character mapCharacter(JSONObject o) {
        int id = o.getInt("id");
        String name = o.getString("name");
        Status status = o.getEnum(Status.class, "status");
        Gender gender = o.getEnum(Gender.class, "gender");
        JSONArray eList = (JSONArray) o.get("episode");
        ArrayList<String> episodes = new ArrayList<>();
        for (int i = 0; i < eList.length(); i++) {
            episodes.add(eList.getString(i));
        }
        return new Character(id, name, status, gender, episodes);
    }
    public static void main(String[] args) {
        // String bool int byte double float char
        /**
        String name = "Belén";
        int age = 17;
        boolean isStudent = true;
        char gender = 'F'
        **/

        // Creating a new instance of Character
        // Character myFirstCharacter = new Character(1, "Jonathan", Status.Alive, Gender.Male);

        String url = "https://rickandmortyapi.com/api/character";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject responseBody = new JSONObject(response.body());
            JSONArray resultsList = (JSONArray) responseBody.get("results");
            ArrayList<Character> characterList = new ArrayList<>();
            for (int i = 0; i < resultsList.length(); i++) {
                JSONObject character = (JSONObject) resultsList.get(i);
                characterList.add(mapCharacter(character));
            }

            for (Character c : characterList) {
                System.out.println("ID: " + c.getId() + " | Name: " + c.getName() + " | Status: " + c.getStatus() + " | Gender: " + c.getGender() + " | Episodes: " + c.getEpisode().toArray().length);
            }

            System.out.println("Character list length: " + characterList.toArray().length);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}