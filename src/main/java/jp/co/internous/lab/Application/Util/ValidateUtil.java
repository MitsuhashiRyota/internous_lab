package jp.co.internous.lab.Application.Util;

import jp.co.internous.lab.Application.Constants.Constants;

public class ValidateUtil {

	private static boolean checkValue;

	/**
	 * 入力値の長さを確認
	 * @param object
	 * @param min
	 * @param max
	 * @return
	 * @throws NullPointerException
	 */
	public static boolean checklength(String value, int min, int max) throws NullPointerException{

		checkValue = false;

		if(value.isEmpty()) {
			throw new NullPointerException(Constants.ExceptionMessage.NULL_POINTER_EXCEPTION);
		} else if((value.length() >= min) && (value.length() <= max)) {
			checkValue = true;
		}

		return checkValue;
	}
}
