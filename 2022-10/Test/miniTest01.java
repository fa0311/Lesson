// Java応用 ミニテスト01
// 学籍番号　学科　名前

class miniTest01 {
    public static void main(String[] args) {
        int susume = 2;
        int tomare = 99;

        System.out.println(singou(susume));
        System.out.println(singou(tomare));
    }

    // 数字によって、信号の色を返します
    static String singou(int num) {
        String output = num + "は";
        switch (num) {
            case 0:
                output += "赤";
                break;
            case 1:
                output += "黄";
                break;
            case 2:
                output += "青";
                break;
            default:
                output += "信号無視";
                break;
        }
        return output;
    }
}
