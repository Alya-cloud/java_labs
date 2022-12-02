import java.util.Scanner;

public class LabTwo {

    private Scanner scan = new Scanner(System.in);

    public void taskOne() {
        String days30 = "(0{0,1}[1-9]|[12][0-9]|30)";
        String days31 = "(0{0,1}[1-9]|[12][0-9]|3[01])";
        String days28 = "(0{0,1}[1-9]|1[0-9]|2[0-8])";
        String month30 = "(0{0,1}(4|6|9)|11)";
        String month31 = "(0{0,1}(1|3|5|7|8)|1(0|2))";
        String years = "(19|[2-9][0-9])\\d{2}$";
        String dateRegex = "((" + days30 + "/" + month30 + ")|(" + days31 + "/" + month31 + ")|(" + days28 + "/02))/" + years;
        System.out.print("Дата: ");
        String input = scan.nextLine();
        boolean isMatched = input.matches(dateRegex);
        if (!isMatched) {
            if (input.charAt(2) != '/' || input.charAt(5) != '/') {
                System.out.println("Введенное выражение не соответствует заданному формату даты dd/mm/yyyy");
            } else {
                System.out.println("Введенное выражение не является датой");
            }
        } else {
            System.out.println("Введенное выражение является датой");
        }
    }

    public void taskTwo() {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$";
        System.out.print("Пароль: ");
        String input = scan.nextLine();
        if (!input.matches(passwordRegex)) {
            System.out.println("Пароль ненадежен. Повторите ввод ");
        } else {
            System.out.println("Пароль надежен ");
        }
    }
}

