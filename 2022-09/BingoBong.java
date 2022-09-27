import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class BingoBong {
    // ビンゴゲームに使うカードを作成します
    public static void main(String[] args) {
        int[][] table = new int[5][5];
        int[] history = new int[75];
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("ビンゴカードを配布します");
        CardInit(table);
        int[][] copy = new int[5][5];
        for (int i = 0; i < table.length; i++) {
            copy[i] = Arrays.copyOf(table[i], table[i].length);
        }
        CardShow(table, copy);
        System.out.println("抽選を開始します");
        System.out.println("\n抽選GO");
        for (int i = 0; i < history.length && !sc.nextLine().equals("c"); i++) {
            int rand;
            do {
                rand = random.nextInt(75) + 1;
            } while (duplicationCheck(history, rand));
            history[i] = rand;
            System.out.print("抽選番号:");
            HistoryShow(history);
            System.out.println("-----------------");
            open(table, rand);
            CardShow(table, copy);
            System.out.println();
            if (check(table)) {
                break;
            }
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

    static void CardShow(int[][] table, int[][] copy) {
        System.out.println("  B   I   N   G   O");
        for (int i = 0; i < table.length; i++) {
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[i][ii] == 0) {
                    if (copy[i][ii] < 10) {
                        System.out.print("( " + copy[i][ii] + ")");
                    } else {
                        System.out.print("(" + copy[i][ii] + ")");
                    }
                } else {
                    if (copy[i][ii] < 10) {
                        System.out.print("  " + table[i][ii] + " ");
                    } else {
                        System.out.print(" " + table[i][ii] + " ");

                    }
                }
            }
            System.out.println();
        }
    }

    static void HistoryShow(int[] history) {
        for (int i = 0; i < history.length; i++) {
            if (history[i] == 0) {
                System.out.println();
                return;
            }

            if (history[i] < 10) {
                System.out.print("  " + history[i]);
            } else {
                System.out.print(" " + history[i]);
            }
            if (i % 5 == 4) {
                System.out.println();
                System.out.print("         ");
            }
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

    static boolean check(int[][] table) {
        int count = 0;
        boolean bingo = false;
        for (int i = 0; i < table.length; i++) {
            count = 0;
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[i][ii] == 0) {
                    count++;
                }
            }
            if (outout(count, (i + 1) + "列目")) {
                bingo = true;
            }
        }

        for (int i = 0; i < table.length; i++) {
            count = 0;
            for (int ii = 0; ii < table[i].length; ii++) {
                if (table[ii][i] == 0) {
                    count++;
                }
            }
            if (outout(count, (i + 1) + "行目")) {
                bingo = true;
            }
        }

        count = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][i] == 0) {
                count++;
            }
        }
        if (outout(count, "右下斜め(＼)")) {
            bingo = true;
        }

        count = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[table.length - 1 - i][i] == 0) {
                count++;
            }
        }
        if (outout(count, "左下斜め(／)")) {
            bingo = true;
        }

        return bingo;
    }

    static boolean outout(int count, String text) {
        if (count == 4) {
            System.out.println(text + "がリーチです");
        } else if (count == 5) {
            System.out.println(text + "がBINGOです");
            return true;
        }
        return false;
    }
}