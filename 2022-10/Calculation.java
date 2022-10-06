/* 計算用のクラス */
public class Calculation {
    int num;

    Calculation() {
        num = 0;
    }

    /* リセット */
    void reset() {
        num = 0;
    }

    /* 結果表示 */
    void display() {
        System.out.println("計算結果 : " + num);
    }

    /* 足し算 */
    void plus(int x) {
        num = num + x;
    }

    void mines(int x) {
        num = num - x;
    }

    void multiplication(int x) {
        num = num * x;
    }

    void division(int x) {
        num = num / x;
    }
}
