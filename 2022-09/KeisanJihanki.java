class KeisanJihanki {
    public static void main(String[] args) {
        /*
         * 自販機を模したプログラムです
         * この自販機では500円、100円、50円、10円の硬貨しか扱えないものとし、
         * お釣りも上記の硬貨を組み合わせたのもとなります。
         * 自販機の飲み物はすべて160円とします。
         */

        // 投入金額
        int entry_amount = 90;
        kounyu(entry_amount);
        /*
         * 条件分岐を利用して以下を表示してください。
         * 投入金額が160円の場合は
         * 「ドリンクが購入出来ました【お釣りなし】」と出力
         * 投入金額が160円よりも多い場合は
         * 「ドリンクが購入出来ました【お釣りあり】」と出力
         * 「お釣りはXXX円になります」と出力
         * 投入金額が160円より少ない場合は、
         * 「金額が足りません」と出力
         */
    }

    static void kounyu(int entryCoin) {
        int diff;
        System.out.println("投入金額は" + entryCoin + "円です");
        if (entryCoin == 160) {
            System.out.println("ドリンクが購入出来ました【お釣りなし】");
        } else if (entryCoin < 160) {
            System.out.println("金額が足りません");
        } else {
            entryCoin -= 160;
            System.out.println("ドリンクが購入出来ました【お釣りあり】");
            System.out.println("お釣りは" + entryCoin + "円になります");
            System.out.print("返却硬貨は");

            diff = entryCoin / 500;
            System.out.print("500円玉 " + diff + "枚、");
            entryCoin -= diff * 500;

            diff = entryCoin / 100;
            System.out.print("100円玉 " + diff + "枚、");
            entryCoin -= diff * 100;

            diff = entryCoin / 50;
            System.out.print("50円玉 " + diff + "枚、");
            entryCoin -= diff * 50;

            diff = entryCoin / 10;
            System.out.print("10円玉 " + diff + "枚");
            entryCoin -= diff * 10;
        }
    }
}
