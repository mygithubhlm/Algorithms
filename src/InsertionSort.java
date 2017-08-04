

public class InsertionSort {
	public static int[] insertionSort(int[] list){
		
		/*
		 * insert list[i] into a sorted sublist list[0...i-1] 
		 * so that list[0..i] is sorted 
		 */
		for (int i = 0; i < list.length; i++) {
			int currentElement = list[i];
			int k ;
			
			/*
			 *比较要插入的值与已有的值的大小如果已有的值存在比要插入的值大的，那么将此值放在最后。
			 *如果已有的值没有比要插入的值大的，那么就将要插入的值放在最后。
			 */
			
			//当已有的值存在比要插入的值大的值的时候。
			for (k = i-1; k>=0&&list[k] > currentElement; k--){
				//Insert the current element into list[k + 1];
				list[k+1] = list[k];
			}
		    
			/*
			 * 当已有的值不存在比要插入的值大的值的时候
			 * 此时k+1的下标位置指的是比当前值大的那个值的下标。
			 */
			
//			System.out.println(list[k+1]+"/"+(k+1));
			//将比要插入的值大的值的下标位置处的值改为当前值
			list[k+1] = currentElement;
	}
		return list;
	}
}
