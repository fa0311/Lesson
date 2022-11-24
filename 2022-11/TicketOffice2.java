/**
 * チケット売り場
 */
class TicketOffice2 {
    public static void main(String[] args) {
        TicketCenter2 tcener = new TicketCenter2();
        TicketPurchaseThread2 thread1 = new TicketPurchaseThread2(tcener, 10);
        TicketPurchaseThread2 thread2 = new TicketPurchaseThread2(tcener, 10);
        TicketPurchaseThread2 thread3 = new TicketPurchaseThread2(tcener, 10);

        Thread a = new Thread(thread1);
        Thread b = new Thread(thread2);
        Thread c = new Thread(thread3);

        a.start();
        b.start();
        c.start();
    }
}

/**
 * チケット購入処理をするクラス
 */
class TicketPurchaseThread2 implements Runnable {
    static TicketCenter2 tc;
    static int num;

    TicketPurchaseThread2(TicketCenter2 tcenter, int maxNumber) {
        tc = tcenter;
        num = maxNumber;
    }

    @Override
    public void run() {
        int getNum = 0;
        int getTotalNum = 0;

        while (true) {
            getNum = tc.buy(1); // 1枚ずつ購入することとする
            tc.check();
            // 購入できなくなったら終了
            if (getNum <= 0) {
                break;
            }
            // 購入枚数を達成できたら終了
            if (getNum == num) {
                break;
            }
            // 購入枚数を数える
            getTotalNum += getNum;
        }

        System.out.println("*****" + Thread.currentThread().getName() + ":"
                + getTotalNum + "枚購入できました");
    }
}

/**
 * チケット販売処理をするクラス
 */
class TicketCenter2 {
    private int ticket = 10; // 販売するチケットの枚数は10枚とする

    // 指定した枚数分、チケットを販売する
    public synchronized int buy(int num) {
        try {
            if (ticket <= 0) {
                System.out.println("チケットは売り切れです");
                return 0;
            }
            if (ticket < num) {
                System.out.println("チケットは残り" + ticket + "枚です(購入できません)");
                return 0;
            }
            System.out.println("チケットは購入可能です");
            System.out.println("チケット購入処理中・・・");
            Thread.sleep(1000);
            ticket = ticket - num; // チケットを購入

            System.out.println("チケットを" + num + "枚購入しました。");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return num;
    }

    // チケットの残りの枚数を表示する
    public void check() {
        System.out.println("チケットは残り" + ticket + "枚です");
        if (ticket < 0) {
            System.out.println("警告：チケットの空売りが発生しています！");
        }
    }
}
