/* Java応用 課題10 */
class jkadai10 {
    public static void main(String[] args) {
        char mojis[] = { 'c', 'a', 'c', 'b', 'c', 'c', 'c', 'd' }; // 文字列の配列
        int mojilen = 8; // 文字型の配列の要素数
        char moji = 'c'; // 探索したい文字

        // 指定した文字を探索し、その個数を取得する
        int kazu = serchChar(mojis, mojilen, moji);
        System.out.println("文字型" + moji + "は" + kazu + "個ありました");
    }

    /*
     * 指定した文字を探索し、その個数を返却する
     */
    static int serchChar(char[] chars, int charslen, char serchChar) {
        int charCount = 0;
        for (int i = 0; i < charslen; i++) {
            if (serchChar == chars[i]) {
                charCount++;
            }
        }
        return charCount;
    }
}
