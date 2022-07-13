import java.util.Scanner;
import java.util.Random;

class minmax {

    // 要素数10の配列から最大値・最大値の場所
    // 最小値・最小値の場所を探し表示する

    // 配列から最大値を表示する
    static void max_val(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    // 最大値の場所を表示する
    static void max_pos(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (max == array[i]) {
                System.out.println(i);
            }
        }
    }

    // 配列から最小値を表示する
    static void min_val(int array[]) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);
    }

    // 最小値の場所を表示する
    static void min_pos(int array[]) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (min == array[i]) {
                System.out.println(i);
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

        max_val(data); //
        max_pos(data); // 処理の呼び出し
        min_val(data); //
        min_pos(data); //
    }
}