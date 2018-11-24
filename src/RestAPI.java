import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.io.OutputStreamWriter;


public class RestAPI {
    public static String getXML(String filename) {
        String url = "http://localhost:8080/exist/rest/db/test/"+filename;
        try {

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static String getXML(String filename, String xQuery) {
        String url = "http://localhost:8080/exist/rest/db/test/"+filename+"?_query="+xQuery;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }



    public static boolean putXML(String filename, String XML, String user, String pass){
        try {
            String authStr = user + ":"+pass;
            //byte [] authByteEnc = Base64.getEncoder().encode(authStr.getBytes());
            //String authStrEnc = new String(authByteEnc);
            String authStrEnc = URLEncoder.encode(authStr);
            String urlString = "http://localhost:8080/exist/rest/db/test/"+filename;
            URL url = new URL(urlString);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            httpCon.setDoOutput(true);
            httpCon.setDoInput(true);
            httpCon.setRequestProperty("Content-type", "application/xml");
            httpCon.setRequestProperty("Authorization", "Basic " + authStrEnc);
            httpCon.setRequestMethod("PUT");

            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write(XML);
            out.close();
            httpCon.getInputStream();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
