import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.util.Base64;
import java.io.InputStreamReader;
import java.util.ArrayList;


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
            connection.disconnect();
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
            connection.disconnect();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }




    public static boolean putXML(String filename, String XML, String user, String pass) {
        try {
            String urlStr  =  "http://localhost:8080/exist/rest/db/test/"+filename;
            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            String userCredentials = user+":"+pass;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            httpCon.setRequestProperty ("Authorization", basicAuth);

            httpCon.setRequestMethod("PUT");

            httpCon.setRequestProperty("Content-Type", "application/xml");
            httpCon.setRequestProperty("Content-Length", "" + XML.getBytes().length);
            httpCon.setRequestProperty("Content-Language", "en-US");
            httpCon.setUseCaches(false);
            httpCon.setDoInput(true);
            httpCon.setDoOutput(true);

            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.write(XML);
            out.close();
            httpCon.getInputStream();


            httpCon.disconnect();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
