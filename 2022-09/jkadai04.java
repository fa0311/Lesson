/* Java応用 課題04 */
class jkadai04 {
    public static void main(String[] args) {
        int even = 8;
        int odd = 5;
        if (isEvenCheck(even)) {
            System.out.println(even + "は偶数です");
        } else {
            System.out.println(even + "は奇数です");
        }
        if (isEvenCheck(odd)) {
            System.out.println(odd + "は偶数です");
        } else {
            System.out.println(odd + "は奇数です");
        }
    }

    /*
     * 偶数かどうか判定する
     * true = 偶数
     * false = 奇数
     */
    static boolean isEvenCheck(int num) {
        boolean result = true;
        if (num % 2 == 0) {
            result = true; // 偶数
        } else {
            result = false; // 奇数
        }
        return result;
    }
}