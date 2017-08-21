package Global;

import org.testng.annotations.BeforeMethod;

public class Core {
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        System.out.println("this runs before the others yes yes");
        System.out.println("Better feature");
    }

}
