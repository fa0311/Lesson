
/* Java応用 */
import java.util.Random;

class todayUranai {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("仕事運 : " + getStar(rand.nextInt(5) + 1, 5));
        System.out.println("金　運 : " + getStar(rand.nextInt(5) + 1, 5));
        System.out.println("恋愛運 : " + getStar(rand.nextInt(5) + 1, 5));
    }

    static String getStar(int n, int length) {
        String output = "";
        for (int i = 0; i < n; i++) {
            output += "★ ";
        }
        for (int i = 0; i < length - n; i++) {
            output += "☆ ";
        }
        return output;
    }
}
