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
	
//	���øĽ������quicksort��������������
	public static int[] quickSort(int[] A, int p , int r){
		if (p<r){
			int q = partition(A, p ,r);
//			�ݹ����quickSort
			quickSort(A, p, q);
			quickSort(A, q+1, r);
		}
		return A;
	}
	
//	partition ���̽�һ�������黮��Ϊ������
	public static int partition(int[] A, int p, int r){
		int x = A[r-1];
		int i = p-1;
		for(int j=p; j<r-1; j++){
//			��A[j]<=x��ʱ��
			if(compareNums(A[j],x)){
//				����A[i]��A[j]��ֵ
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
//		����A[i+1]��A[r]��ֵ
		int temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
		return i+1;
	}
	
/*
 * �Ƚ�����������С���ķ���
 * ����ġ���С��������ͨ����˵�Ĵ�С
 */
	public static boolean compareNums(int a,int b){
		String aStr = a+"";
		String bStr = b+"";
		String numStr1 = aStr+bStr;
		String numStr2 = bStr+aStr;
		int num1 = Integer.parseInt(numStr1);
		int num2 = Integer.parseInt(numStr2);
//		���num1>num2�򷵻�true����ʾa>b;���num1<=num2�򷵻�false����ʾaС��b
		if(num1>num2){
			return true;
		}else {
			return false;
		}
	}
}
