public class k05 {

    public static void main(String[] args) {
        myname();
        disp_10();
        check_num(10);
        max_num(10, 20);
        max_num3(10, 20, 30);
        is_prime_number(1);
        is_prime_number(31);
    }

    public static void myname() {
        System.out.println("幸 晴一");
    }

    public static void disp_10() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void check_num(int x) {
        if (x >= 0) {
            System.out.println(x + "はプラスの数です");
        } else {
            System.out.println(x + "はマイナスの数です");
        }
    }

    public static void max_num(int x, int y) {
        if (x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }

    public static int max_num3(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public static void max_num3(int x, int y, int z) {
        System.out.println(max_num3(x, max_num3(y, z)));

    }

    public static void is_prime_number(int x) {
        if (x < 2) {
            System.out.println(x + "は2未満の数です");
            return;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                System.out.println(x + "は素数ではありません");
                return;
            }
        }
        System.out.println(x + "は素数です");
    }
}
