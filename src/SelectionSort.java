

public class SelectionSort {

	public static int[] selectionSort(int[] list){//传int入一个Int型的数组
		int[] newList;
		for(int i = 0 ; i<list.length; i++){
			//Find the minimum in the list
			int currentMax = list[i];
			int currentMaxIndex = i;
			
			/*
			 *遍历数组中当前值以后的值，如果值小于当前值，
			 *那么就使它的值与currentMax进行互换
			 *currentMaxIndex得到的位置
			 */
			for (int j = i+1; j<list.length; j++){
				if (currentMax < list[j]){
					currentMax = list[j];
					currentMaxIndex = j;//得到数值较小的那个值的位置
				}
			}
			
			/*
			 * 如果发现了当前值与之后的值发生了交换
			 * 那么将交换后的currentMax作为当前值
			 * 并把最小值的位置与currentMaxIndex进行交换
			 */
			if (currentMaxIndex != i){
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
		}
		newList = list;
		return newList;
	}
	
	public static void main(String[] args){
		int[] list = {6,3,2,5,8,1};
		selectionSort(list);
		for(int i=0;i<list.length;i++){
			System.out.println(list[i]+"  ");
		}
	}

}
