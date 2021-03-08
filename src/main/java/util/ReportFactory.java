package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class ReportFactory {
    static public Map<Long, ExtentReports> reportMap = new HashMap<>();
    static public Map<Long, ExtentTest> currentTestMap = new HashMap<>();
    static public Map<Long, ExtentTest> currentStepMap = new HashMap<>();

    static public ExtentReports getReport() {
        ExtentReports extentReports = reportMap.get(Thread.currentThread().getId());
        if(extentReports == null) {
//            throw new Exception("Report is not created, please do it !");
            System.out.println("Report is not created, please do it !");
        }
        return extentReports;
    }

    static public void createReport(String reportFileName){
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("report/" + reportFileName + ".html");
        extentReports.attachReporter(reporter);
        reportMap.put(Thread.currentThread().getId(), extentReports);
    }

    static public void writeReport() {
        reportMap.get(Thread.currentThread().getId()).flush();
        reportMap.remove(Thread.currentThread().getId());
    }

    static public void createTest(String testName) {
        ExtentTest node = getReport().createTest(testName);
        currentTestMap.put(Thread.currentThread().getId(), node);
    }

    static public ExtentTest getTest() {
        ExtentTest test = currentTestMap.get(Thread.currentThread().getId());
        return test;
    }

    static public void createStep(String stepName) {
        ExtentTest node = getTest().createNode(stepName);
        currentStepMap.put(Thread.currentThread().getId(), node);
    }

    static public ExtentTest getStep() {
        ExtentTest step = currentStepMap.get(Thread.currentThread().getId());
        return step;
    }
}
