package test.java.com.sanju.uitest;

import main.java.com.sanju.uitest.selenium.LoginPageService;
import main.java.com.sanju.uitest.util.TestConstants;
import org.junit.*;



public class LoginPageLiveTest {

    private LoginPageService loginPageService;
    private String expectedLoginSuccessHomeText = "Home";
    private String expectedLoginFailureMessage = "The password that you've entered is incorrect. Forgotten password?";

    @Before
    public  void setUp() {
        loginPageService = new LoginPageService();
    }

    @After
    public  void tearDown() {
        loginPageService.closeWindow();
    }

    @Test
    public void login_fail_test() {
        loginPageService.wrongPasswordLogin(TestConstants.UNATHENTICATE_USER,TestConstants.UNATHENTICATE_PASSWORD);
        Assert.assertEquals(expectedLoginFailureMessage, loginPageService.getFailureMessage());
    }

    @Test
    public void login_success_test() {
        loginPageService.successUserLogin(TestConstants.USER,TestConstants.PASSWORD);
        Assert.assertEquals(expectedLoginSuccessHomeText, loginPageService.getSuccessButtonText());
    }
}
