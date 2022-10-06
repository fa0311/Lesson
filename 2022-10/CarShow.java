class CarShow {
    public static void main(String[] args) {
        // 車をつくります
        Car car = new Car();
        CarSpecial scar = new CarSpecial();
        CarNew ncar = new CarNew();
        car.spec(); // 親(スーパー)クラス
        scar.spec(); // 子(サブ)クラス
        ncar.spec(); // 子(サブ)クラス
    }
}