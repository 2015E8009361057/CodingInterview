package jianzhiOffer;

import java.util.Scanner;

/**
 * 剑指offer 面试题5 替换空格
 * @author QingXi
 * 详情见 http://blog.csdn.net/zqx1205/article/details/77776953
 */

public class Solution5 {
	
	/**
	 * 这种思路更直白：逐个扫描字符，若是空白字符，则将“%20”追加至结果字符串；
	 * 否则将当前字符追加至结果字符串。
	 * @param str
	 * @return 替换后的字符串
	 */
	public static String replaceSpace(StringBuffer str) {
		String result = "";
		if(str.equals("")) {
			return result;
		}
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				result = result + "%20";
			}
			else {
				result = result + str.charAt(i);
			}
		}
		return result;
	}
	
	/**
	 * 从前往后扫描
	 * @param str
	 * @return 替换后的字符串
	 */
	public static String replaceBlank(String str) {
		if(str.equals("") || str.length() == 0) {
			return "";
		}
		int pos = 0;
		String replace = "%20";
		while(pos < str.length()) {
			String curStr = str.substring(pos, pos + 1);
			if (curStr.equals(" ")) {
				str = str.substring(0, pos) + replace + str.substring(pos + 1);
				pos = pos + 2;
			}
			else {
				pos = pos + 1;
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			System.out.println(replaceBlank(str));
			System.out.println(replaceSpace(new StringBuffer(str)));
		}
	}

}
