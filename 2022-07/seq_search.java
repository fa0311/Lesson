import java.util.Scanner;
import java.util.Random;

class seq_search {

    // 配列から入力した値xが何番目に
    // あるか順次探索をする
    // 結果は何番目にあるかを表示する
    // 存在しない場合は"ありません"を表示する
    static void seq_s(int array[], int x) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) {
            System.out.println("ありません");
        }
    }

    // 配列を0～99の乱数で初期化する処理
    static void init(int array[]) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(99);
        }
    }

    // 引数で渡された配列を表示する
    static void disp(int array[]) {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {

        int data[] = new int[10]; // 使用する配列
        int in; // 検索する値

        init(data); // 配列の初期化
        disp(data); // 配列の表示

        // キーボードから探す値を入力
        Scanner scan = new Scanner(System.in);
        System.out.print("探す値入力：");
        in = scan.nextInt();

        seq_s(data, in); // 配列から入力値を探す
    }
}
