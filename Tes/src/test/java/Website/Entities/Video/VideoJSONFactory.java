package Website.Entities.Video;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class VideoJSONFactory {
    static String sURL;
    static String youtubeApiKey = "ADDYOURKEYHERE";

    VideoJSONFactory(String sURL) {
        this.sURL = sURL;
    }


    @Test
    public static com.eclipsesource.json.JsonObject fetchYoutubeJsonObject() throws IOException, JSONException {
        InputStream is = new URL(sURL).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        JsonObject jsonObject = JsonObject.readFrom(rd);
        String ip = jsonObject.get( "ip" ).asString();
        System.out.println(ip);

        return jsonObject;


    }
}