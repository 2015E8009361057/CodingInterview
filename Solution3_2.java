package jianzhiOffer;

/**
 * 剑指offer 面试题3 题目二 ： 不修改数组找出重复的数字
 * @author QingXi
 * 详情见 http://blog.csdn.net/zqx1205/article/details/77765057
 */

public class Solution3_2 {
	
	/**
	 * 输入合法性校验
	 * @param array
	 * @return boolean value
	 */
	public static boolean isValidInput(int[] array) {
		boolean result = true;
		if (array.length == 0) {
			result = false;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] >= array.length) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 统计数组中在某一范围内的数字的数目
	 * @param array
	 * @param start
	 * @param end
	 * @return 数组中在某一范围内的数字的数目
	 * 时间复杂度O(n)
	 */
	public static int countRange(int[] array, int start, int end) {
		int count = 0;
		if (array.length == 0) {
			return count;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= start && array[i] <= end) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 二分查找思想
	 * @param array
	 * @return repeat number,若不存在,返回-1;若是非法输入,返回-2
	 * 时间复杂度O(nlogn),空间复杂度O(1)
	 */
	public static int getDuplication(int[] array) {
		int result = -1;
		if(!isValidInput(array)) {
			result = -2;
			return result;
		}
		
		int start = 1;
		int end = array.length - 1;
		while(end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(array, start, middle);
			if (end == start) {
				if (count > 1) {
					result = start;
				}
				break;
			}
			if (count > (middle - start + 1)) {
				end = middle;
			}
			else {
				start = middle + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(getDuplication(array));
	}

}
