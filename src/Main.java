import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);;

    public static void main(String[] args) {
        
    }

    public static void taskOne() {
        System.out.print("День рождения: ");
        int day = sc.nextInt();
        System.out.print("Месяц рождения: ");
        int month = sc.nextInt();
        System.out.print("Год рождения: ");
        int year = sc.nextInt();
        int currentDay = 17;
        int currentMonth = 11;
        int currentYear = 2022;

        year = currentYear - year;
        if (currentMonth < month || (month == currentMonth && day > currentDay)) year -= 1;

        boolean isCurrentDayLower = false;
        if (currentDay >= day) {
            day = currentDay - day;
        } else {
            day = 30 - (day - currentDay);
            isCurrentDayLower = true;
        }

        if (currentMonth >= month) {
            month = currentMonth - month;
            if (isCurrentDayLower) month = 12 - month - 1;
        } else {
            month = 12 - (month - currentMonth);
        }

        System.out.println(year + " лет, " + month + " месяцев и " + day + " дней");

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
        if(n>0){
            System.out.println(result);
        } else {
            System.out.println((double) 1/result);
        }
    }

    public static void taskFour() {
        System.out.print("Количество точек: ");
        int dots = sc.nextInt();
        int dotsInCircle = 0;
        for(int i = 1; i <= dots; i++){
            System.out.println("X" );
        }

        System.out.println(dotsInCircle + " точек попали в окружность");
    }
}