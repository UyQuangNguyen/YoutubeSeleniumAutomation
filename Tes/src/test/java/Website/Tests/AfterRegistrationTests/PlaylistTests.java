package Website.Tests.AfterRegistrationTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PlaylistTests {

    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        System.out.println("this runs before the others yes yes");
    }

    @Test
    public void testGoogleSearch() {
        System.out.println("abcdefg");

    }
}
