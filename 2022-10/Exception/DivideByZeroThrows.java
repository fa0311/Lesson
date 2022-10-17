/* Java応用 例外処理演習 */

class DivideByZeroThrows {
    public static void main(String[] args) {
        int num = 10;
        int ans1 = 0;
        int ans2 = 0;

        try {
            ans1 = div(num, 0);
            ans2 = div(num, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ans1=" + ans1);
            System.out.println("ans2=" + ans2);
        }
    }

    static int div(int x, int y) throws ArithmeticException {
        return x / y;
    }
}
