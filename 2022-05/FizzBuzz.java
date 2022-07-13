import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("数値を入力してください");
        Scanner sc = new Scanner(System.in);
        int ichk = sc.nextInt();

        if (ichk % 2 != 0 && ichk % 3 != 0) {
            System.out.println("2の倍数でも3の倍数でもありません");
        } else {
            if (ichk % 2 == 0) {
                System.out.println("2の倍数です");
            }
            if (ichk % 3 == 0) {
                System.out.println("3の倍数です");
            }
        }
        sc.close();
    }
}
