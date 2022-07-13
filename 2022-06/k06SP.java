import java.util.Scanner;
import java.util.Random;

class k06SP {

    // 数値の入力を行う
    // 入力値はreturnで戻ってくる
    static int input_num() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    // 配列を0で初期化する処理
    static void init(int array[]) {
        for (int i = 0; i < 4; i++) {
            array[i] = 0;
        }
    }

    // 問題の配列qに0～9の数字をランダムに入れる
    // 数値は重複がないようにセットされる
    static void set_q(int q[]) {

        Random random = new Random();

        int i = 0; // 配列の要素番号
        int cnt; // 重複確認用変数

        // 4桁分繰り返す
        while (i < 4) {

            // 0～9の乱数をセット
            q[i] = random.nextInt(10);
            cnt = 0;

            // 今までの桁に重複があるか確認
            // 重複があればcntを+1する
            for (int j = 0; j < i; j++) {
                if (q[i] == q[j]) {
                    cnt++;
                }
            }

            // 重複が0なら次の桁にする
            if (cnt == 0) {
                i++;
            }
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
        int i = 0;
        while (i < 4) {
            System.out.println(i + 1 + "桁目を入力してください");
            a[i] = input_num();
            if (a[i] < 0 || a[i] > 9) {
                System.out.println("数値は0-9を入力してください");
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                i++;
            } else {
                System.out.println("重複があります");
            }
        }
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
        int blow = 0;
        for (int i = 0; i < q.length; i++) {
            for (int ii = 0; ii < a.length; ii++) {
                if (i == ii) {
                    continue;
                } else if (q[i] == a[ii]) {
                    blow++;
                    break;
                }
            }
        }
        return blow;
    }

    // main関数
    public static void main(String[] args) {

        int q[] = new int[4]; // 問題
        int a[] = new int[4]; // 解答

        init(q); // 問題の初期化
        init(a); // 回答の初期化

        int hit = 0; // hitの数
        int blow = 0; // blowの数
        int cnt = 0; // 入力回数

        set_q(q); // 問題のセット

        System.out.println("Hit and Blowのゲームをします");
        System.out.println("20回以内に4hitを目指してください\n\n");

        // 4hitか20回入力するまで繰り返し
        while (hit != 4 && cnt < 20) {

            cnt++; // 入力回数+1

            // 正解検証時(動作確認時のみ以下の３行はコメントを外す)
            System.out.print("正解は");
            disp(q);
            System.out.println();

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
        if (hit == 4) {
            System.out.print(cnt + " 回で正解しました\n");
        } else {
            System.out.print(" 正解できませんでした\n");
        }
    }
}