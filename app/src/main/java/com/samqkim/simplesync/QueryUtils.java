package com.samqkim.simplesync;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by samuel.kim on 1/11/18.
 */

public class QueryUtils {
    private static List<Todo> todoList;

    private static String getData(String stringUrl) {
        return "[\n" +
                "{\n" +
                "\"id\": 231,\n" +
                "\"title\": \"hotto dogu\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-05T03:17:30.610Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:49:33.562Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 300,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 314,\n" +
                "\"title\": \"hello\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-11-08T04:40:36.534Z\",\n" +
                "\"updated_at\": \"2017-12-09T01:04:20.926Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 441,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 315,\n" +
                "\"title\": \"something like this\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-11-08T04:55:23.551Z\",\n" +
                "\"updated_at\": \"2017-11-08T04:59:12.874Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 442,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 229,\n" +
                "\"title\": \"hot dog\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-05T03:17:30.252Z\",\n" +
                "\"updated_at\": \"2017-10-05T03:17:41.299Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 298,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 300,\n" +
                "\"title\": \"hello this is atest\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-12T07:50:15.283Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:36:27.652Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 424,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 230,\n" +
                "\"title\": \"tell me\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-05T03:17:30.428Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:49:40.838Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 299,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 299,\n" +
                "\"title\": \"what am i doing here\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-12T07:50:07.250Z\",\n" +
                "\"updated_at\": \"2017-11-08T04:27:31.382Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 423,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 228,\n" +
                "\"title\": \"moist\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-05T03:17:30.058Z\",\n" +
                "\"updated_at\": \"2017-10-05T03:17:45.768Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 297,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 265,\n" +
                "\"title\": \"hello this is sam\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-10T07:05:13.868Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:49:28.026Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 380,\n" +
                "\"is_owner\": true\n" +
                "},\n" +
                "{\n" +
                "\"id\": 26,\n" +
                "\"username\": \"test222\",\n" +
                "\"user_todo_id\": 383,\n" +
                "\"is_owner\": false\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 296,\n" +
                "\"title\": \"task 123\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-12T07:47:39.486Z\",\n" +
                "\"updated_at\": \"2017-11-08T04:27:42.722Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 420,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "},\n" +
                "{\n" +
                "\"id\": 312,\n" +
                "\"title\": \"setup tent and do the other things\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-11-08T01:34:05.540Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:49:19.138Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 438,\n" +
                "\"is_owner\": true\n" +
                "},\n" +
                "{\n" +
                "\"id\": 25,\n" +
                "\"username\": \"test111\",\n" +
                "\"user_todo_id\": 439,\n" +
                "\"is_owner\": false\n" +
                "}\n" +
                "]\n" +
                "}\n" +
                "]";
    }

    private static String addData(String stringUrl) {
        return "[{\n" +
                "\"id\": 333,\n" +
                "\"title\": \"notto dogu\",\n" +
                "\"body\": \"\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"owner_id\": 24,\n" +
                "\"created_at\": \"2017-10-05T03:17:30.610Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:49:33.562Z\",\n" +
                "\"users\": [\n" +
                "{\n" +
                "\"id\": 24,\n" +
                "\"username\": \"test123\",\n" +
                "\"user_todo_id\": 300,\n" +
                "\"is_owner\": true\n" +
                "}\n" +
                "]\n" +
                "}]";
    }

    private static String readInputStream(InputStream inputStream) {
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sB = new StringBuilder();
        String line = "";
        try {
            while((line = r.readLine()) != null) {
                sB.append(line);
            }
            r.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sB.toString();
    }

    public static List<Todo> extractTodo(Boolean add, String stringUrl) {
        String data;
        if(add) {
            data = addData(stringUrl);
        }else {
            todoList = new ArrayList<>();
            data = getData(stringUrl);
        }
        try {
            JSONArray arr = new JSONArray(data);

            for(int i = 0; i < arr.length(); i++) {

                JSONObject currTodo = arr.getJSONObject(i);
                JSONArray users = currTodo.getJSONArray("users");

                String title = currTodo.getString("title");
                int id = currTodo.getInt("id");
                User owner = null;
                Boolean done = currTodo.getBoolean("done");
                List<User> team = new ArrayList<>();

                for(int j = 0; j < users.length(); j++) {
                    JSONObject user = (JSONObject) users.get(j);
                    if(j==0) {
                        owner = new User(user.getString("username"));
                    }else {
                        team.add(new User(user.getString("username")));
                    }
                }
                todoList.add(0, new Todo(id, title, owner, team, done));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return todoList;
    }

    private static String getDetailData(String stringUrl) throws IOException {
        String jsonStringData = "";
        HttpURLConnection urlConnection = null;
        InputStream in = null;

        try {
            URL mUrl = new URL(stringUrl);
            urlConnection = (HttpURLConnection) mUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(1000);
            urlConnection.setConnectTimeout(1000);
            urlConnection.connect();
            in = urlConnection.getInputStream();
            jsonStringData = readInputStream(in);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
                urlConnection = null;
            }
            if(in != null) {
                in.close();
                in = null;
            }
        }
//        return jsonStringData;
        return "[\n" +
                "{\n" +
                "\"id\": 92,\n" +
                "\"todo_id\": 315,\n" +
                "\"body\": \"haircut\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"created_at\": \"2017-12-01T13:31:31.917Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:31:31.917Z\",\n" +
                "\"archived_time\": null,\n" +
                "\"deleted_time\": null\n" +
                "},\n" +
                "{\n" +
                "\"id\": 93,\n" +
                "\"todo_id\": 315,\n" +
                "\"body\": \"walgreens vsp\",\n" +
                "\"done\": false,\n" +
                "\"list_order\": 0,\n" +
                "\"created_at\": \"2017-12-01T13:31:42.045Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:31:42.045Z\",\n" +
                "\"archived_time\": null,\n" +
                "\"deleted_time\": null\n" +
                "},\n" +
                "{\n" +
                "\"id\": 94,\n" +
                "\"todo_id\": 315,\n" +
                "\"body\": \"change comcast bill\",\n" +
                "\"done\": true,\n" +
                "\"list_order\": 0,\n" +
                "\"created_at\": \"2017-12-01T13:31:53.649Z\",\n" +
                "\"updated_at\": \"2017-12-01T13:35:22.312Z\",\n" +
                "\"archived_time\": null,\n" +
                "\"deleted_time\": null\n" +
                "}\n" +
                "]";
    }

    public static List<SubTask> extractSubtasks(String urlString) {
        List<SubTask> subTaskList = new ArrayList<>();
        try {
            String data = getDetailData(urlString);
            JSONArray arr = new JSONArray(data);
            for(int i = 0; i < arr.length(); i++) {

                String body = ((JSONObject) arr.get(i)).getString("body");
                Boolean done = ((JSONObject) arr.get(i)).getBoolean("done");

                subTaskList.add(new SubTask(body, done));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return subTaskList;
    }
}
