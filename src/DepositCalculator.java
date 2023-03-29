import java.util.Scanner;

public class DepositCalculator {
    //расчёт суммы вклада с ежемесячной капитализацией
    double calculateComplexPercent(double depositAmount, double depositRate, int depositPeriod) {
        double newDepositAmount = depositAmount * Math.pow((1 + depositRate / 12), 12 * depositPeriod);
        return round(newDepositAmount, 2);
    }

    //расчёт суммы вклада с ежегодным начислением процентов без капитализации
    double calculateSimplePercent(double depositAmount, double depositRate, int depositPeriod) {
        double newDepositAmount = depositAmount + depositAmount * depositRate * depositPeriod;
        return round(newDepositAmount, 2);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    //ввод пареметров вклада и расчёт его остатка по окончании срока вклада
    void calculatePercent() {
        int depositPeriod;
        int depositType;
        int depositAmount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        double newDepositAmount = 0;
        if (depositType == 1) {
            newDepositAmount = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            newDepositAmount = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod
                + " лет превратятся в " + newDepositAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePercent();
    }


}
