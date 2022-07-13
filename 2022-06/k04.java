public class k04 {

    public static void main(String[] args) {

        int[] T1 = new int[5];
        for (int i = 0; i < 5; i++) {
            T1[i] = 0;
        }
        System.out.println("課題1");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "番目:" + T1[i]);
        }
        System.out.println("\n\n");

        int[] T2 = new int[7];
        for (int i = 0; i < 7; i++) {
            T2[i] = i + 1;
        }
        System.out.println("課題2");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "番目:" + T2[i]);
        }
        System.out.println("\n\n");

        int[] T3 = new int[7];
        for (int i = 0; i < 7; i++) {
            T3[i] = i * 2;
        }
        System.out.println("課題3");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "番目:" + T3[i]);
        }
        System.out.println("\n\n");

        int[] T4 = new int[7];
        for (int i = 0; i < 7; i++) {
            T4[i] = i * 2 + 1;
        }
        System.out.println("課題4");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "番目:" + T4[i]);
        }
        System.out.println("\n\n");

        int[] T5 = new int[7];
        for (int i = 0; i < 7; i++) {
            T5[i] = T3[i] + T4[i];
        }
        System.out.println("課題5");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "番目:" + T5[i]);
        }
        System.out.println("\n\n");
    }

}
