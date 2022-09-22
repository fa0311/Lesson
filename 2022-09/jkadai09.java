/* Java応用 課題09 */
class jkadai09 {
    public static void main(String[] args) {
        printAlphabet(3);
        printAlphabet(7);
        printAlphabet(8);
    }

    /*
     * 指示された数のアルファベットを表示する
     * 表示は7文字までとする
     */
    static void printAlphabet(int num) {
        char alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

        if (num >= 8) {
            System.out.println("8文字以上は表示できません");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(alphabet[i]);
            }
            System.out.println("→" + num + "文字表示しました");
        }
    }
}
