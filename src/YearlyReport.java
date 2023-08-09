import java.util.ArrayList;

public class YearlyReport
{
    ArrayList<YearlyData> yearlyData;

    public int getIncomeForEveryMonthOfTheYear(final int numberMonth) {
        int income = 0;
        for (final YearlyData currentData : this.yearlyData) {
            if (currentData.month == numberMonth && !currentData.isExpense) {
                income += currentData.amount;
            }
        }
        return income;
    }

    public int getExpenseForEveryMonthOfTheYear(final int numberMonth) {
        int expense = 0;
        for (final YearlyData currentData : this.yearlyData) {
            if (currentData.month == numberMonth && currentData.isExpense) {
                expense += currentData.amount;
            }
        }
        return expense;
    }

    public int getTheAverageExpense() {
        int averageExpense = 0;
        int numberOfOperations = 0;
        for (final YearlyData currentData : this.yearlyData) {
            if (currentData.isExpense) {
                averageExpense += currentData.amount;
                ++numberOfOperations;
            }
        }
        return averageExpense / numberOfOperations;
    }

    public int getTheAverageIncome() {
        int averageIncome = 0;
        int numberOfOperations = 0;
        for (final YearlyData currentData : this.yearlyData) {
            if (!currentData.isExpense) {
                averageIncome += currentData.amount;
                ++numberOfOperations;
            }
        }
        return averageIncome / numberOfOperations;
    }
}
