public class k03VH {
    public static void main(String[] args) {
        int count1 = 1;
        int count2 = 0;
        while (count2 < 10) {
            System.out.print(count1 + " ");
            if (count1 % 3 == 0) {
                count2++;
            }
            count1++;
        }
        System.out.println();

        for (int count = 1; count <= 30; count++) {

            if (count % 3 == 0 && count % 5 == 0) {
                System.out.print("FizzBuzz");
            } else if (count % 3 == 0) {
                System.out.print("Fizz");
            } else if (count % 5 == 0) {
                System.out.print("Buzz");
            } else {
                System.out.print(count);
            }
            System.out.print(" ");
        }
        System.out.println();

        for (int count3 = 1; count3 <= 5; count3++) {
            for (int count4 = 5; count4 > 0; count4--) {
                if (count3 >= count4) {
                    System.out.print(count4);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        int maxSize = 7;
        for (int size = 3; size <= maxSize; size += 2) {
            for (int count3 = 0; count3 < size; count3++) {
                for (int count6 = 0; count6 < maxSize - size / 2; count6++) {
                    System.out.print(" ");
                }
                for (int count4 = 0; count4 < size; count4++) {
                    int x = count4 - size / 2;
                    int y = count3 - size / 2;
                    if (x < 0) { // 絶対値計算
                        x = x * -1;
                    }
                    if (y < 0) {
                        y = y * -1;
                    }
                    y = size / 2 - y;
                    if (x <= y) { // x:中心からの距離 y:端から距離
                        System.out.print("@");
                    } else {
                        System.out.print(" ");
                    }

                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
