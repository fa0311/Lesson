import java.util.Arrays;
import java.util.Random;

class BingoCard {
    // ビンゴゲームに使うカードを作成します
    public static void main(String[] args) {
        CardShow(0);
    }

    static void CardShow(int num) {
        Random random = new Random();
        int[][] table = new int[5][5];
        System.out.println(" B  I  N  G  O");
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
                if (rand < 10) {
                    System.out.print(" ");
                }
                System.out.print(" " + rand);
            }
            System.out.println();
        }
    }

    static boolean duplicationCheck(int[][] table, int num) {
        for (int i = 0; i < table.length; i++) {
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[i][ii] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}