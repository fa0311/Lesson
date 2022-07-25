import java.util.Scanner;

// 追記: 説明のコメントを追加しました

public class othello {

    // boardの初期化
    // 0: 何もない場所
    // 1: 黒
    // 2: 白

    static void init(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (i == 3 && ii == 3)
                    board[i][ii] = 2;
                else if (i == 3 && ii == 4)
                    board[i][ii] = 1;
                else if (i == 4 && ii == 3)
                    board[i][ii] = 1;
                else if (i == 4 && ii == 4)
                    board[i][ii] = 2;
                else
                    board[i][ii] = 0;
            }
        }
    }

    // コンソールに出力

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
                        System.out.print("○");
                        break;
                    case 2:
                        System.out.print("●");
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

    // playerがboardに置けるかどうか

    static boolean can_place_on_board(int board[][], int player) {
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] == 0 && reverse(board, i, ii, player, true) > 0)
                    return true;
            }
        }
        return false;
    }

    // yとxがboardの範囲内かどうか

    static boolean is_range(int board[][], int y, int x) {
        return !(y < 0 || x < 0 || y >= board.length || x >= board[y].length);
    }

    // boardのyとxにplayerが石を置き実際にひっくり返す
    // ひっくり返した石の数を返す
    // dry_runならひっくり返さない

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

    // boardをコピーする

    static int[][] board_copy(int board[][]) {
        int[][] copy = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                copy[i][ii] = board[i][ii];
            }
        }
        return copy;
    }

    // 置いた手を評価する

    static int get_score(int board[][], int y, int x, int player, int recursive) {
        int point = 0;

        if (y == 0 || y == board.length - 1) {
            point += 3;
        }
        if (x == 0 || x == board.length - 1) {
            point += 3;
        }

        int[][] copy = board_copy(board);
        point += reverse(copy, y, x, player, false);
        if (get_count(copy, player % 2 + 1) == 0) {
            point += 100;
        }

        if (recursive > 0) {
            boolean palce_flag = can_place_on_board(copy, player % 2 + 1);
            if (!palce_flag) {
                point += 10;
                player = player % 2 + 1;
            }

            int max_score = -1;
            boolean first = true;

            for (int i = 0; i < copy.length; i++) {
                for (int ii = 0; ii < copy[i].length; ii++) {
                    if (copy[i][ii] != 0)
                        continue;
                    if (reverse(copy, i, ii, player % 2 + 1, true) == 0)
                        continue;
                    int score = get_score(copy, i, ii, player % 2 + 1, recursive - 1);

                    if (first || score > max_score) {
                        first = false;
                        max_score = score;
                    }
                }
            }

            if (palce_flag) {
                point -= max_score;
            } else {
                point += max_score;
            }

        }
        return point;
    }

    // 石の数を数える

    static int get_count(int board[][], int player) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[i].length; ii++) {
                if (board[i][ii] == player) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        // 初期化とモード選択

        final boolean DEBUG_MODE = false;
        int[][] board = new int[8][8];
        Scanner sc = new Scanner(System.in);
        int player = 1;
        int cant_place_count = 0;
        int bot_lv = 0, bot_lv_2 = 0;
        int mode = -1;

        while (mode < 0 || mode > 3) {
            System.out.println("モードを入力してください");
            System.out.println("0 2人で遊ぶ");
            System.out.println("1 Botと遊ぶ(先行)");
            System.out.println("2 Botと遊ぶ(後攻)");
            System.out.println("3 傍観");
            mode = sc.nextInt();

            if (mode >= 1 && mode <= 3) {
                System.out.println("Botのレベルを入力してください  6以上高負荷");
                bot_lv = sc.nextInt();
            }
            if (mode == 3) {
                System.out.println("2人目のBotのレベルを入力してください");
                bot_lv_2 = sc.nextInt();
            }
            if (mode < 0 || mode > 3) {
                System.out.println("入力値が不正です");
            }
        }

        init(board);

        // オセロのループ
        // 空白の数が0になるまで繰り返す

        while (get_count(board, 0) > 0 && cant_place_count < 2) {
            disp(board);
            switch (player) {
                case 1:
                    System.out.println("○の番です");
                    break;
                case 2:
                    System.out.println("●の番です");
                    break;
            }
            if (!can_place_on_board(board, player)) {
                System.out.println("置ける場所がないためパスしました");
                player = player % 2 + 1;
                cant_place_count++;
                continue;
            }

            int x = 0, y = 0;
            if ((mode == 0 || player == 1 && mode == 1) || (player == 2 && mode == 2)) {

                // もし人間の番なら

                System.out.println("列を入力してください");
                y = sc.nextInt();

                System.out.println("行を入力してください");
                x = sc.nextInt();

                if (!is_range(board, y, x)) {
                    System.out.println("ここには置けません");
                    continue;
                }

                if (board[y][x] != 0) {
                    System.out.println("ここには置けません");
                    continue;
                }

                if (reverse(board, y, x, player, true) == 0) {
                    System.out.println("ここには置けません");
                    continue;
                }

            } else {

                // もしBotの番なら

                int recursive;
                if (mode == 3 && player == 2) {
                    recursive = bot_lv_2;
                } else {
                    recursive = bot_lv;
                }
                System.out.println("計算中です");

                int max_score = -1;
                boolean first = true;

                for (int i = 0; i < board.length; i++) {
                    for (int ii = 0; ii < board[i].length; ii++) {
                        if (board[i][ii] != 0)
                            continue;
                        if (reverse(board, i, ii, player, true) == 0)
                            continue;
                        int score = get_score(board, i, ii, player, recursive);
                        if (DEBUG_MODE) {
                            System.out.println("列:" + i + ", 行" + ii + ", 評価" + score);
                        }
                        if (first || score > max_score || recursive < 0) {
                            first = false;
                            max_score = score;
                            y = i;
                            x = ii;
                        }
                    }
                }

                System.out.println("Botの打った手");
                if (DEBUG_MODE) {
                    System.out.println("列:" + y + ", 行" + x + ", 評価" + max_score);
                } else {
                    System.out.println("列:" + y + ", 行" + x);
                }
            }

            System.out.println("====================");

            // 実際にboard上の石をひっくり返す

            reverse(board, y, x, player, false);

            // 次の手に行くための処理

            player = player % 2 + 1;
            cant_place_count = 0;
        }

        // 結果発表

        sc.close();

        disp(board);
        System.out.println("結果発表");

        int black_player_count = get_count(board, 1);
        System.out.print("○: ");
        System.out.print(black_player_count);
        System.out.println("個");

        int white_player_count = get_count(board, 2);
        System.out.print("●: ");
        System.out.print(white_player_count);
        System.out.println("個");

        if (white_player_count < black_player_count) {
            System.out.print("○の勝ち");
        } else if (white_player_count > black_player_count) {
            System.out.print("●の勝ち");
        } else {
            System.out.print("引き分け");
        }

    }
}
