package lab3;
/*
 * 计算 排序后连续两个数的最大差
 */
import java.util.ArrayList;
import java.util.Collections;

public class MaximumDifference {
	public static ArrayList<ArrayList<Integer>> bucketSort(int[] A){
//		声明一个ArrayList类型的二维数组
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
//		初始化B
		for(int i=0;i<10;i++){//这里用10是因为传入的数据都是一百以内的两位数，而且第19行除以10可以使桶的数量比较合理
			B.add(new ArrayList<Integer>());
		}
//		将A中的元素放入对应的桶中，同一桶中的元素累加
		for(int i=0;i<A.length;i++){
			B.get(A[i]/10).add(A[i]);
		}
//		将同一桶中的数据排序
		 for(ArrayList<Integer> list:B)  
             Collections.sort(list);  
         return B;
	}
	public static void main(String[] args){
		ArrayList<Integer> M = new ArrayList<>();//M用于存储结果
		int[] A = {21,71,41,61,11,91,99,32,54,12,32,65,34,67,76};
		ArrayList<ArrayList<Integer>> C = bucketSort(A);
//		将各个桶中的数据放入M
		for (int i = 0; i < C.size(); i++) {
			for(int j=0;j<C.get(i).size();j++){
				M.add(C.get(i).get(j));
			}
		}
//		将结果打印出来
		for(Integer list:M)  
            System.out.print(list+"　");
		
//		找出最大的差
		int result = 0;
		for(int k=1;k<M.size();k++){
			if(M.get(k)-M.get(k-1)>result){
				result = M.get(k)-M.get(k-1);
			}
		}
		System.out.println("排序后连续两个数的最大差是： "+result);
	}
	
}
