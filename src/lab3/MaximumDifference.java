package lab3;
/*
 * ���� ���������������������
 */
import java.util.ArrayList;
import java.util.Collections;

public class MaximumDifference {
	public static ArrayList<ArrayList<Integer>> bucketSort(int[] A){
//		����һ��ArrayList���͵Ķ�ά����
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
//		��ʼ��B
		for(int i=0;i<10;i++){//������10����Ϊ��������ݶ���һ�����ڵ���λ�������ҵ�19�г���10����ʹͰ�������ȽϺ���
			B.add(new ArrayList<Integer>());
		}
//		��A�е�Ԫ�ط����Ӧ��Ͱ�У�ͬһͰ�е�Ԫ���ۼ�
		for(int i=0;i<A.length;i++){
			B.get(A[i]/10).add(A[i]);
		}
//		��ͬһͰ�е���������
		 for(ArrayList<Integer> list:B)  
             Collections.sort(list);  
         return B;
	}
	public static void main(String[] args){
		ArrayList<Integer> M = new ArrayList<>();//M���ڴ洢���
		int[] A = {21,71,41,61,11,91,99,32,54,12,32,65,34,67,76};
		ArrayList<ArrayList<Integer>> C = bucketSort(A);
//		������Ͱ�е����ݷ���M
		for (int i = 0; i < C.size(); i++) {
			for(int j=0;j<C.get(i).size();j++){
				M.add(C.get(i).get(j));
			}
		}
//		�������ӡ����
		for(Integer list:M)  
            System.out.print(list+"��");
		
//		�ҳ����Ĳ�
		int result = 0;
		for(int k=1;k<M.size();k++){
			if(M.get(k)-M.get(k-1)>result){
				result = M.get(k)-M.get(k-1);
			}
		}
		System.out.println("����������������������ǣ� "+result);
	}
	
}
