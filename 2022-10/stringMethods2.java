class stringMethods2 {
    public static void main(String[] args) {
        String str = null;
        String moji = "";
        String tango = "blue";

        // 空文字かどうか
        // (戻り値を変数で代入して表示する書き方)
        boolean ret = moji.isEmpty();
        System.out.println(moji + "は" + ret);
        // (戻り地をそのまま表示する書き方)
        System.out.println(tango + "は" + tango.isEmpty());

        // nullかどうか
        System.out.print("strは");
        if (str != null) {
            System.out.println("nullではない");
        } else {
            System.out.println("nullである");
        }

        // 指定した文字が何番目にあるか(0から開始)
        str = "e";
        int idx = tango.indexOf(str);
        System.out.println(tango + "の中で" + str + "は" + idx + "番目");

        // 文字列の切り取り
        str = "ABCDEFG";
        moji = str.substring(2, 5);
        System.out.println(str + "を切り取りました→" + moji);

        // 文字の分割
        str = "いちご,みかん,ぶどう,リンゴ";
        String[] fruit = str.split(",");

        System.out.println(str + " を , で分割しました");
        for (int i = 0; i < fruit.length; i++) {
            System.out.println(i + "番目の要素 = :" + fruit[i]);
        }
    }
}
