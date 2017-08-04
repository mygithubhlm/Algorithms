
public class ForN {
	  static int n = 0;
		public static void main(String[] args){
			
			//要进行操作的数组
			int[] list2 = {6,7,4,3,2,1};
				
			 //	获取当前时间
//			long time3 = System.nanoTime()/1000L;
//			int result = compute(list2);
//			System.out.println("inversions are  "+result);
			//
			ForN.Merge(list2);
			System.out.println(n);
			 //	再次获取当前时间
//			long time4 = System.nanoTime()/1000L;
			
//			for (int i = 0; i < list2.length; i++) {
//				System.out.printf("%8d",list2[i]);
//				if((i+1)%10==0||i==list2.length-1)
//					System.out.println();
//			}
			
		}

	  public static void Merge(int[] array){
	       devArray(array, 0, array.length-1);
	  }
	  
	  public static void devArray(int[] array,int begin, int end){
		  int re = 0;
		  if(begin<end){
//		  System.out.println("  hhhh  ");
			  int mid = (int)(begin+end)/2;
			  devArray(array, begin, mid);
			  devArray(array, mid+1, end);
		  	  re = sortArray(array,begin,mid,end);
		  }
	  }
	  
	
	  
	  public static int sortArray(int[] array,int begin,int mid,int end){
//		  int n = 0;
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
		     	n = n + left.length - i - 1;
			  }
		  }
		  return n;
	  }
}

