import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class project01_D {
    public static void main(String[] args) {
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        String APIURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String ClientID = "ii0235ktnc";
        String ClientSecret = "etQdztcuSldNa1jSQo9DCGeX2BqMouzMYolgyaub";

        try {
            System.out.print("주소를 입력하시오: ");
            String address = io.readLine();
            String addr = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String requestURL = APIURL + addr;

            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-NCP-APIGW-API-KEY-ID", ClientID);
            connection.setRequestProperty("X-NCP-APIGW-API-KEY", ClientSecret);

            BufferedReader br;

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            try {
                JSONTokener tokener = new JSONTokener(response.toString());
                JSONObject object = new JSONObject(tokener);
                System.out.println(object.toString(2));

                JSONArray array = object.getJSONArray("addresses");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = (JSONObject) array.get(i);
                    System.out.println(obj.get("roadAddress"));
                    System.out.println(obj.get("jibunAddress"));
                    System.out.println(obj.get("x"));
                    System.out.println(obj.get("y"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
