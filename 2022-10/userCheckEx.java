
/* Java応用 */
import java.util.Scanner;

class userCheckEx {
    static final String userID = "ivy"; // ユーザID
    static final String userPW = "12345"; // パスワード

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int info;

        do {
            System.out.print("ユーザーIDを入力してください >");
            String id = scanner.next();
            System.out.print("パスワードを入力してください >");
            int pw = scanner.nextInt();
            info = checkUserInfo(id, pw);

            if (info == 0) {
                System.out.println("ユーザー情報が一致しました");
            } else {
                System.out.println("ユーザー情報が一致しませんでした");
            }
            System.out.println();
        } while (info != 0);
        scanner.close();
    }

    /*
     * ユーザIDとパスワードの両方が一致したら、数値で結果を返却する
     * ①ユーザID 〇 / パスワード 〇 結果 0を返却する
     * ②ユーザID × / パスワード 〇 結果 1を返却する
     * ③ユーザID 〇 / パスワード × 結果 2を返却する
     * ④ユーザID × / パスワード × 結果 3を返却する
     */
    static int checkUserInfo(String iptId, int iptPw) {
        int ret = -1;
        if (userID.equals(iptId)) {
            if (userPW.equals(Integer.toString(iptPw))) {
                ret = 0;

            } else {
                ret = 2;
            }
        } else {
            if (userPW.equals(Integer.toString(iptPw))) {
                ret = 1;
            } else {
                ret = 3;
            }
        }
        return ret;
    }
}