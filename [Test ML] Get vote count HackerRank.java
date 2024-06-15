import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sun.jdi.event.ExceptionEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Result {
    
    private static String URI = "https://jsonmock.hackerrank.com/api/";

    public static String getContentAPI(String urlString){
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                content.append(inputLine);
            in.close();
            connection.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int getVoteCount(String cityName, int estimatedCost) {
        int totalVotes = 0;
        try {
            String cn = "city=" + cityName;
            String ec = "estimated_cost=" + estimatedCost;
            String urlString = URI + "food_outlets?" + cn + "&" + ec;
            
            String response = getContentAPI(urlString);
            
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response);
            JSONArray data = (JSONArray) jsonResponse.get("data");

            if (data.isEmpty()) return -1;

            for (Object obj : data) {
                JSONObject outlet = (JSONObject) obj;
                JSONObject userRating = (JSONObject) outlet.get("user_rating");
                totalVotes += ((Long) userRating.get("votes")).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalVotes;
    }

    public static void main(String[] args) {
        String cityName = "Delaware";
        int estimatedCost = 150;
        int totalVotes = getVoteCount(cityName, estimatedCost);
        System.out.println("Total votes: " + totalVotes);
    }
}
