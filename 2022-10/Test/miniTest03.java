// Java応用 ミニテスト03
// 学籍番号　学科　名前

import java.util.Random;

class miniTest03 {
    public static void main(String[] args) {
        // 文字の分割
        String str = "白菜,長ネギ,肉,ニンジン,エノキ,肉,豆腐,しらたき,つみれ";
        String[] guzai = str.split(",");
        // 肉を探す
        String search = "肉";
        int count = 0;
        for (int i = 0; i < guzai.length; i++) {
            if (guzai[i].equals(search)) {
                count++;
            }
        }

        System.out.println(search + "は" + count + "個ありました");

        // ランダムに食材をとんすい(お皿)に入れる
        int get1 = 0;
        int get2 = 0;

        Random random = new Random();
        get1 = random.nextInt(guzai.length);
        do {
            get2 = random.nextInt(guzai.length);
        } while (get1 == get2);

        System.out.println("鍋から" + guzai[get1] + "と" + guzai[get2] + "を取りました");
    }
}
