package util;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String reportName = result.getMethod().getMethodName() + ".html";
        System.out.println(reportName);
        ReportFactory.createReport(reportName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportFactory.writeReport();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportFactory.writeReport();
    }
}
