import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    ;

    public static void main(String[] args) {
        taskOne();
    }

    public static void taskOne() {

        System.out.print("День рождения: ");
        int birthDay = sc.nextInt();

        System.out.print("Месяц рождения: ");
        int birthMonth = sc.nextInt();

        System.out.print("Год рождения: ");
        int birthYear = sc.nextInt();

        int currentDay = 17;
        int currentMonth = 11;
        int currentYear = 2022;

        int daysLeft, monthLeft, yearsLeft;

        yearsLeft = currentYear - birthYear;
        if (currentMonth < birthMonth || (birthMonth == currentMonth && birthDay < currentDay)) yearsLeft--;

        boolean isCurrentDayLower = false;
        if (currentDay >= birthDay) {
            daysLeft = currentDay - birthDay;
        } else {
            isCurrentDayLower = true;
            daysLeft = 30 - (birthDay - currentDay);
        }

        int subtractionOfMonth = Math.abs(currentMonth - birthMonth);
        if ((birthMonth == currentMonth && birthDay > currentDay) || birthMonth > currentMonth) {
            monthLeft = 12 - subtractionOfMonth;
        } else {
            monthLeft = subtractionOfMonth;
        }

        if (isCurrentDayLower) monthLeft--;

        System.out.println(yearsLeft + " лет, " + monthLeft + " месяцев и " + daysLeft + " дней");
        sc.close();

    }

    public static void taskTwo() {
        System.out.println("День:");
        int day = sc.nextInt();
        System.out.println("Месяц:");
        int month = sc.nextInt();
        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Зима");
        }
        if (month == 3 || month == 4 || month == 5) {
            System.out.println("Весна");
        }
        if (month == 6 || month == 7 || month == 8) {
            System.out.println("Лето");
        }
        if (month == 9 || month == 10 || month == 11) {
            System.out.println("Осень");
        }
        sc.close();
    }

    public static void taskThree() {
        System.out.print("x: ");
        int x = sc.nextInt();
        System.out.print("n: ");
        int result = x;
        int n = sc.nextInt();
        for (int i = 1; i < Math.abs(n); i++) {
            result *= x;
        }
        if (n > 0) {
            System.out.println(result);
        } else {
            System.out.println((double) 1 / result);
        }
        sc.close();
    }

    public static void taskFour() {
        System.out.print("Количество точек: ");
        int dots = sc.nextInt();
        System.out.print("Радиус окружности: ");
        int r = sc.nextInt();
        int dotsInCircle = 0;
        for (int i = 1; i <= dots; i++) {
            System.out.print("X " + i + " точки: ");
            double x = sc.nextDouble();
            System.out.print("Y " + i + " точки: ");
            double y = sc.nextDouble();
            if (x * x + y * y <= r * r) {
                dotsInCircle++;
            }
        }
        System.out.println(dotsInCircle + " точек попали в окружность");
        sc.close();
    }
}