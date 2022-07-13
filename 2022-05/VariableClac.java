public class VariableClac {
    public static void main(String[] args) {
        System.out.println("処理スタート");

        int varA, varB, varC; // 変数の宣言
        varA = 10; // 変数Aへ値を代入
        varB = 6; // 変数Bへ値を代入

        // A + B
        varC = varA + varB; // 変数Cへ計算結果を代入
        System.out.println("A+Bの値は");
        System.out.print(varC); // 変数Cの結果を表示
        System.out.println("です");

        // A - B
        varC = varA - varB; // 変数Cへ計算結果を代入
        System.out.println("A-Bの値は");
        System.out.print(varC); // 変数Cの結果を表示
        System.out.println("です");

        // A × B
        varC = varA * varB; // 変数Cへ計算結果を代入
        System.out.println("A*Bの値は");
        System.out.print(varC); // 変数Cの結果を表示
        System.out.println("です");

        // A ÷ Bの余り
        varC = varA % varB; // 変数Cへ計算結果を代入
        System.out.println("A ÷ Bの余りの値は");
        System.out.print(varC); // 変数Cの結果を表示
        System.out.println("です");

        System.out.print("\n");
        System.out.println("処理終了");
    }
}
