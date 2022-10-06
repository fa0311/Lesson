class stringMethods {
    public static void main(String[] args) {
        String moji = "ABCDE";

        // 文字列の長さ
        int len = moji.length();
        System.out.println(moji + "は" + len + "文字です");

        // 大文字→小文字
        String low = moji.toLowerCase();
        System.out.println(low + "は" + low);

        // 小文字→大文字
        moji = "aBdDe";
        String upper = moji.toUpperCase();
        System.out.println(moji + "は" + upper);

        // 文字比較
        String s1 = "ABC";
        String s2 = "ABC";
        boolean ret = s1.equals(s2);
        System.out.println(s1 + "と" + s2 + "は" + ret);

        s2 = s2.toLowerCase();
        ret = s1.equals(s2);
        System.out.println(s1 + "と" + s2 + "は" + ret);
    }
}
