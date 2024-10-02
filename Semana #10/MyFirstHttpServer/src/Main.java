import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import database.DB;
import models.Todo;
import org.json.JSONArray;
import server.Server;

public class Main {
    public static void main(String[] args) throws Exception {
//        DB.loadData();
//        ArrayList<Todo> todos = new ArrayList<Todo>();
//        JSONArray jsonArray = DB.data.getJSONArray("todos");
//        for (int i = 0; i < jsonArray.length(); i++){
//            todos.add(new Gson().fromJson(jsonArray.get(i).toString(), Todo.class));
//        }
//        Todo newTodo = new Todo("", "Buy groceries", false);
//        todos.add(newTodo);
//        DB.data.put("todos", todos);
//        DB.saveData();
        new Server().start();
    }
}