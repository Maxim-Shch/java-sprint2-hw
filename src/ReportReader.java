import java.util.ArrayList;

public class ReportReader {
    FileReader fileReader = new FileReader();

    public ReportReader() {
    }

    public ArrayList<MonthlyReport> readAllMonthlyReports() {
        int month = 1;
        ArrayList<MonthlyReport> reports = new ArrayList();

        for(int i = 1; i <= 3; ++i) {
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.reportData = this.readMonthlyReport("m.20210" + i + ".csv");
            monthlyReport.month = month++;
            reports.add(monthlyReport);
        }

        return reports;
    }

    public ArrayList<Transaction> readMonthlyReport(String path) {
        ArrayList<String> lines = this.fileReader.readFileContents(path);
        ArrayList<Transaction> monthDates = new ArrayList();

        for(int i = 1; i < lines.size(); ++i) {
            String line = (String)lines.get(i);
            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unitPrice = Integer.parseInt(parts[3]);
            Transaction monthData = new Transaction(itemName, isExpense, quantity, unitPrice);
            monthDates.add(monthData);
        }

        return monthDates;
    }

    public ArrayList<YearlyData> readYearlyReport(String path) {
        ArrayList<String> lines = this.fileReader.readFileContents(path);
        ArrayList<YearlyData> yearlyData = new ArrayList();

        for(int i = 1; i < lines.size(); ++i) {
            String line = (String)lines.get(i);
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            yearlyData.add(new YearlyData(month, amount, isExpense));
        }

        return yearlyData;
    }

    public YearlyReport getYearlyReport() {
        YearlyReport yearlyReport = new YearlyReport();
        yearlyReport.yearlyData = this.readYearlyReport("y.2021.csv");
        return yearlyReport;
    }
}