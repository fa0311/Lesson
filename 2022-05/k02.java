import java.util.Scanner;

public class k02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("年を入力してください");
        int y = sc.nextInt();
        System.out.println("月を入力してください");
        int m = sc.nextInt();
        System.out.println("日を入力してください");
        int d = sc.nextInt();
        sc.close();

        System.out.println(y + "年" + m + "月" + d + "日");
        if (y == 2022) {
            System.out.println("今年です");
        } else {
            System.out.println("今年ではありません");
        }
        if (m < 6) {
            System.out.println("前半です");
        } else {
            System.out.println("後半です");
        }
        if (d % 2 == 0) {
            System.out.println("偶数です");
        } else {
            System.out.println("奇数です");
        }
        if (d < m) {
            System.out.println("mが大きい");
        } else if (d > m) {
            System.out.println("dが大きい");
        } else if (d == m) {
            System.out.println("同じです");
        }
        if (m < 1 || m > 12) {
            System.out.println("月の入力が正しくありません");
        } else {
            System.out.println("月の入力は正しいです");
        }
        switch (m) {
            case 3:
            case 4:
            case 5:
                System.out.println("春です");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏です");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋です");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬です");
                break;
            default:
                System.out.println("そんな月はありません");
                break;
        }
        if (y % 400 == 0) {
            System.out.println("うるう年です");
        } else if (y % 100 == 0) {
            System.out.println("うるう年ではありません");
        } else if (y % 4 == 0) {
            System.out.println("うるう年です");
        } else {
            System.out.println("うるう年ではありません");
        }

        System.out.println("====追加課題====");
        boolean flag = false;
        if (y < 1) {
            System.out.println("年が正しくありません");
            flag = true;
        }
        if (d < 1) {
            System.out.println("日が正しくありません");
            flag = true;
        }

        int lastDay = 0;
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastDay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay = 30;
                break;
            case 2:
                if (y % 400 == 0) {
                    lastDay = 29;
                } else if (y % 100 == 0) {
                    lastDay = 28;
                } else if (y % 4 == 0) {
                    lastDay = 29;
                } else {
                    lastDay = 28;
                }
                break;
            default:
                System.out.println("月が正しくありません");
                flag = true;
                break;
        }
        if (d > lastDay) {
            System.out.println("日が正しくありません");
            flag = true;
        }
        if (!flag) {
            System.out.println("正しいです");
        }
    }
}
