/* Java応用 */
class IsAmariCheck {
    public static void main(String[] args) {
        System.out.println("余り: " + check(2, 1));
        System.out.println("余り: " + check(1, 2));
    }

    static boolean check(int n, int x) {
        return x % n != 0;
    }
}