/* Java応用 課題08 */
class jkadai08 {
    public static void main(String[] args) {
        int area1 = rectangle(30, 50);
        int area2 = trapezoid(2, 6, 3);
        System.out.println("長方形の面積は" + area1);
        System.out.println("台形の面積は" + area2);
    }

    /*
     * 長方形の面積を求める
     */
    static int rectangle(int bottom, int height) {
        return bottom * height;
    }

    /*
     * 台形の面積を求める
     */
    static int trapezoid(int top, int bottom, int height) {
        return (top + bottom) * height / 2;
    }
}
