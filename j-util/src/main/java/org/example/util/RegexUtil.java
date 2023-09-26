package org.example.util;

public class RegexUtil {
	/** 5位数字 */
	public static String NUMBER = "^[0-9]{5}$";
	/** 只能输入有两位小数的正实数 */
	public static String NUMBER2 = "^[0-9]+(.[0-9]{2})?$";
	/** 只能输入汉字 */
	public static String CHINESE = "^[\u4e00-\u9fa5]{0,}$";
	/** email */
	public static String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/** IP地址 */
	public static String IP = "\\d+\\.\\d+\\.\\d+\\.\\d+";
}
