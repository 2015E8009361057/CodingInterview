package jianzhiOffer;

/**
 * 剑指offer 面试题3：找出数组中重复的数字
 * @author QingXi
 * 详情见 http://blog.csdn.net/zqx1205/article/details/77765057
 */

public class Solution3 {
	
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
	 * hash思想
	 * @param array
	 * @return repeat number,若不存在,返回-1;若是非法输入,返回-2
	 * 时间复杂度O(n)，空间复杂度O(n)
	 */
	public static int findRepeatNumber(int[] array) {
		int result = -1;
		if(!isValidInput(array)) {
			result = -2;
			return result;
		}
		int[] hash = new int[array.length];
		for (int i = 0; i < hash.length; i++) {
			hash[i] = 0;
		}
		for (int i = 0; i < array.length; i++) {
			if (hash[array[i]] > 0) {
				result = array[i];
				break;
			}
			hash[array[i]]++;
		}
		return result;
	}
	
	/**
	 * 交换思想
	 * @param array
	 * @return repeat number,若不存在,返回-1;若是非法输入,返回-2
	 * 时间复杂度O(n),空间复杂度O(1)
	 */
	public static int duplicate(int[] array) {
		int result = -1;
		if (!isValidInput(array)) {
			result = -2;
			return result;
		}
		for (int i = 0; i < array.length; i++) {
			while(array[i] != i) {
				if(array[i] == array[array[i]]) {
					result = array[i];
					return result;
				}
				else {
					int temp = array[i];
					array[i] = array[temp];
					array[temp] = temp;
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] array = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(array));
		System.out.println(duplicate(array));
	}

}
