class userCheck {
    static final String userID = "ivy"; // ユーザーID
    static final String userPW = "12345"; // パスワード

    public static void main(String args[]) {
        // Aさん
        String userAid = "kokomite";
        int userApw = 98765;
        String resultA = checkUserInfo(userAid, userApw);
        // 結果
        System.out.println(userAid + ":" + userApw + "は" + resultA);
        // Bさん
        String userBid = "ivy";
        int userBpw = 12345;
        String resultB = checkUserInfo(userBid, userBpw);
        // 結果
        System.out.println(userBid + ":" + userBpw + "は" + resultB);
        // Cさん
        String userCid = "ivy";
        int userCpw = 77777;
        String resultC = checkUserInfo(userCid, userCpw);
        // 結果
        System.out.println(userCid + ":" + userCpw + "は" + resultC);
    }

    /*
     * ユーザーID(iptId)とパスワード(iptPw)の両方が一致したら結果を文字列で返却する
     * ①userID と iptId を比較する ②userPW と iptPw を比較する
     * ①②の両方が一致していればＯＫ、でなければＮＧ
     */
    static String checkUserInfo(String iptId, int iptPw) {
        String ret = "";
        if (userID.equals(iptId) && userPW.equals(Integer.toString(iptPw))) {
            ret = "ユーザー情報が一致しました";
        } else {
            ret = "ユーザー情報が一致しませんでした";
        }
        return ret;
    }
}