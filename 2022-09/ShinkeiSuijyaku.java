import java.util.Scanner; // Scannerのインポート
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ShinkeiSuijyaku { // 配列の中身をシャッフルします
    public static void shuffle(String[] array) {
        if (array.length <= 1) {
            return;
        } // FisherYates shuffle
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1); // 要素入れ替え(swap)
            String tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] strs = { "＊", "＊", "＊＊", "＊＊", "＊＊＊", "＊＊＊" };
        System.out.println("神経衰弱を始めます");
        System.out.println(strs.length + "枚のカードをシャッフルします");
        System.out.println(Arrays.toString(strs));
        // 配列を並び替える
        shuffle(strs);
        System.out.println("シャッフルしました");
        System.out.println("\n0番から" + strs.length + "番までカードを2枚めくってください");

        // 処理を追加 (枠の関係で穴の高さが短いですが実際はまだ長いです)
        boolean[] correct = correctInit(new boolean[strs.length]);
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(strs));
        while (!isAllTrue(correct)) {
            int inputValue1, inputValue2;
            while (true) {
                System.out.print("1枚目の番号を入力してください→");
                inputValue1 = sc.nextInt();
                if (strs.length <= inputValue1) {
                    System.out.println("入力値が不正です");
                } else if (0 > inputValue1) {
                    System.out.println("入力値が不正です");
                } else if (correct[inputValue1]) {
                    System.out.println("既に揃ったカードです");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("2枚目の番号を入力してください→");
                inputValue2 = sc.nextInt();
                if (strs.length <= inputValue2) {
                    System.out.println("入力値が不正です");
                } else if (0 > inputValue2) {
                    System.out.println("入力値が不正です");
                } else if (correct[inputValue2]) {
                    System.out.println("既に揃ったカードです");
                } else if (inputValue1 == inputValue2) {
                    System.out.println("同じカードを選ぶことはできません");
                } else {
                    break;
                }
            }
            if (strs[inputValue1] == strs[inputValue2]) {
                System.out.print("\n：正解です。");
                correct[inputValue1] = true;
                correct[inputValue2] = true;
            } else {
                System.out.print("\n：不正解です。");
            }
            System.out.println("一枚目は[" + strs[inputValue1] + "]、2枚目は[" + strs[inputValue2] + "]です");
            if (!isAllTrue(correct)) {
                System.out.println("\n0番から" + strs.length + "番までカードを2枚めくってください");
            }
        }
        System.out.println("神経衰弱を終了します");
        sc.close();
    }

    public static boolean[] correctInit(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
        return array;
    }

    public static boolean isAllTrue(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!array[i])
                return false;
        }
        return true;
    }
}