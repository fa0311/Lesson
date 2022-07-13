class errorFix2 {
	public static void main(String[] args) {
		System.out.println("1問目");
		// 0から4までの数字を2で割った値を配列に設定して表示
		int[] T1 = new int[5];
		int j = 2;
		for (int i = 0; i < T1.length; i++) {
			T1[i] = i / j;
		}

		for (int i = 0; i < T1.length; i++) {
			System.out.println(i + "番目:" + T1[i]);
		}
		System.out.println("\n");

		System.out.println("2問目");
		// 配列のNormal課題2問目と同じ問題
		int[] T2;
		T2 = new int[7];
		for (int i = 0; i < 7; i++) {
			T2[i] = i + 1;
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(i + "番目:" + T2[i]);
		}
		System.out.println("\n");

		System.out.println("3問目");

		// 配列のNormal課題3問目と同じ問題(処理の修正はないので、インデントのみ調整)
		int[] T3;
		T3 = new int[7];
		for (int i = 1; i < 7; i++) {
			T3[i] = i * 2;
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(i + "番目:" + T3[i]);
		}
		System.out.println("\n");

		System.out.println("4問目");
		// 配列のNormal課題4問目と同じ問題(処理の修正はないので、インデントのみ調整)
		int[] T4;
		T4 = new int[7];
		for (int i = 0; i < 7; i++) {
			T4[i] = i * 2 + 1;
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(i + "番目:" + T4[i]);
		}
		System.out.println("\n");

		System.out.println("5問目");
		// 配列のNormal課題5問目と同じ問題(処理の修正はないので、インデントのみ調整)
		// class ~の終了の中かっこや、～mainの終了の中かっこも必要に応じて位置を調整すること
		int[] T5;
		T5 = new int[7];
		for (int i = 0; i < 7; i++) {
			T5[i] = T3[i] + T4[i];
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(i + "番目:" + T5[i]);
		}
		System.out.println("\n");

	}
}