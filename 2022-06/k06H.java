public class k06H {

    public static void main(String[] args) {
        check(5);
        check(10);
        check(15);
        print_x(7);
        print_x(-7);
        print_x(-10);
        System.out.println("1～5までの合計は" + sum_x(5));
        System.out.println("1～10までの合計は" + sum_x(10));
        System.out.println("1～20までの合計は" + sum_x(20));
    }

    public static void check(int x) {
        if (x % 2 == 0) {
            System.out.println("偶数です");
        } else {
            System.out.println("奇数です");
        }
    }

    public static void print_x(int x) {
        if (x > 0) {
            for (int i = 0; i <= x; i++) {
                System.out.print(i);
            }
        } else {
            for (int i = 0; i >= x; i--) {
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static int sum_x(int x) {
        int ans = 0;
        for (int i = 0; i <= x; i++) {
            ans += i;
        }
        return ans;
    }

}
