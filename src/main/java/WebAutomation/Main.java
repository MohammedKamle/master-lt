package WebAutomation;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // Prepare the HttpClient and HttpPost
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost("https://api.lambdatest.com/automation/smart-ui/v2/upload");

        // Add the authorization header
        uploadFile.addHeader("Authorization", "Basic bW9oYW1tYWRrOmdrcnpUMGlGS2pEamVoWHBNVHpueE0xbEhJWlhTWWpWM0g4TnRrMHMyckNVSkpPM1dV");

        // Prepare the file to be uploaded
        File file = new File("/Users/mohammadk/Desktop/aa-sample.png");
        FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);


        // Add the parts to the request
        HttpEntity multipart = MultipartEntityBuilder.create()
                .addTextBody("projectToken", "550422#d0ab1a31-4823-4876-b82e-913c68abe957#api-project") // Adjust according to your needs
                .addTextBody("buildName", "build-2")
                .addTextBody("baseline", "true")
                .addTextBody("screenshotName", "image-1")
                .addPart("files", fileBody)
                .build();

        uploadFile.setEntity(multipart);
        // Execute the request
        HttpResponse response = httpClient.execute(uploadFile);

        // Convert the response into a String format
        String jsonResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println("Response JSON: " + jsonResponse);

    }
}
