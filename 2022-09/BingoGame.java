import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class BingoGame {
    // ビンゴゲームに使うカードを作成します
    public static void main(String[] args) {
        int[][] table = new int[5][5];
        int[] history = new int[75];
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("ビンゴカードを配布します");
        CardInit(table);
        CardShow(table);
        System.out.println("抽選を開始します");
        System.out.println("\n抽選GO");
        for (int i = 0; i < history.length && !sc.nextLine().equals("c"); i++) {
            int rand;
            do {
                rand = random.nextInt(75) + 1;
            } while (duplicationCheck(history, rand));
            history[i] = rand;
            System.out.println((i + 1) + "回目: " + rand);
            open(table, rand);
            CardShow(table);
            System.out.println("\n抽選GO");
        }
        System.out.println("中断します");
        sc.close();
    }

    static void CardInit(int[][] table) {
        Random random = new Random();
        for (int i = 0; i < table.length; i++) {
            for (int ii = 0; ii < table[i].length; ii++) {
                int rand;
                if (i == 2 && ii == 2) {
                    rand = 0;
                } else {
                    do {
                        rand = random.nextInt(75) + 1;
                    } while (duplicationCheck(table, rand));
                }
                table[i][ii] = rand;
            }
        }
    }

    static void CardShow(int[][] table) {
        System.out.println(" B  I  N  G  O");
        for (int i = 0; i < table.length; i++) {
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[i][ii] < 10) {
                    System.out.print(" ");
                }
                System.out.print(" " + table[i][ii]);
            }
            System.out.println();
        }
    }

    static boolean duplicationCheck(int[] table, int num) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == num) {
                return true;
            }
        }
        return false;
    }

    static boolean duplicationCheck(int[][] table, int num) {
        for (int i = 0; i < table.length; i++) {
            if (duplicationCheck(table[i], num)) {
                return true;
            }
        }
        return false;
    }

    static void open(int[][] table, int num) {
        for (int i = 0; i < table.length; i++) {
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[i][ii] == num) {
                    table[i][ii] = 0;
                    return;
                }
            }
        }
    }
}