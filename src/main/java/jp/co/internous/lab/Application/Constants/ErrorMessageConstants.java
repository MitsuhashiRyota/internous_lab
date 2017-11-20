package jp.co.internous.lab.Application.Constants;

public final class ErrorMessageConstants {


	private ErrorMessageConstants() {

	}

	public static class ErrorMessage {
		public static final String NULL_MESSAGE = "が未入力です。";
		public static final String LENGTH_ORVER_MESSAGE = "は\"{min}\"文字以上\"{max}\"文字以下で入力してください。";
		public static final String PATTERN_HANKAKU_ENGLISH_NUMBER = "半角英数字";
		public static final String PATTERN_HANKAKU_ENGLISH = "半角英語";
		public static final String PATTERN_JAPAN = "ひらがなカタカナ漢字";
		public static final String PATTERN = "で入力してください。";
		public static final String INSERT_DATA_MESSAGE = "ログインIDが重複してます。";
	}
}
