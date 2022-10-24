import java.util.Scanner;

public class MojiAwase {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        System.out.println("1個目の文字を入力してください");
        String str1 = sin.nextLine();
        System.out.println("2個目の文字を入力してください");
        String str2 = sin.nextLine();
        sin.close();
        if (str1.equals(str2)) {
            System.out.println("同じ文字です");
        } else {
            System.out.println("同じ文字ではありません");
        }

    }
}
