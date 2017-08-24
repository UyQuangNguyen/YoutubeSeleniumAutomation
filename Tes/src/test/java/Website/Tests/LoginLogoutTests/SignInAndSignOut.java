package Website.Tests.LoginLogoutTests;
import Website.WebsiteCore;
import org.testng.annotations.Test;

public class SignInAndSignOut extends WebsiteCore{
    @Test(groups = {"smoke"})
    public void firstTestCase()
    {

        System.out.println("I'm in first test case from SignInAndSignOut class.");
    }

    @Test(groups = {"functest"})
    public void secondTestCase()
    {

        System.out.println("I'm in second test case from SignInAndSignOut class.");
    }
}
