import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.tensorflow.lite.examples.styletransfer.LoginActivity;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Test
    public void test_validate() {
        LoginActivity login_activity = new LoginActivity();
        Boolean result = login_activity.validate("vaibhav@gmail.com", "123456");
        assertTrue(result);
        result = login_activity.validate("vaibhav@gmail", "123456");
        assertFalse(result);
        result = login_activity.validate("vaibhav@gmail.com", "123");
        assertFalse(result);
        result = login_activity.validate("vaibhav@gmail.com", "12345678912");
        assertFalse(result);
    }

}