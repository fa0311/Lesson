// Java応用 ミニテスト02
// 学籍番号　学科　名前

class miniTest02 {
    public static void main(String[] args) {
        funnyBot(3);
        funnyBot(100);
    }

    // 数字によってセリフを表示する
    static void funnyBot(int dosu) {

        // セリフは度数が偶数か奇数で分けて表示
        if (dosu % 2 == 0) {
            System.out.println("ガンガンいこうぜ");
        } else {
            System.out.println("いろいろやろうぜ");
        }

        // 度数分、掛け声をのばして表示
        System.out.print("イエ");
        for (int i = 0; i < dosu; i++) {
            System.out.print("ー");
        }
        System.out.println("イ！");

    }
}
