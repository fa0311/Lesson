import java.util.Scanner;

public class othello {
    static void init(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (i == 3 && ii == 3)
                    board[i][ii] = 1;
                else if (i == 3 && ii == 4)
                    board[i][ii] = 2;
                else if (i == 4 && ii == 3)
                    board[i][ii] = 2;
                else if (i == 4 && ii == 4)
                    board[i][ii] = 1;
                else
                    board[i][ii] = 0;
            }
        }
    }

    static void disp(int board[][]) {
        System.out.print(" ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println(" 行");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "|");
            for (int ii = 0; ii < board[i].length; ii++) {
                switch (board[i][ii]) {
                    case 1:
                        System.out.print("●");
                        break;
                    case 2:
                        System.out.print("○");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("列");
        System.out.println();
    }

    static boolean can_place_on_board(int board[][], int player) {
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] == 0 && reverse(board, i, ii, player, true) > 0)
                    return true;
            }
        }
        return false;
    }

    static boolean is_range(int board[][], int y, int x) {
        if (y < 0 || x < 0 || y >= board.length || x >= board[y].length)
            return false;
        return true;
    }

    static int reverse(int board[][], int y, int x, int player, boolean dry_run) {
        int count = 0;
        for (int vector_y = -1; vector_y <= 1; vector_y++) {
            for (int vector_x = -1; vector_x <= 1; vector_x++) {
                if (vector_y == 0 && vector_x == 0)
                    continue;
                int amount_y = y, amount_x = x, move_count = 0;
                do {
                    amount_y += vector_y;
                    amount_x += vector_x;
                    move_count++;
                    if (!is_range(board, amount_y, amount_x))
                        break;
                } while (board[amount_y][amount_x] != player && board[amount_y][amount_x] != 0);

                if (!is_range(board, amount_y, amount_x))
                    continue;

                if (board[amount_y][amount_x] == player) {
                    count += move_count - 1;
                    if (!dry_run) {
                        do {
                            amount_y -= vector_y;
                            amount_x -= vector_x;
                            board[amount_y][amount_x] = player;
                        } while (amount_y != y || amount_x != x);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        Scanner sc = new Scanner(System.in);
        int player = 1;

        System.out.println("モードを入力してください");
        System.out.println("0 2人で遊ぶ");
        System.out.println("1 Botと遊ぶ(先行)");
        System.out.println("2 Botと遊ぶ(後攻)");
        int mode = sc.nextInt();
        if (mode == 2)
            player = 2;

        init(board);

        for (int turn = 0; turn < 60; turn++) {

            disp(board);
            switch (player) {
                case 1:
                    System.out.println("●の番です");
                    break;
                case 2:
                    System.out.println("○の番です");
                    break;
            }
            if (!can_place_on_board(board, player)) {
                System.out.println("置ける場所がないためパスしました");
                player = player % 2 + 1;
                continue;
            }

            int x = 0, y = 0;
            if (player == 1 || mode == 0) {
                System.out.println("列を入力してください");
                y = sc.nextInt();

                System.out.println("行を入力してください");
                x = sc.nextInt();

                if (board[y][x] != 0) {
                    System.out.println("ここには置けません");
                    turn--;
                    continue;
                }

                if (reverse(board, y, x, player, true) == 0) {
                    System.out.println("ここには置けません");
                    turn--;
                    continue;
                }

            } else {
                int max_point = 0;
                for (int i = 0; i < board.length; i++) {
                    for (int ii = 0; ii < board[i].length; ii++) {
                        int point = 0;
                        if (board[i][ii] != 0)
                            continue;
                        if (reverse(board, i, ii, player, true) == 0)
                            continue;
                        if (i == 0 || i == board.length - 1) {
                            point += 3;
                        }
                        if (ii == 0 || ii == board.length - 1) {
                            point += 3;
                        }
                        point += reverse(board, i, ii, player, true);

                        if (point > max_point) {
                            max_point = point;
                            y = i;
                            x = ii;
                        }
                    }
                }
            }

            reverse(board, y, x, player, false);

            System.out.println("====================");
            player = player % 2 + 1;
        }
        sc.close();
    }
}
