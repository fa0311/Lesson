/* Java応用 例外処理演習 */

public class DivideByZeroMsg {
    public static void main(String[] args) {
        int num = 10;
        int denom = 0;

        try {
            num = num / denom;
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            System.out.println("エラーが発生しました。");
        }
    }
}
