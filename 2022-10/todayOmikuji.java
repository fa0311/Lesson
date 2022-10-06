
/* Java応用 */
import java.util.Random;

class todayOmikuji {
    public static void main(String[] args) {
        omikuji();
    }

    static void omikuji() {
        System.out.println("おみくじをひきました");
        Random rand = new Random();
        switch (rand.nextInt(7)) {
            case 0:
                System.out.println("今日は「大吉」です");
                System.out.println("一言: ステキな一日になるでしょう");
                break;
            case 1:
                System.out.println("今日は「吉」です");
                System.out.println("一言: 良い一日になるでしょう");
                break;
            case 2:
                System.out.println("今日は「中吉」です");
                System.out.println("一言: 少し良い一日になるでしょう");
                break;
            case 3:
                System.out.println("今日は「小吉」です");
                System.out.println("一言: ほんの少し良い一日になるでしょう");
                break;
            case 4:
                System.out.println("今日は「末吉」です");
                System.out.println("一言: いつもと変わらない一日になるでしょう");
                break;
            case 5:
                System.out.println("今日は「凶」です");
                System.out.println("一言: 嫌な一日になるでしょう");
                break;
            case 6:
                System.out.println("今日は「大凶」です");
                System.out.println("一言: 最悪な一日になるでしょう");
                break;
        }
    }
}