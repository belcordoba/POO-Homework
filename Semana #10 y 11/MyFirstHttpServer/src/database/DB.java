package database;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.*;

public abstract class DB {
    // private String dataFilePath = "C:\\Users\\belen\\OneDrive\\Documentos\\GitHub\\POO-Homework\\Semana 10\\MyFirstHttpServer\\src\\database\\data.json";
    private static final String dataFilePath = System.getProperty("user.dir") + "\\src\\database\\data.json";
    public static JSONObject data = new JSONObject();

    public static void loadData() throws Exception {
        File file = new File(dataFilePath);
        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            String jsonText = IOUtils.toString(inputStream, "utf-8");
            data = new JSONObject(jsonText);
        }
    }

    public static void saveData() throws IOException {
        File file = new File(dataFilePath);
        FileOutputStream outputStream = new FileOutputStream(file);
        String jsonText = data.toString();
        outputStream.write(jsonText.getBytes());
        outputStream.close();
    }
}