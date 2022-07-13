public class method {
    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
    }

    public static void message() {
        System.out.println("Hello.");
        System.out.println("Hello.");
        System.out.println("Hello.");
    }

    public static void message2() {
        System.out.println("Good bye.");
        System.out.println("Good bye.");
        System.out.println("Good bye.");
    }

    public static double power(double m, int n) {
        double result = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result = result * m;
            }
        } else {
            for (int i = 0; i < n * -1; i++) {
                result = result / m;
            }
        }
        return result;
    }

    public static int square(int n) {
        if (n > 0) {
            return n * n;
        } else {
            return n * n * -1;
        }
    }

    public static double square(double n) {
        if (n > 0) {
            return n * n;
        } else {
            return n * n * -1.0;
        }
    }

    public static int min(int n1, int n2) {
        if (n1 < n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static int min(int n1, int n2, int n3) {
        return min(n1, min(n2, n3));
    }
}
