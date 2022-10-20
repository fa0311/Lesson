class EvenException extends Exception {
}

class OddException extends Exception {
}

class EvenTest2 {
    static void is_Even(int n) throws EvenException, OddException {
        if (n % 2 == 0) {
            throw new EvenException();
        } else {
            throw new OddException();
        }
    }

    public static void main(String[] args) {
        int a = 3;
        try {
            is_Even(a);
        } catch (EvenException e) {
            System.out.println("偶数です");
        } catch (OddException e) {
            System.out.println("奇数です");
        }
    }

}
