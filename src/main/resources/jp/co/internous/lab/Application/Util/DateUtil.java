package jp.co.internous.lab.Application.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 現在時刻取得メソッド
	 *
	 * @return String
	 */
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}

	/**
	 * String型Date値をDate型にラップ
	 * @param date
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateWrapper(String stringDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.parse(stringDate);
	}
 }