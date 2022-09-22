/* Java応用 課題07 */
class jkadai07 {
    public static void main(String[] args) {
        int shou = 5;
        int tyu = 60;
        int dai = 110;
        message(shou);
        message(tyu);
        message(dai);
    }

    /*
     * マッサージをします
     * (戻り地のない関数)
     */
    static void message(int kaisuu) {
        System.out.println("肩たたきを" + kaisuu + "回します。");
        for (int i = 0; i < kaisuu; i++) {
            System.out.print("トン  ");
        }
        System.out.println("おわりました");
        if (kaisuu < 50) {
            System.out.println("う～ん。もう少ししてほしいです");
        } else if (kaisuu < 100) {
            System.out.println("いい感じ。ほぐれました。");
        } else {
            System.out.println("いたい。やりすぎたようです。");
        }
    }
}
