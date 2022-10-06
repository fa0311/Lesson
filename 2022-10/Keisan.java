class Keisan {
    public static void main(String[] args) {
        Calculation cal = new Calculation();

        // 足し算
        cal.plus(10);
        cal.display();

        // 足し算
        cal.plus(40);
        cal.display();

        cal.plus(50);
        cal.display();

        cal.plus(20);
        cal.display();

        // 引き算
        cal.mines(10);
        cal.display();

        // 掛け算
        cal.multiplication(10);
        cal.display();

        // 割り算
        cal.division(10);
        cal.display();
    }

}
