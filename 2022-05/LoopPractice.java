public class LoopPractice {
    public static void main(String[] args) {
        /*
         * int i = 0;
         * for (; i < 5;) {
         * System.out.println("こんにちは");
         * }
         * int i = 0;
         * while (i < 5) {
         * System.out.println("Hello");
         * i++;
         * }
         * int i = 5;
         * do {
         * System.out.println("こんにちは");
         * i--;
         * } while (i > 0);
         * for (int i = 1; i < 10; i++) {
         * for (int j = 1; j < 10; j++) {
         * System.out.print(i * j);
         * System.out.print(" ");
         * }
         * System.out.println();
         * }
         * int i = 10;
         * int ans = 20;
         * while (i >= 0) {
         * ans = ans - 3;
         * if (ans < 0) {
         * break;
         * }
         * System.out.println(ans);
         * i--;
         * }
         */
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
