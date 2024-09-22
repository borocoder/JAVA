import java.util.Scanner;

// Козырев Лаба 1

public class Main {
    public static void main(String[] args) {
        // Задание 1
        for (int i = 1; i <= 500; i++) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.println("fizz");
            } else if (i % 7 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }

        // Задание 2
        String str = "make install";
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println(reversedStr);

        // Задание 3
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();
        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;
        if (discriminant >= 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни уравнения: " + root1 + ", " + root2);
        } else {
            System.out.println("Нет вещественных корней");
        }

        // Задание 4
        double sum = 0;
        double term = 1;
        int n = 2;
        while (term >= Math.pow(10, -6)) {
            sum += term;
            term = 1 / (Math.pow(n, 2) + n - 2);
            n++;
        }
        System.out.println("Сумма ряда: " + sum);

        // Задание 5
        System.out.print("Введите строку: ");
        scanner.nextLine(); // очистка буфера ввода
        String inputString = scanner.nextLine();
        String cleanString = inputString.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
        String reversedString = new StringBuilder(cleanString).reverse().toString();
        if (cleanString.equals(reversedString)) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }
    }
}