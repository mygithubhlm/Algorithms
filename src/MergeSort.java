
public class MergeSort {
	
	  public static void diaoYong(int[] a){
//		  int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
//	        printArray("排序前：",a);
	        Merge(a);
//	        printArray("排序后：",a);   
	  }

	//打印数组
//	  private static void printArray(String pre,int[] a) {
//	        System.out.print(pre+"\n");
//	        for(int i=0;i<a.length;i++)
//	            System.out.print(a[i]+"\t");    
//	        System.out.println();
//	    }

	  public static void Merge(int[] array){
//		  System.out.println("开始排序");
	        devArray(array, 0, array.length-1);
	        
	  }
	  
	  public static void devArray(int[] array,int begin, int end){
		  if(begin<end){
//		  System.out.println("  hhhh  ");
			  int mid = (int)(begin+end)/2;
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
