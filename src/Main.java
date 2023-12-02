import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] expenses = new double[7];

        double rateUSD = 98.2;
        double rateEUR = 105.28;
        double rateJPY = 0.66;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней осталось до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Конвертировать валюту");
            System.out.println("2 - Получить совет");
            System.out.println("3 - Ввести трату");
            System.out.println("4 - Показать траты за неделю");
            System.out.println("5 - Показать самую большую сумму расходов за неделю");
            System.out.println("0 - Выход");
            System.out.println("-1 - Сжечь компьютер");
            System.out.println("-2 - Пойти погулять");



            int command = scanner.nextInt();

            if (command == 1) {
                convert(rateUSD, rateEUR, rateJPY, scanner, moneyBeforeSalary);

            } else if (command == 2) {
              giveadvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
               spend(scanner, moneyBeforeSalary, expenses);

            } else if (command == 4) {
                demonstrationSpendsOfTheWeek(expenses);

            } else if (command == 5) {
                demonstrationTheBiggestSpend(expenses);

            } else if (command == 0) {
                System.out.println("Выход");
                break;

            } else {
                System.out.println("Такой команды пока нет.");
            }
        }
    }

    private static void convert(double rateUSD, double rateEUR, double rateJPY, Scanner scanner, double moneyBeforeSalary) {
        System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
        System.out.println("Доступные варианты конвертации:");
        System.out.println("1 - USD");
        System.out.println("2 - EUR");
        System.out.println("3 - JPY");

        int currency = scanner.nextInt();
        if (currency == 1) {
            System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
        } else if (currency == 2) {
            System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
        } else if (currency == 3) {
            System.out.println("Ваши сбережения в иенах: " + moneyBeforeSalary / rateJPY);
        } else {
            System.out.println("Неизвестная валюта");
        }
    }
    private static void giveadvice(double moneyBeforeSalary, int daysBeforeSalary) {
        if (moneyBeforeSalary < 3000) {
            System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты.");
        } else if (moneyBeforeSalary < 10000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Окей, пора в Макдак!");
            } else {
                System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты.");
            }
        } else if (moneyBeforeSalary < 30000) {
            if (daysBeforeSalary < 10) {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место.");
            } else {
                System.out.println("Окей, пора в Макдак!");
            }
        } else {
            if (daysBeforeSalary < 10) {
                System.out.println("Отлично! Заказывайте крабов!");
            } else {
                System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место.");
            }
        }
    }
    private static void spend(Scanner scanner, double moneyBeforeSalary, double[] expenses) {
        System.out.println("За какой день вы хотите ввести трату?");
        System.out.println("1 - Понедельник");
        System.out.println("2 - Вторник");
        System.out.println("3 - Среда");
        System.out.println("4 - Четверг");
        System.out.println("5 - Пятница");
        System.out.println("6 - Суббота");
        System.out.println("7 - Воскресенье");
        int day = scanner.nextInt();

        System.out.println("Введите размер траты:");
        double expense = scanner.nextDouble();
        moneyBeforeSalary = moneyBeforeSalary - expense;
        expenses[day - 1] = expenses[day - 1] + expense;
        System.out.println("Значение сохранено! Ваш текующий баланс " + moneyBeforeSalary + " рублей.");

        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
    }
    private static void demonstrationSpendsOfTheWeek(double[] expenses) {
        for (int i = 0; i < expenses.length; i++) {
            System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей.");
        }
    }
    private static void demonstrationTheBiggestSpend(double[] expenses) {
        double maxExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
            }
        }
        System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");

    }
}