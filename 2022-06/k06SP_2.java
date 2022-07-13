import java.util.Scanner;
import java.util.Random;

// 2時間以上余裕があったのでかなり変更した

class k06SP_2 {
    final static boolean DEBUG = false;
    static int config_digits = 4;
    static int trial_count = 20;
    static Scanner scan = new Scanner(System.in);

    // 数値の入力を行う
    // 入力値はreturnで戻ってくる
    static int input_num() {
        return scan.nextInt();
    }

    // 配列を0で初期化する処理
    static void init(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    // 重複確認
    static int contains(int list1[], int list2[]) {
        int hit = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int ii = 0; ii < list2.length; ii++) {
                if (i == ii) {
                    continue;
                } else if (list1[i] == list2[ii]) {
                    hit++;
                    break;
                }
            }
        }
        return hit;
    }

    static int contains(int list[]) {
        return contains(list, list);
    }

    static void to_array(int list[], int number) {
        int digit = 10;
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = number % digit * 10 / digit;
            digit *= 10;
        }
    }

    // 問題の配列qに0～9の数字をランダムに入れる
    // 数値は重複がないようにセットされる
    static void set_q(int q[]) {
        Random random = new Random();
        while (contains(q) > 0) {
            // 0～9の乱数をセット
            to_array(q, random.nextInt(pow(10, config_digits)));
        }
    }

    // 引数で渡された配列を表示する
    static void disp(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    // 回答の配列aに0～9の数字を入力する
    // 数値は重複がないようにチェックされる
    static void set_a(int a[]) {
        while (true) {
            int input = input_num();
            to_array(a, input);
            if (input >= pow(10, config_digits)) {
                System.out.println(config_digits + "桁の数字を入力してください");
            } else if (input < pow(10, config_digits - 2)) {
                System.out.println(config_digits + "桁の数字を入力してください");
            } else if (contains(a) > 0) {
                System.out.println("重複があります");
            } else {
                return;
            }
        }
    }

    static int pow(int number, int digit) {
        int ans = 1;
        for (int i = 0; i < digit; i++) {
            ans *= number;
        }
        return ans;
    }

    // hitの数を確認してreturnで返す
    static int hit_check(int q[], int a[]) {
        int hit = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == a[i]) {
                hit++;
            }
        }
        return hit;
    }

    // blowの数を確認してreturnで返す
    static int blow_check(int q[], int a[]) {
        return contains(q, a);
    }

    // main関数
    public static void main(String[] args) {

        System.out.println("Hit and Blowのゲームをします");

        System.out.println("難易度を入力してください 1-4");
        switch (input_num()) {
            case 1:
                config_digits = 3;
                trial_count = 20;
                break;
            case 2:
                config_digits = 4;
                trial_count = 20;
                break;
            case 3:
                config_digits = 4;
                trial_count = 10;
                break;
            case 4:
                config_digits = 6;
                trial_count = 20;
            default:
                System.out.println("入力値が不正です");
                return;
        }

        int q[] = new int[config_digits]; // 問題
        int a[] = new int[config_digits]; // 解答

        init(q); // 問題の初期化
        init(a); // 回答の初期化

        int hit = 0; // hitの数
        int blow = 0; // blowの数
        int cnt = 0; // 入力回数

        set_q(q); // 問題のセット

        System.out.println(trial_count + "回以内に" + config_digits + "hitを目指してください\n\n");

        if (DEBUG) {
            System.out.print("正解は");
            disp(q);
            System.out.println();
        }

        while (hit < config_digits && cnt < trial_count) {

            cnt++; // 入力回数+1

            // 入力の処理
            System.out.println(cnt + " 回目の入力");
            set_a(a);

            // hitとblowのチェック
            hit = hit_check(q, a);
            blow = blow_check(q, a);

            System.out.println("\n\n\n\n");
            System.out.print("入力した数：");
            disp(a);
            System.out.println("\n");
            System.out.println("  hit :" + hit);
            System.out.println("  blow:" + blow + "\n\n");
        }

        // 結果の表示
        System.out.print("正解：");
        disp(q);
        System.out.println("\n");
        if (hit == config_digits) {
            System.out.print(cnt + " 回で正解しました\n");
        } else {
            System.out.print(" 正解できませんでした\n");
        }
    }
}