import java.util.Scanner;

public class k03SP {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("数値を入力してください");
            int number = sc.nextInt();

            int i;
            for (i = 2; i < number; i++) {
                if (number % i == 0) {
                    System.out.println("素数ではありません");
                    break;
                }
            }
            if (i == number) {
                System.out.println("素数です");
            }

            System.out.println("数値を入力してください");
            int number2 = sc.nextInt();
            sc.close();

            int ii, iii;
            int count = 0;
            for (i = 1; i <= 6; i++) {
                for (ii = 1; ii <= 6; ii++) {
                    for (iii = 1; iii <= 6; iii++) {
                        if (i + ii + iii == number2) {
                            System.out.print(i);
                            System.out.print(ii);
                            System.out.println(iii);
                            count++;
                        }
                    }
                }
            }
            System.out.println("組み合わせは" + count + "個です");
        }

    }
}
