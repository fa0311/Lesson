public class k03N {
    public static void main(String[] args) {

        int count1 = 1;
        while (count1 <= 10) {
            System.out.print(count1 + " ");
            count1++;
        }
        System.out.println();

        for (int count2 = 10; count2 > 0; count2--) {
            System.out.print(count2 + " ");
        }
        System.out.println();

        int count3 = 1;
        while (count3 <= 10) {
            System.out.print(count3 * 2 + " ");
            count3++;
        }
        System.out.println();

        for (int count4 = 0; count4 <= 9; count4++) {
            System.out.print(count4 * 2 + 1 + " ");
        }
        System.out.println();

        for (int count5 = 0; count5 < 3; count5++) {
            for (int count6 = 0; count6 < 5; count6++) {
                System.out.print("@");
            }
            System.out.println();
        }
        System.out.println();

        for (int count5 = 1; count5 <= 5; count5++) {
            for (int count6 = 0; count6 < 5; count6++) {
                System.out.print(count5);
            }
            System.out.println();
        }

    }
}
