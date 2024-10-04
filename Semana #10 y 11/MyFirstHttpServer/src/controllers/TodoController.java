package controllers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import database.DB;
import models.Todo;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;

public class TodoController implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equals("GET")) {
            response = listTodos().toString();
        } else if (requestMethod.equals("POST")) {
            response = addTodo(exchange.getRequestBody()).toString();
        } else if (requestMethod.equals("DELETE")) {
            String[] paths = exchange.getRequestURI().getPath().split("/");
            String todoId = paths[paths.length - 1];
            response = deleteTodo(todoId).toString();
        }
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public JSONObject listTodos() {
        JSONObject response = new JSONObject();
        response.put("data", DB.data.getJSONArray("todos"));
        response.put("result", "successful");
        return response;
    }

    public JSONObject addTodo(InputStream todoBody) throws IOException {
        StringWriter sw = new StringWriter();
        IOUtils.copy(todoBody, sw);
        String body = sw.toString();
        JSONObject jsonBody = new JSONObject(body);
        String title = jsonBody.getString("title");
        Todo newTodo = new Todo("", title, false);
        JSONObject newTodoJsonObject = new JSONObject(newTodo);
        DB.data.getJSONArray("todos").put(newTodoJsonObject);
        DB.saveData();
        JSONObject response = new JSONObject();
        response.put("result", "successful");
        response.put("data", newTodoJsonObject);
        return response;
    }

    public JSONObject deleteTodo(String todoId) throws IOException {
        JSONObject response = new JSONObject();
        JSONArray data = DB.data.getJSONArray("todos");
        for (int i = 0; i < data.length(); i++) {
            JSONObject todo = data.getJSONObject(i);
            if (todo.getString("id").equals(todoId)) {
                response.put("result", "successful");
                response.put("deleted", todo);
                data.remove(i);
                DB.saveData();
                break;
            }else{
                response.put("result", "error");
            }
        }
        return response;
    }
}