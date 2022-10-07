/* Java応用 */
class Aisatsu {
    public static void main(String[] args) {
        // メソッドを呼び出す
        message(1);
        message(2);
        message(3);
    }

    // メソッドを定義する
    static void message(int n) {
        switch (n) {
            case 1:
                System.out.println("おはよう。");
                break;
            case 2:
                System.out.println("こんにちは。");
                break;
            case 3:
                System.out.println("こんばんは。");
                break;
        }
    }
}