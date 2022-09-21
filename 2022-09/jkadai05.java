/* Java応用 課題05 */
class jkadai05 {
    public static void main(String[] args) {
        int even = 12;
        int odd = 7;
        System.out.println(even + "は" + checkEvenCheck(even) + "です");
        System.out.println(odd + "は" + checkEvenCheck(odd) + "です");
    }

    /*
     * 偶数か奇数かを判定し、文字列を返す
     */
    static String checkEvenCheck(int num) {
        String result;
        if (num % 2 == 0) {
            result = "偶数"; // 偶数
        } else {
            result = "奇数"; // 奇数
        }
        return result;
    }
}