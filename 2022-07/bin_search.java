import java.util.Scanner;
import java.util.Random;

class bin_search {

    // 配列から入力した値xが何番目に
    // あるか2分探索をする
    // 結果は何番目にあるかを表示する
    // 存在しない場合は"ありません"を表示する
    static void seq_b(int array[], int x) {
        int range_start = 0;
        int range_end = array.length;
        while (range_start <= range_end) {
            int index = (range_start + range_end) / 2;
            if (array[index] > x) {
                range_end = index - 1;
            } else if (array[index] < x) {
                range_start = index + 1;
            } else {
                System.out.println(index);
                return;
            }
        }
        System.out.println("ありません");
    }

    // 配列を昇順にして初期化する処理
    static void init(int array[]) {
        Random random = new Random();
        array[0] = random.nextInt(5);
        for (int i = 1; i < 20; i++) {
            array[i] = array[i - 1] + random.nextInt(5) + 1;
        }
    }

    // 引数で渡された配列を表示する
    static void disp(int array[]) {
        for (int i = 0; i < 20; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {

        int data[] = new int[20]; // 使用する配列
        int in; // 検索する値

        init(data); // 配列の初期化
        disp(data); // 配列の表示

        // キーボードから探す値を入力
        Scanner scan = new Scanner(System.in);
        System.out.print("探す値入力：");
        in = scan.nextInt();

        seq_b(data, in); // 配列から入力値を探す
    }
}
