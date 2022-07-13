import java.util.Random;

public class k04SP {

    public static void main(String[] args) {

        Random random = new Random();

        int[] T = new int[20];

        for (int i = 0; i < 20; i++) {
            T[i] = random.nextInt(50);
        }

        System.out.print("配列: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(T[i]);
            System.out.print(",");
        }
        System.out.println("");

        int max = T[0];
        for (int i = 1; i < 20; i++) {
            if (max < T[i]) {
                max = T[i];
            }
        }
        System.out.print("最大値: ");
        System.out.println(max);
        System.out.print("最大値の場所: ");
        for (int i = 0; i < 20; i++) {
            if (max == T[i]) {
                System.out.print(i);
                System.out.print(",");
            }
        }
        System.out.println("");

        int min = T[0];
        for (int i = 1; i < 20; i++) {
            if (min > T[i]) {
                min = T[i];
            }
        }
        System.out.print("最小値: ");
        System.out.println(min);
        System.out.print("最小値の場所: ");
        for (int i = 0; i < 20; i++) {
            if (min == T[i]) {
                System.out.print(i);
                System.out.print(",");
            }
        }

        System.out.println("");

        for (int ii = 0; ii < 19; ii++) {
            for (int i = 0; i < 19; i++) {
                if (T[i] > T[i + 1]) {
                    int num = T[i];
                    T[i] = T[i + 1];
                    T[i + 1] = num;
                }
            }
        }

        System.out.print("ソート後: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(T[i]);
            System.out.print(",");
        }
        System.out.println("");
    }
}
