import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;

public class Test {

    @org.testng.annotations.Test
    public void testReport() {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        ExtentTest logger = extent.createTest("MyFirstTest");
        logger.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        logger.log(Status.FAIL, "This is fail step");
        try {
            Assert.assertEquals("aaa", "AAA", "Verify an error message is displayed");
        }catch (AssertionError ex) {
            System.out.println(">>>>>>>>>>>>>>>>>>");
            logger.log(Status.FAIL, ex.toString());
        }
        extent.flush();

        ExtentTest tc2 = extent.createTest("Test case #2");
        tc2.log(Status.INFO, "step 111111111111111");
        tc2.log(Status.INFO, "step 2222");
        extent.flush();

        ExtentTest tc3 = extent.createTest("Test case #3");
        tc3.log(Status.INFO, "step 111111111111111");
        tc3.log(Status.PASS, "Passssssssssssssssssssssssss");
        tc3.log(Status.FAIL, "Failedddd");
        tc3.log(Status.INFO, "step 2222");
        extent.flush();
    }

    public void clickCancelButton() {

    }

    public void step(String stepDes) {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        ExtentTest logger = extent.createTest("MyFirstTest");
        logger.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
    }
}
