import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Fraction Calculator!");

        while (true) {

            Pattern good = Pattern.compile("[0-9]+" + "/" + "[0-9]+");
            Matcher frac;
            String input;
            int i = 0;

            do {
                if (i > 0){
                    System.out.println("Try again");
                    System.out.println();
                }
                i++;
                System.out.print("Enter an expression (or \"quit\" to exit): ");
                input = scanner.nextLine();
                frac = good.matcher(input);
            } while (!frac.find());

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            try{
                Fraction result;
                if (input.contains("(") || input.contains(")")){
                    result = InputHandler.with_brackets(input);
                }else{
                    String[] tokens = input.split("\\s");
                    result = InputHandler.evaluateExpression(tokens);
                }
                System.out.println("Result: " + result);
            }catch (IllegalArgumentException ex){
                System.err.println(ex.getMessage());
            }

            System.out.println();

        }
        scanner.close();
    }
}