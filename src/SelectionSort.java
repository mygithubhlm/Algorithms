

public class SelectionSort {

	public static int[] selectionSort(int[] list){//��int��һ��Int�͵�����
		int[] newList;
		for(int i = 0 ; i<list.length; i++){
			//Find the minimum in the list
			int currentMax = list[i];
			int currentMaxIndex = i;
			
			/*
			 *���������е�ǰֵ�Ժ��ֵ�����ֵС�ڵ�ǰֵ��
			 *��ô��ʹ����ֵ��currentMax���л���
			 *currentMaxIndex�õ���λ��
			 */
			for (int j = i+1; j<list.length; j++){
				if (currentMax < list[j]){
					currentMax = list[j];
					currentMaxIndex = j;//�õ���ֵ��С���Ǹ�ֵ��λ��
				}
			}
			
			/*
			 * ��������˵�ǰֵ��֮���ֵ�����˽���
			 * ��ô���������currentMax��Ϊ��ǰֵ
			 * ������Сֵ��λ����currentMaxIndex���н���
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
