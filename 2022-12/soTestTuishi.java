class soTestTuishi {
    public static void main(String[] args) {
        String name = "Java";
        int stepA = 3;
        int stepB = 88;
        kyoukaStep(name, stepA);
        kyoukaStep(name, stepB);
    }

    // 数字によって、段階を表示します
    static void kyoukaStep(String kamoku, int num) {
        String step = "";
        switch (num) {
            case 1:
                step = "入門";
                break;
            case 2:
                step = "基礎";
                break;
            case 3:
                step = "応用";
                break;
            case 4:
                step = "発展";
                break;
            default:
                step = "実践";
                break;
        }

        System.out.println(kamoku + step);
    }
}
