
public class CombileOfTwo {
	
	//temp作为初始k值
	static int temp = 30;
	public static void main(String[] args){
//		数据规模;
		int theNum = 1000;//input.nextInt();

		int[] list = Numbers.num(theNum);
			
//		//检验归并排序的结果
		
		
	for (int i = temp; i < 1000; i++) {
		int[] list2 = Numbers.num(theNum);
		
		 //	获取当前时间
		long time3 = System.nanoTime()/1000L;
		CombileOfTwo.Merge(list2);
		 //	再次获取当前时间
		long time4 = System.nanoTime()/1000L;
		
//		将排序后的数组打印出来；
//		for (int i = 0; i < list2.length; i++) {
//			System.out.printf("%8d",list2[i]);
//			if((i+1)%10==0||i==list2.length-1)
//				System.out.println();
//		}
		
		System.out.println((time4-time3));

	   }
	}


	  public static void Merge(int[] array){
	        devArray(array, 0, array.length-1);
	        
	  }
	  
	  public static void devArray(int[] array,int begin, int end){
		  if(begin<end){
			  int mid = (int)(begin+end)/2;
			  
			  //当数据规模小于key值时开始调用InsertionSort
			  if(begin-end<temp){
				  int[] newArray = new int[end-begin];
				  int tep = 0;
				  for(int j=begin;j<end;j++){
					  newArray[tep] = array[j];
					  tep++;
				  }
				  InsertionSort.insertionSort(newArray);
//				  for(int p = 0;p<newArray.length; p++)
//				  System.out.print(newArray[p]+"   ");
			  }
			  devArray(array, begin, mid);
			  devArray(array, mid+1, end);
			  sortArray(array,begin,mid,end);
		  }
	  }
	  
	
	  
	  public static void sortArray(int[] array,int begin,int mid,int end){
		  int n1 = mid - begin + 1;
		  int n2 = end - mid;
		  
		//将array数组拆分为两个子数组
		  int[] left = new int[n1+1];
		  int[] right = new int[n2+1];
		  
		  for(int i = 0;i<n1; i++){
			  left[i]=array[begin+i];
		  }
		  for(int j=0;j<n2;j++){
			  right[j]=array[mid+j+1];
		  }
		  
		  //将left和right的最后一值设为极大
		  left[n1]=11111111;
		  right[n2]=11111111;
		  int i = 0;
		  int j = 0;
		  
		  for(int k = begin; k<=end; k++){
			  if(left[i]<=right[j]){
				  array[k]=left[i];
				  i=i+1;
			  }
			  else{
				array[k]=right[j];
				j=j+1;
			  }
		  }
	  }
}
