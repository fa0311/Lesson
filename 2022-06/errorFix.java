class errorFix {
    public static void main(String[] args) {
        System.out.println("構文エラーの修正練習");

        // 1問目
        System.out.println("1問目");
        int i = 1;
        while (i <= 20) {
            System.out.print(i);
            System.out.print(" ");
            if (i % 5 == 0) {
                System.out.println();
            }
            i++;
        }

        // 2問目
        System.out.println("2問目");
        for (i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        // 3問目
        System.out.println("3問目");
        for (i = 0; i < 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 4問目
        System.out.println("4問目");
        for (i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}