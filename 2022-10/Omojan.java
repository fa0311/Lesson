import java.util.Scanner;
import java.util.Random;

public class Omojan {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        Random rand = new Random();
        String[] list = new String[20];
        int len = 0;
        for (int i = 0; i < list.length; i++) {
            System.out.print((i + 1) + "個目の入力→");
            String input = sin.nextLine();
            if (input.equals("end")) {
                break;
            }
            list[i] = input;
            len = i;
        }
        int rand1 = rand.nextInt(len + 1);
        int rand2 = rand.nextInt(len + 1);
        System.out.println(list[rand1] + " " + list[rand2]);
        String input;
        do {
            System.out.print("終了しますか？(y/n)");
            input = sin.nextLine();
        } while (!input.equals("y"));
        sin.close();
    }
}
