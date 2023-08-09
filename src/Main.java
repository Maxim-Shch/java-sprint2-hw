import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportReader reportReader = new ReportReader();
        ReportCompare reportCompare = new ReportCompare();
        InformationFromReports informationFromReports = new InformationFromReports();
        ArrayList<MonthlyReport> monthlyReports = new ArrayList();
        YearlyReport yearlyReport = new YearlyReport();

        while(true) {
            while(true) {
                printMenu();
                int command = scanner.nextInt();
                if (command == 1) {
                    monthlyReports = reportReader.readAllMonthlyReports();
                    System.out.println("Месячные отчёты считаны успешно!");
                } else if (command == 2) {
                    yearlyReport = reportReader.getYearlyReport();
                    System.out.println("Годовой отчёт считан успешно!");
                } else if (command == 3) {
                    if (!monthlyReports.isEmpty() && yearlyReport != null) {
                        reportCompare.compareMonthlyAndYearlyReports(yearlyReport, monthlyReports);
                        System.out.println("Сверка отчётов успешно пройдена!");
                    } else {
                        System.out.println("Необходимо считать все отчёты перед их сверкой.");
                    }
                } else if (command == 4) {
                    if (monthlyReports.isEmpty()) {
                        System.out.println("Необходимо считать все отчёты перед их печатью!");
                    } else {
                        System.out.println("Информация из месячных отчётов:");
                        informationFromReports.getInfoFromAllMonths(monthlyReports);
                    }
                } else if (command == 5) {
                    if (yearlyReport == null) {
                        System.out.println("Необходимо считать годовой отчёт перед печатью!");
                    } else {
                        System.out.println("Информация из годового отчёта");
                        informationFromReports.getInfoFromTheAnnualReport(yearlyReport);
                    }
                } else {
                    if (command == 0) {
                        System.out.println("Выйти из приложения");
                        return;
                    }

                    System.out.println("Такой команды не существует, просьба указать команду повторно:");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите пункт:");
        System.out.println("1 - Считать все месячные отчёты;");
        System.out.println("2 - Считать годовой отчёт;");
        System.out.println("3 - Сверить отчёты;");
        System.out.println("4 - Информация из месячных отчётов;");
        System.out.println("5 - Информация из годового отчёта;");
        System.out.println("0 - Выйти из приложения.");
    }
}
