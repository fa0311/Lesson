import java.util.Random;
import java.util.Scanner;

public class k03SP2 {
    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int rand = random.nextInt(9999);
            System.out.println(rand);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("レア率を入力してください");
        int rare = (int) (sc.nextFloat() * 100);
        sc.close();
        if (1 > rare || 1000 < rare) {
            System.out.println("入力値が不正です");
            return;
        }

        int rand;
        int count = 0;
        do {
            rand = random.nextInt(9999);
            count++;
        } while (rand >= rare);
        System.out.println(count + "回で当たりました");
    }
}
