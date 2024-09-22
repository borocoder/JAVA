public class Main {

    // 1. FizzBuzz
    public static String fizzBuzz(int number) {
        if (number % 35 == 0) {
            return "fizzbuzz";
        } else if (number % 5 == 0) {
            return "fizz";
        } else if (number % 7 == 0) {
            return "buzz";
        } else {
            return String.valueOf(number);
        }
    }

    // 2. Reverse string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // 3. Quadratic equation solver
    public static String solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return "нет вещественных корней";
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return "Корень: " + root;
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return "Корни: " + root1 + ", " + root2;
        }
    }

    // 4. Sum of the series
    public static double sumSeries() {
        double sum = 0;
        int n = 2;
        double term;
        do {
            term = 1.0 / (n * n + n - 2);
            sum += term;
            n++;
        } while (term >= 1e-6);
        return sum;
    }

    // 5. Palindrome checker
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Пример вызовов функций

        // 1. FizzBuzz для чисел от 1 до 500
        for (int i = 1; i <= 500; i++) {
            System.out.println(fizzBuzz(i));
        }

        // 2. Reverse string
        System.out.println(reverseString("make install"));

        // 3. Решение квадратного уравнения
        System.out.println(solveQuadraticEquation(1, -3, 2)); // Дискриминант > 0
        System.out.println(solveQuadraticEquation(1, 2, 1)); // Дискриминант == 0
        System.out.println(solveQuadraticEquation(1, 1, 1)); // Дискриминант < 0

        // 4. Сумма ряда
        System.out.println(sumSeries());

        // 5. Проверка на палиндром
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("hello")); // false
    }
}