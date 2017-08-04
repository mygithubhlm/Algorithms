package lab5;

import java.math.BigDecimal;

public class DigitsComb {
	
	
	public static void  main(String[] args){
		int[] A = {1,2,3,4,5,6,7,17,21,34};
		DigitsComb a = new DigitsComb();
		System.out.println(a.digitsCombination(A));
	}
	
	public BigDecimal digitsCombination(int[] array){
		// TODO Auto-generated method stub
		int[] newArray = quickSort(array, 0, array.length);
		String result = "";
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i]+",");
			result+=newArray[i];
		}
		BigDecimal re = new BigDecimal(result);
		return re;
	}
	
//	利用改进过后的quicksort方法对数组排序；
	public static int[] quickSort(int[] A, int p , int r){
		if (p<r){
			int q = partition(A, p ,r);
//			递归调用quickSort
			quickSort(A, p, q);
			quickSort(A, q+1, r);
		}
		return A;
	}
	
//	partition 过程将一个长数组划分为两部分
	public static int partition(int[] A, int p, int r){
		int x = A[r-1];
		int i = p-1;
		for(int j=p; j<r-1; j++){
//			当A[j]<=x的时候
			if(compareNums(A[j],x)){
//				交换A[i]和A[j]的值
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
//		交换A[i+1]和A[r]的值
		int temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
		return i+1;
	}
	
/*
 * 比较两个数“大小”的方法
 * 这里的“大小”并非是通常所说的大小
 */
	public static boolean compareNums(int a,int b){
		String aStr = a+"";
		String bStr = b+"";
		String numStr1 = aStr+bStr;
		String numStr2 = bStr+aStr;
		int num1 = Integer.parseInt(numStr1);
		int num2 = Integer.parseInt(numStr2);
//		如果num1>num2则返回true，表示a>b;如果num1<=num2则返回false，表示a小于b
		if(num1>num2){
			return true;
		}else {
			return false;
		}
	}
}
