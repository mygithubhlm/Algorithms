package lab3;

public class TestStableForQuickSort {

	public static void  main(String[] args){
		int[] A = {2,8,7,1,3,5,6,4,4};
		
		/*
		 * 		aString与数组A对应，其中A数组中的两个2在AString中分别用“我”和“们”代替
		 * 	aString中的数据下标和A数组中的下标做同样的变动，那么，可以通过打印数的AString
		 * 	中“我”和“们”的相对位置是否变化就可以知道A数组是否为stable.
		 */
				
//				用于检测的数组
		String[] AString = {"2","8","7","1","3","5","6","我","们"};
		int[] newA = quickSort(A, AString,0, A.length);
		for (int i = 0; i < newA.length; i++) {
			System.out.println(newA[i]);
		}
	}
	
	public static int[] quickSort(int[] A, String[] aStrings,int p , int r){
		if (p<r){
			int q = partition(A,aStrings, p ,r);
			quickSort(A,aStrings, p, q);
			quickSort(A,aStrings, q+1, r);
		}
		return A;
	}
	
//	partition 过程将一个长数组划分为两部分
	public static int partition(int[] A,String[] aStrings, int p, int r){
		int x = A[r-1];
		int i = p-1;
		for(int j=p; j<r-1; j++){
			if(A[j]<=x){
//				交换A[i]和A[j]的值
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
//				交换aStrings[i]和 aString[j]的值
				String temp2 = aStrings[i];
				aStrings[i] = aStrings[j];
				aStrings[j] = temp2;
			}
		}
//		交换A[i+1]和A[r]的值
		int temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
//		交换aStrings[i+1]和aStrings[r]的值
		String temp2 = aStrings[i+1];
		aStrings[i+1] = aStrings[r-1];
		aStrings[r-1] = temp2;
		
		for (int d = 0; d< aStrings.length; d++) {
			System.out.print(aStrings[d]+" , ");
		}
		System.out.println();
		return i+1;
	}
}
