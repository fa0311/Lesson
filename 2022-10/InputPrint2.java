import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

class InputPrint2 {
    public static void main(String args[]) {
        // ファイル書込
        String fileName = "log.txt";
        try (FileWriter fw = new FileWriter(fileName);) {
            // コマンドプロンプトから入力受付
            Scanner sin = new Scanner(System.in);

            // end と入力されるまで、入力を受け付ける
            System.out.println("ファイルへ入力した文字を出力します。");
            System.out.println("終了するには end と入力してください。");
            PrintWriter out = new PrintWriter(fw);
            while (true) {
                String input = sin.nextLine();
                if (input.equals("end")) {
                    System.out.println("y(yes)?/n(no)?");
                    if (sin.nextLine().equals("y")) {
                        sin.close();
                        break;
                    } else {
                        continue;
                    }
                }
                out.println(input);
            }
            System.out.println(fileName + "ファイルに出力しました。");

        } catch (Exception e) {
            // エラーを表示する
            e.printStackTrace();
        }
    }
}
