import java.util.*;

public class Main {
	
	public static void main(String[] args){
//		初始数据规模;
		int theNum = 50;//input.nextInt();
		long shijiancha = 1;
		
//      for(theNum=100;shijiancha<=0;theNum++){
	while(theNum<1500){
		int[] list = Numbers.num(theNum);
		//检验选择排序的结果
	    	
	    //	获取当前时间
		long time1 =  System.nanoTime()/1000L;
		SelectionSort.selectionSort(list);
		//再次获取当前时间
		long time2 = System.nanoTime()/1000L;
		
//		将排序后的数组打印出来；
//		for (int i = 0; i < list.length; i++) {
//			System.out.print(list[i]+"  ");
//			if((i+1)%10==0||i==list.length-1)
//				System.out.println();
//		}
		
		System.out.println("The key is"+theNum+"\n插入排序所花的时间为："+(time2-time1)+"微秒");
		
//		//检验归并排序的结果
		int[] list2 = Numbers.num(theNum);
		
		 //	获取当前时间
		long time3 = System.nanoTime()/1000L;
		MergeSort.diaoYong(list2);
		 //	再次获取当前时间
		long time4 = System.nanoTime()/1000L;
		
//		将排序后的数组打印出来；
//		for (int i = 0; i < list2.length; i++) {
//			System.out.print(list2[i]+"  ");
//			if((i+1)%10==0||i==list2.length-1)
//				System.out.println();
//		}
		
		System.out.println("归并排序所花的时间为："+(time4-time3)+"微秒\n\n");
		
		shijiancha = (time4-time3)-(time2-time1);
		theNum++;
	}
	System.out.println("The key is "+theNum);
	}
}
