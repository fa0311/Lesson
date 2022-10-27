import java.util.InputMismatchException;
import java.util.Scanner;

public class EtoHantei {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int year = 0;
        System.out.println("干支を表示します");
        System.out.print("西暦を入力してください→");
        try {
            year = sin.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("数字を入力してください");
            System.exit(1);
        }
        if (year < 1924) {
            System.out.println("1924年以上を入力してください");
            System.exit(1);
        }
        System.out.println("この年は、" + toEto((year + 8) % 12) + "です");
        sin.close();

    }

    static String toEto(int num) {
        switch (num) {
            case 0:
                return "子(ね)";
            case 1:
                return "丑(うし)";
            case 2:
                return "寅(とら)";
            case 3:
                return "卯(う)";
            case 4:
                return "辰(たつ)";
            case 5:
                return "巳(み)";
            case 6:
                return "午(うま)";
            case 7:
                return "未(ひつじ)";
            case 8:
                return "申(さる)";
            case 9:
                return "酉(とり)";
            case 10:
                return "戌(いぬ)";
            case 11:
                return "亥(い)";
            default:
                throw new IllegalArgumentException();
        }
    }
}
