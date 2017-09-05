package Website.Entities.Video;

import com.eclipsesource.json.JsonObject;
import com.oracle.javafx.jmx.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class VideoJSONFactory {
    public static String sURL;
    public static String youtubeApiKey = ""; // Add your key here. If not added, it'll load the key from a file. (create .apikey.txt in same folder)
    public static String content;

    public VideoJSONFactory(String sURL) {
        this.sURL = sURL;
    }

    @BeforeMethod(alwaysRun = true)
    public static void addApiKey() {
        if (youtubeApiKey == "") {
            try {
                content = new Scanner(new File("/Users/uyng/YoutubeSeleniumAutomation/Tes/src/test/java/Website/Entities/Video/.apikey.txt")).useDelimiter("\\Z").next();
                youtubeApiKey = content;

            } catch (Exception IOException) {
                System.out.println("You had no file, or the path to apikey file is wrong.");
            }
        } else {
            System.out.println("Pre-defined key was added by user. Key is : " + youtubeApiKey);
        }
    }

    @Test(groups = "smokeBeforeReg")
    public static com.eclipsesource.json.JsonObject fetchYoutubeJsonObject() throws IOException, JSONException {
        addApiKey();
        System.out.println(youtubeApiKey);
        InputStream is = new URL(sURL).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        JsonObject jsonObject = JsonObject.readFrom(rd);
        String ip = jsonObject.get( "ip" ).asString();
        System.out.println(ip);

        return jsonObject;


    }
}