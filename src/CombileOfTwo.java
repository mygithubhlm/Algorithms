
public class CombileOfTwo {
	
	//temp��Ϊ��ʼkֵ
	static int temp = 30;
	public static void main(String[] args){
//		���ݹ�ģ;
		int theNum = 1000;//input.nextInt();

		int[] list = Numbers.num(theNum);
			
//		//����鲢����Ľ��
		
		
	for (int i = temp; i < 1000; i++) {
		int[] list2 = Numbers.num(theNum);
		
		 //	��ȡ��ǰʱ��
		long time3 = System.nanoTime()/1000L;
		CombileOfTwo.Merge(list2);
		 //	�ٴλ�ȡ��ǰʱ��
		long time4 = System.nanoTime()/1000L;
		
//		�������������ӡ������
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
			  
			  //�����ݹ�ģС��keyֵʱ��ʼ����InsertionSort
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
		  
		//��array������Ϊ����������
		  int[] left = new int[n1+1];
		  int[] right = new int[n2+1];
		  
		  for(int i = 0;i<n1; i++){
			  left[i]=array[begin+i];
		  }
		  for(int j=0;j<n2;j++){
			  right[j]=array[mid+j+1];
		  }
		  
		  //��left��right�����һֵ��Ϊ����
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
