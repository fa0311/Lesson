import java.util.Random;

class moreMethods {
    public static void main(String[] args) {

        // 文字列の置換
        String moji = "白黒白黒白黒白黒白黒白黒";
        String str = moji.replace("黒", "白");

        System.out.println(moji + "は");
        System.out.println(str + "に染まりました");

        // 文字列から数値へ
        moji = "１２３";
        int num = Integer.parseInt(moji);
        System.out.println(num);
        // 数値から文字列へ
        System.out.println(Integer.toString(num));

        // ランダム値
        double random = Math.random();
        System.out.println("実行するたびに値が変わります→" + random);

        Random rand = new Random();
        num = rand.nextInt(10);
        System.out.println("実行するたびに値が変わります→" + num);
    }
}
