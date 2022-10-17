/* Java応用 例外処理演習 */

class DivideByZeroErr {
    public static void main(String[] args) {
        int num = 10;
        int denom = 0;
        num = num / denom;
        System.out.println(num);
    }
}
