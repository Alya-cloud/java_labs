import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    public static Fraction with_brackets (String input) {
        Fraction answer;

        Pattern open = Pattern.compile("\\(");
        Pattern close = Pattern.compile("\\)");

        StringBuilder time = new StringBuilder(input);

        Matcher open_bracket = open.matcher(time);
        Matcher close_bracket = close.matcher(time);

        while (open_bracket.find() || close_bracket.find()){
            open_bracket = open.matcher(time);
            if (open_bracket.find()){
                int start = open_bracket.end();
                time.delete(start-1, start);
            } else{
                throw new IllegalArgumentException("РЎРєРѕР±РєР° Р·Р°РєСЂС‹С‚Р°, РЅРѕ РЅРµ РѕС‚РєСЂС‹С‚Р°");
            }
            close_bracket = close.matcher(time);
            if (close_bracket.find()){
                int end = close_bracket.end();
                time.delete(end-1, end);
            } else{
                throw new IllegalArgumentException("РЎРєРѕР±РєР° РѕС‚РєСЂС‹С‚Р°, РЅРѕ РЅРµ Р·Р°РєСЂС‹С‚Р°");
            }
            open_bracket = open.matcher(time);
            close_bracket = close.matcher(time);
        }

        time = new StringBuilder(input);
        StringBuilder already = new StringBuilder(input);
        open_bracket = open.matcher(time);
        close_bracket = close.matcher(time);
        int i = 0;
        while (open_bracket.find() && close_bracket.find()){
            i++;
            int start = open_bracket.end();
            int end = close_bracket.end();
            int time_start = 0;
            time.delete(0, start).delete(end-start-1, time.length());
            open_bracket = open.matcher(time);
            while (open_bracket.find()){
                time_start = open_bracket.end();
                time.delete(0, time_start);
                open_bracket = open.matcher(time);
            }
            String[] tokens = String.valueOf(time).split("\\s");
            Fraction fraction_in_bracket = evaluateExpression(tokens);
            start = start + time_start;
            if (i > 1){
                end = end+1;
            }
            already.replace(start-1, end, String.valueOf(fraction_in_bracket));
            close_bracket = close.matcher(already);
            open_bracket = open.matcher(already);
            time = new StringBuilder(already);
        }
        String[] tokens = String.valueOf(time).split("\\s");
        answer = evaluateExpression(tokens);
        return answer;
    }

    public static Fraction evaluateExpression(String[] tokens) {
        Stack<Fraction> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();


        for (String token : tokens) {
            if (token.matches("^-?\\d+/-?\\d+$")) {
                operandStack.push(parseFraction(token));
            } else if (isOperator(token)) {
                char operator = token.charAt(0);
                while (!operatorStack.isEmpty() && precedence(operator) <= precedence(operatorStack.peek())) {
                    Fraction operand2 = operandStack.pop();
                    Fraction operand1 = operandStack.pop();
                    char op = operatorStack.pop();
                    operandStack.push(applyOperator(op, operand1, operand2));
                }
                operatorStack.push(operator);
            }
        }

        while (!operatorStack.isEmpty()) {
            Fraction operand2 = operandStack.pop();
            Fraction operand1 = operandStack.pop();
            char operator = operatorStack.pop();
            operandStack.push(applyOperator(operator, operand1, operand2));
        }

        return operandStack.pop();
    }

    private static Fraction parseFraction(String input) {
        String[] parts = input.split("/");

        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);

        return new Fraction(numerator, denominator);
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static Fraction applyOperator(char operator, Fraction operand1, Fraction operand2) {
        switch (operator) {
            case '+':
                return operand1.add(operand2);
            case '-':
                return operand1.subtract(operand2);
            case '*':
                return operand1.multiply(operand2);
            case '/':
                return operand1.divide(operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}