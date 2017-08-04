

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
			 *�Ƚ�Ҫ�����ֵ�����е�ֵ�Ĵ�С������е�ֵ���ڱ�Ҫ�����ֵ��ģ���ô����ֵ�������
			 *������е�ֵû�б�Ҫ�����ֵ��ģ���ô�ͽ�Ҫ�����ֵ�������
			 */
			
			//�����е�ֵ���ڱ�Ҫ�����ֵ���ֵ��ʱ��
			for (k = i-1; k>=0&&list[k] > currentElement; k--){
				//Insert the current element into list[k + 1];
				list[k+1] = list[k];
			}
		    
			/*
			 * �����е�ֵ�����ڱ�Ҫ�����ֵ���ֵ��ʱ��
			 * ��ʱk+1���±�λ��ָ���Ǳȵ�ǰֵ����Ǹ�ֵ���±ꡣ
			 */
			
//			System.out.println(list[k+1]+"/"+(k+1));
			//����Ҫ�����ֵ���ֵ���±�λ�ô���ֵ��Ϊ��ǰֵ
			list[k+1] = currentElement;
	}
		return list;
	}
}
