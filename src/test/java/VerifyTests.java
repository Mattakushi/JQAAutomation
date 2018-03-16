import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Verify;

//@Listeners(TestMethodListener.class)
public class VerifyTests {

    @Test
    public void verifyTrueTest() {

        /* verifyTrue */
        Verify.verifyTrue(true, "test1 condition is false"); // pass
        Verify.verifyTrue(false, "test2 condition is false"); // fail (continue)
        Verify.verifyTrue(true, "test3 condition is false"); // pass
        Verify.verifyTrue(false, "test4 condition is false"); // fail (continue)
        Verify.verifyTrue(true, "test5 condition is false"); // pass
        Verify.verifyTrue(true, "test6 condition is false"); // pass
        Assert.assertTrue(false, "test7 condition is false"); // fail (exit)
        Assert.assertTrue(true, "test8 condition is false"); // not run!
        Verify.verifyTrue(true, "test9 condition is false"); // not run!
    }

}
