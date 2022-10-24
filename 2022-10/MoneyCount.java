
import java.util.Scanner;

class MoneyCount {
    public static void main(String[] args) {
        System.out.print("金額を入力してください→ ");
        Scanner sin = new Scanner(System.in);
        int price = sin.nextInt();
        int coin;
        sin.close();

        coin = price / 10000;
        System.out.println("一万円札：" + coin + "枚");
        price -= coin * 10000;

        coin = price / 5000;
        System.out.println("五千円札：" + coin + "枚");
        price -= coin * 5000;

        coin = price / 1000;
        System.out.println("　千円札：" + coin + "枚");
        price -= coin * 1000;

        coin = price / 500;
        System.out.println("五百円玉：" + coin + "枚");
        price -= coin * 500;

        coin = price / 100;
        System.out.println("　百円玉：" + coin + "枚");
        price -= coin * 100;

        coin = price / 50;
        System.out.println("五十円玉：" + coin + "枚");
        price -= coin * 50;

        coin = price / 10;
        System.out.println("　十円玉：" + coin + "枚");
        price -= coin * 10;

        System.out.println("　一円玉：" + price + "枚");
    }
}