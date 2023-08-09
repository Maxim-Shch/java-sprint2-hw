import java.util.ArrayList;
import java.util.Iterator;

public class InformationFromReports {
    public InformationFromReports() {
    }

    public void getInfoFromAllMonths(ArrayList<MonthlyReport> monthlyReports) {
        Iterator var2 = monthlyReports.iterator();

        while(var2.hasNext()) {
            MonthlyReport curReport = (MonthlyReport)var2.next();
            if (curReport.month == 1) {
                System.out.println("Январь:");
            } else if (curReport.month == 2) {
                System.out.println("Февраль:");
            } else {
                System.out.println("Март:");
            }

            curReport.getTheMostProfitableProduct();
            curReport.getTheBiggestSpend();
        }

    }

    public void getInfoFromTheAnnualReport(YearlyReport yearlyReport) {
        System.out.println("Отчёт за 2021 год:");
        System.out.println("Прибыль за январь: " + yearlyReport.getIncomeForEveryMonthOfTheYear(1));
        System.out.println("Прибыль за февраль: " + yearlyReport.getIncomeForEveryMonthOfTheYear(2));
        System.out.println("Прибыль за март: " + yearlyReport.getIncomeForEveryMonthOfTheYear(3));
        System.out.println("Средний расход за год: " + yearlyReport.getTheAverageExpense());
        System.out.println("Средний доход за год: " + yearlyReport.getTheAverageIncome());
    }
}
