package Website.Entities.Video;
import com.eclipsesource.json.JsonObject;
import java.lang.Object;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;
import java.util.List;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class VideoJSONFactory {
    public static String sURL;
    public static String youtubeApiKey = ""; // Add your key here. If not added, it'll load the key from a file. (create .apikey.txt in same folder)
    public static String content;
    public static String youtubeID;

    public VideoJSONFactory(String sURL) {
        this.sURL = sURL;
        this.youtubeID = getYoutubeIDfromURL(sURL);

        if(youtubeApiKey == "") this.youtubeApiKey = GetApiKey();
    }

    public static Website.Entities.Video.Video convertYoutubeObjectToVideo() throws IOException, JSONException {

        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                new HttpRequestInitializer() {
                    public void initialize(HttpRequest request) throws IOException {
                    }
                }).setApplicationName("video-test").build();

        final String videoId = youtubeID;
        YouTube.Videos.List videoRequest = youtube.videos().list("snippet,statistics,contentDetails");
        videoRequest.setId(videoId);
        videoRequest.setKey(youtubeApiKey);
        VideoListResponse listResponse = videoRequest.execute();
        List<com.google.api.services.youtube.model.Video> videoList = listResponse.getItems();
        com.google.api.services.youtube.model.Video targetVideo = videoList.iterator().next();
        System.out.println(targetVideo.getContentDetails().getDuration());

        return new Website.Entities.Video.Video(targetVideo.getSnippet().getTitle(),targetVideo.getContentDetails().getDuration(),
                sURL,targetVideo.getSnippet().getChannelId(),String.valueOf(targetVideo.getStatistics().getViewCount()),
                String.valueOf((targetVideo.getSnippet().getPublishedAt())),
                targetVideo.getSnippet().getCategoryId());

    }

    public static String getYoutubeIDfromURL(String url) {
        String [] idFetcher = url.split("=");
        return idFetcher[idFetcher.length-1];


    }

    public static String GetApiKey() {
        if (youtubeApiKey == "") {
            try {
                content = new Scanner(new File("/Users/uyng/YoutubeSeleniumAutomation/Tes/src/test/java/Website/Entities/Video/.apikey.txt")).useDelimiter("\\Z").next();
                return content;

            } catch (Exception IOException) {
                System.out.println("You had no file, or the path to apikey file is wrong.");
            }
        } else {
            System.out.println("Pre-defined key was added by user. Key is : " + youtubeApiKey);
        }
        return "ERROR";
    }
}