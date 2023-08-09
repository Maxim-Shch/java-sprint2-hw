import java.util.ArrayList;

public class MonthlyReport
{
    int month;
    ArrayList<Transaction> reportData;

    public int getTheAmountOfIncome() {
        int incomeSum = 0;
        for (final Transaction transaction : this.reportData) {
            if (!transaction.isExpense) {
                incomeSum += transaction.quantity * transaction.unitPrice;
            }
        }
        return incomeSum;
    }

    public int getTheAmountOfExpenses() {
        int expenseSum = 0;
        for (final Transaction transaction : this.reportData) {
            if (transaction.isExpense) {
                expenseSum += transaction.quantity * transaction.unitPrice;
            }
        }
        return expenseSum;
    }

    public void getTheMostProfitableProduct() {
        int sumProduct = 0;
        String nameProduct = "";
        for (final Transaction transaction : this.reportData) {
            final String curNameProduct = transaction.itemName;
            final int curSumProduct = transaction.quantity * transaction.unitPrice;
            if (!transaction.isExpense && curSumProduct > sumProduct) {
                sumProduct = curSumProduct;
                nameProduct = curNameProduct;
            }
        }
        System.out.println("Самый прибыльный товар за месяц: " + nameProduct + ". Продано на сумму: " + sumProduct);
    }

    public void getTheBiggestSpend() {
        int theLargestAmount = 0;
        String nameProduct = "";
        for (final Transaction transaction : this.reportData) {
            final String curNameProduct = transaction.itemName;
            final int curSumProduct = transaction.quantity * transaction.unitPrice;
            if (transaction.isExpense && curSumProduct > theLargestAmount) {
                theLargestAmount = curSumProduct;
                nameProduct = curNameProduct;
            }
        }
        System.out.println("Самая большая трата на товар за месяц: " + nameProduct + ". Потрачена сумма: "
                + theLargestAmount);
    }
}