package Global;

import org.testng.annotations.BeforeMethod;

public class Core {
    // Will always run first for tests that requires user to be signed in.
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        System.out.println("this runs before the others yes yes");
    }

}
