package utils;

import org.testng.Assert;

public class Verify {


    static public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            addToErrorBuffer(e);
        }
    }

    static public void verifyTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            addToErrorBuffer(e);
        }
    }

    static public void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError e) {
            addToErrorBuffer(e);
        }
    }

    static public void verifyFalse(boolean condition) {
        try {
            Assert.assertFalse(condition);
        } catch (AssertionError e) {
            addToErrorBuffer(e);
        }
    }

    private static void addToErrorBuffer(AssertionError e) {

        try {

            Error verificationError = new Error(e.getMessage());

            verificationError.setStackTrace(e.getStackTrace());

            TestMethodErrorBuffer.get().add(verificationError);

        } catch (NullPointerException ex) {

            throw new RuntimeException(
                    "Please let TestNG know about " + TestMethodListener.class.getName()
                            + " listener for verify statements to work. For more information go to http://testng.org/doc/documentation-main.html#testng-listeners");
        }

    }
}
