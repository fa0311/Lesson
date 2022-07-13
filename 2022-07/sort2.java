import java.util.Scanner;
import java.util.Random;

class sort2 {

    // 要素数10の配列を昇順にソート
    static void sort_a(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int ii = 0; ii < array.length - 1; ii++) {
                if (array[ii] > array[ii + 1]) {
                    int num = array[ii];
                    array[ii] = array[ii + 1];
                    array[ii + 1] = num;
                }
            }
        }
    }

    // 要素数10の配列を降順にソート
    static void sort_b(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int ii = 0; ii < array.length - 1; ii++) {
                if (array[ii] < array[ii + 1]) {
                    int num = array[ii];
                    array[ii] = array[ii + 1];
                    array[ii + 1] = num;
                }
            }
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

        init(data); // 配列の初期化
        disp(data); // 配列の表示

        System.out.println("昇順にソート");

        sort_a(data); // 昇順にソート
        disp(data); // 配列の表示

        System.out.println("降順にソート");

        sort_b(data); // 降順にソート
        disp(data); // 配列の表示

    }
}
