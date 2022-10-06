/* Java応用 */
// 車クラスの親クラス
class Car {
    String maker;
    String type;
    int price;

    Car() {
        maker = "IVY";
        type = "4駆動";
        price = 100;
    }

    void spec() {
        System.out.println("メーカー:" + maker);
        System.out.println("タイプ:" + type);
        System.out.println("値段:" + price + "万");
    }
}