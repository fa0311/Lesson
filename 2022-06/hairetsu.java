import java.util.Scanner;

public class hairetsu {

    public static void main(String[] args) {
        int[] price = new int[3];

        price[0] = 120;
        price[1] = 380;
        price[2] = 80;

        System.out.println(price[2]);
        System.out.println(price[0]);
        System.out.println(price[1]);

        System.out.println(price.length);

        int[] a, b;
        a = new int[4];
        b = a;

        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        a[3] = 0;

        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);

        Scanner sc = new Scanner(System.in);
        System.out.println("段を入力てください");
        int row = sc.nextInt();
        sc.close();
        int[][] table = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int ii = 0; ii < 9; ii++) {
                table[i][ii] = (i + 1) * (ii + 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(table[row - 1][i]);
            System.out.print(" ");

        }
    }
}
