import java.util.ArrayList;
import java.util.Iterator;

public class ReportCompare {
    public ReportCompare() {
    }

    public void compareMonthlyAndYearlyReports(YearlyReport yearlyReports, ArrayList<MonthlyReport> monthlyReports) {
        this.cashIncome(yearlyReports, monthlyReports);
        this.cashExpenses(yearlyReports, monthlyReports);
    }

    public void cashIncome(YearlyReport yearlyReports, ArrayList<MonthlyReport> monthlyReports) {
        Iterator var3 = monthlyReports.iterator();

        while(var3.hasNext()) {
            MonthlyReport reportForTheCurrentMonth = (MonthlyReport)var3.next();
            int monthlyIncome = reportForTheCurrentMonth.getTheAmountOfIncome();
            int incomeForTheYear = yearlyReports.getIncomeForEveryMonthOfTheYear(reportForTheCurrentMonth.month);
            if (monthlyIncome != incomeForTheYear) {
                System.out.println("Выявлена ошибка при сравнении доходов в месяце " + reportForTheCurrentMonth.month);
            }
        }

    }

    public void cashExpenses(YearlyReport yearlyReports, ArrayList<MonthlyReport> monthlyReports) {
        Iterator var3 = monthlyReports.iterator();

        while(var3.hasNext()) {
            MonthlyReport reportForTheCurrentMonth = (MonthlyReport)var3.next();
            int monthlyExpense = reportForTheCurrentMonth.getTheAmountOfExpenses();
            int expenseForTheYear = yearlyReports.getExpenseForEveryMonthOfTheYear(reportForTheCurrentMonth.month);
            if (monthlyExpense != expenseForTheYear) {
                System.out.println("Выявлена ошибка при сравнении доходов в году " + reportForTheCurrentMonth.month);
            }
        }

    }
}