package jianzhiOffer;

/**
 * 剑指offer 面试题4 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author QingXi
 * 详情见 http://blog.csdn.net/zqx1205/article/details/77683180
 */



public class Solution4 {
	/**
	 * 递归版本 从右上角开始查找
	 * 这种办法效率较低，不建议采用
	 * @param target
	 * @param array
	 * @return if find return true, else return false
	 */
	public boolean FindRecursive(int target, int[][] array) {
		return findCore(target, array, array.length - 1, array[array.length-1].length - 1);
	}
	
	/**
	 * 递归查找核心函数
	 * 当行下标和列下标都大于0时，
	 * 如果当前数字等于要查找的数字，返回true；如果小于要查找的数字，返回false；
	 * 否则递归查找当前数字的左边或者上边
	 * @param target
	 * @param array
	 * @param i
	 * @param j
	 * @return if find return true, else return false
	 */
	public boolean findCore(int target, int[][] array, int i, int j) {
		if(i >= 0 && j >= 0) {
			if(array[i][j] == target) {
				return true;
			}
			else if (array[i][j] < target) {
				return false;
			}
			else {
				return (findCore(target, array, i-1, j) || findCore(target, array, i, j-1));
			}
		}
		return false;
	}
	
	/**
	 * 从右上角开始找起，若当前数字不等于要找的数字，则每次都能
	 * 去掉一行或者一列，直至找到或者能查找的范围变为空（也就是没找到）
	 * @param target
	 * @param array
	 * @return if find return true, else return false
	 */
	public boolean Find(int target, int[][] array) {
		boolean result = false;
		if (array.length == 0) {
			return result;
		}
		int row = 0;
		int col = array[row].length - 1;
		while(row < array.length && col >= 0) {
			if (array[row][col] == target) {
				result = true;
				break;
			}
			else if (array[row][col] > target) {
				col--;
			}
			else {
				row++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		Solution4 s4 = new Solution4();
		System.out.println(s4.Find(9, array));
		System.out.println(s4.Find(3, array));
	}

}
