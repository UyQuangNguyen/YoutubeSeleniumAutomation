package Website.Entities.Video;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Video {

    public String title;
    public String duration;
    public String url;
    public String uploader;
    public String amountOfViews;
    public String uploadDate;
    public String category;

    Video (String title, String duration, String url, String uploader,
           String amountOfViews, String uploadDate, String category) {
        this.title = title;
        this.duration = duration;
        this.url = url;
        this.uploader = uploader;
        this.amountOfViews = amountOfViews;
        this.uploadDate = uploadDate;
        this.category = category;
    }

}
