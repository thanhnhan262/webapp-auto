package util;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;

public class ErrorHandler {
    public static void pass(String message) {
        ExtentTest step = ReportFactory.getStep();
        step.pass(message);
    }

    public static void fail(String message) {
        ExtentTest step = ReportFactory.getStep();
        step.fail(message);
        captureScreen();
    }

    public static void failAndStop(String message) {
        ExtentTest step = ReportFactory.getStep();
        step.fail(message);
        captureScreen();
        Assert.fail(); //stop run current test case
    }

    public static void warn(String message) {
        ExtentTest step = ReportFactory.getStep();
        step.warning(message);
        captureScreen();
    }

    public static void info(String message) {
        ExtentTest step = ReportFactory.getStep();
        step.info(message);
    }

    private static void captureScreen() {

    }
}
