import java.util.Scanner;
import java.util.Random;

class marge_sort {

    static void sort(int a[], int b[], int[] data) {
        int index_a = 0, index_b = 0;

        for (int index_data = 0; index_data < data.length; index_data++) {
            if (index_b >= b.length || (index_a < a.length && a[index_a] < b[index_b])) {
                data[index_data] = a[index_a];
                index_a++;
            } else {
                data[index_data] = b[index_b];
                index_b++;
            }
        }
    }

    // 配列を昇順に初期化する処理
    static void init(int array[]) {
        Random random = new Random();
        array[0] = random.nextInt(5);
        for (int i = 1; i < 10; i++) {
            array[i] = array[i - 1] + random.nextInt(5) + 1;
        }
    }

    // 引数で渡された配列を表示する
    static void disp10(int array[]) {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n");
    }

    // 引数で渡された配列を表示する
    static void disp20(int array[]) {
        for (int i = 0; i < 20; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {

        int data[] = new int[20]; // 使用する配列
        int a[] = new int[10]; // 使用する配列
        int b[] = new int[10]; // 使用する配列

        // 配列を0で初期化
        for (int i = 0; i < 20; i++) {
            data[i] = 0;
        }

        init(a); // 配列の初期化
        init(b); // 配列の初期化

        // 配列の表示
        System.out.print("配列a ");
        disp10(a);
        System.out.println("\n");

        // 配列の表示
        System.out.print("配列b ");
        disp10(b);
        System.out.println("\n");

        sort(a, b, data);

        // 配列の表示
        System.out.print("配列data ");
        disp20(data);
        System.out.println("\n");
    }
}
