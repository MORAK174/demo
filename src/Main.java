import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 3 + 5):");

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.exit(1);
            }
        }
        scanner.close();
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s+", "");

        String regex = "(\\d+)([+\\-*/])(\\d+)";

        if (!input.matches(regex)) {
            throw new Exception("Неверный формат ввода");
        }

        String[] parts = input.split("(?<=\\d)(?=[+\\-*/])|(?<=[+\\-*/])(?=\\d)");

        int num1 = Integer.parseInt(parts[0]);
        char operation = parts[1].charAt(0);
        int num2 = Integer.parseInt(parts[2]);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10");
        }

        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неверная операция");
        }

        return String.valueOf(result);
    }
}