public class k03H {
    public static void main(String[] args) {
        int count1 = 1;
        while (count1 <= 20) {
            System.out.print(count1 + " ");
            if (count1 % 5 == 0) {
                System.out.println();
            }
            count1++;
        }
        System.out.println();

        for (int count = 1; count <= 30; count++) {
            if (count % 3 == 0) {
                continue;
            }
            System.out.print(count + " ");
        }
        System.out.println();
        System.out.println();

        for (int count2 = 1; count2 <= 3; count2++) {
            for (int count3 = 1; count3 <= 5; count3++) {
                System.out.print(count3);
            }
            System.out.println();
        }

        for (int count2 = 1; count2 <= 6; count2++) {
            for (int count3 = 1; count3 < count2; count3++) {
                System.out.print(count3);
            }
            System.out.println();
        }

    }
}
