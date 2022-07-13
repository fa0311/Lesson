public class k01 {
    public static void main(String[] args) {
        int squ = 3 * 3;
        System.out.print("一辺の長さが3の正方形の面積: ");
        System.out.println(squ);

        int tri = 3 * 5 / 2;
        System.out.print("底辺が3，高さが5の三角形の面積: ");
        System.out.println(tri);

        double tri2 = 3 * 5 / 2.0;
        System.out.print("底辺が3，高さが5の三角形の面積: ");
        System.out.println(tri2);

        double cri = 3 * 3 * 3.14;
        System.out.print("半径が3の円の面積: ");
        System.out.println(cri);

        int ver1 = 60 * 60 * 24 * 365;
        System.out.print("1年間は何秒か: ");
        System.out.println(ver1);

        int ver2 = (int) (4 * 10 * 10 * 3.14);
        System.out.print("半径が10の球の表面積: ");
        System.out.println(ver2);

        int ver3 = (int) (4 / 3 * 10 * 10 * 10 * 3.14);
        System.out.print("半径が10の球の体積: ");
        System.out.println(ver3);

        double ver4 = 6378 * 2 * 3.14 / 24;
        System.out.print("赤道上の地球の自転速度: ");
        System.out.println(ver4);
    }
}
