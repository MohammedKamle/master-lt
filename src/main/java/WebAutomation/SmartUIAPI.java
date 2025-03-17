//package WebAutomation;
//
//import okhttp3.*;
//
//import java.io.File;
//import java.io.IOException;
//
//public class SmartUIAPI {
//
//    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("projectToken","550422#d0ab1a31-4823-4876-b82e-913c68abe957#api-project")
//                .addFormDataPart("buildName","build-2")
//                .addFormDataPart("baseline","true")
//                .addFormDataPart("screenshotName","image-1")
//                .addFormDataPart("files","aa-sample.png",
//                        RequestBody.create(MediaType.parse("application/octet-stream"),
//                                new File("/Users/mohammadk/Desktop/aa-sample.png")))
//                .build();
//        Request request = new Request.Builder()
//                .url("https://api.lambdatest.com/automation/smart-ui/v2/upload")
//                .method("POST", body)
//                .addHeader("Authorization", "Basic bW9oYW1tYWRrOmdrcnpUMGlGS2pEamVoWHBNVHpueE0xbEhJWlhTWWpWM0g4TnRrMHMyckNVSkpPM1dV")
//                .build();
//        Response response = client.newCall(request).execute();
//
//        System.out.println(response.body().string());
//
//        response.close();
//
//
//    }
//}
