class stringketsugou {
    public static void main(String[] args) {
        int max = 5;
        // 加算による文字列結合
        String str = "";
        for (int i = 0; i < max; i++) {
            str = str + "☆";
        }
        System.out.println("加算 : " + str);

        // メソッドを使った文字列結合 (concat ()メソッド)
        String str2 = "";
        for (int i = 0; i < max; i++) {
            str2 = str2.concat("★");
        }
        System.out.println("メゾット: " + str2);
        // StringBuffer クラスを使った文字列結合
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < max; i++) {
            buff.append("○");
        }
        System.out.println("StringBuilder: " + buff);
    }
}