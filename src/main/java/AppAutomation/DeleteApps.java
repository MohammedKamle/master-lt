package AppAutomation;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteApps {
    private static final String credential = Credentials.basic("mohammadk", "rakcBoBYHiy8BW7osVi4N1LGYjgJhRfAwvL1pPUvwCA1wfNChd");


    public static void main(String[] args) throws IOException {

        String jsonData = getResponseJson("android");

        ArrayList<String> appIds = getAppIdsFromJson(jsonData);

        // Print the app IDs
        for (String appId : appIds) {
            System.out.println(appId);
        }

        System.out.println("Non proverbial apps found : "+appIds.size());

        deleteApps(appIds);

        System.out.println("Deleted Successfully!");

    }

    public static ArrayList<String> getAppIdsFromJson(String jsonData) {
        ArrayList<String> appIds = new ArrayList<>();

        try {
            JSONObject json = new JSONObject(jsonData);
            JSONArray dataArray = json.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject appObject = dataArray.getJSONObject(i);
                boolean containsProverbial = appObject.getString("name").toLowerCase().contains("proverbial");
                if (appObject.has("app_id") && !containsProverbial) {
                    String appId = appObject.getString("app_id");
                    appIds.add(appId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appIds;
    }

    public static void deleteApps(List<String> appIdsList) throws IOException {
        for (String id : appIdsList){
                    OkHttpClient client1 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType1 = MediaType.parse("application/json");
        RequestBody body1 = RequestBody.create(mediaType1, "{\"appIds\" : \""+id+"\"}");
        Request request1 = new Request.Builder()
                .url("https://manual-api.lambdatest.com/app/delete")
                .method("DELETE", body1)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", credential)
                .build();
        Response response1 = client1.newCall(request1).execute();
        }
    }

    public static String getResponseJson(String platform){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://manual-api.lambdatest.com/app/data?type="+platform+"&level=user")
                .method("GET",null)
                .addHeader("Authorization", credential)
                .build();


//        Response response = client.newCall(request).execute();
//        String responseJSON = response.body().string();
        String responseJSON = null;
        try (Response response = client.newCall(request).execute()) {
            responseJSON = response.body().string();
            // Process the response JSON
            System.out.println(responseJSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJSON;
    }
}
