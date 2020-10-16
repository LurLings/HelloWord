package test;

import java.text.ParseException;
import java.util.Date;

public class Time {
	public static void main(String[] args) {
		java.util.Date nowdate = new java.util.Date();
		String myString = "2020年06月29日 00:00";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH:mm", java.util.Locale.CHINA);
		Date d;
		try {
			d = sdf.parse(myString);
			boolean flag = d.before(nowdate);
			if (flag) {
				System.out.print("早于今天");
			} else {
				System.out.print("晚于今天");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String FileName = "2020070110271655698533195";
		String datePath = "";
		if (FileName.length() > 6) {
			datePath = FileName.substring(0, 6);
		}
		System.out.println(datePath);
	}
}
