import java.util.*;

public class Main {
	
	public static void main(String[] args){
//		��ʼ���ݹ�ģ;
		int theNum = 50;//input.nextInt();
		long shijiancha = 1;
		
//      for(theNum=100;shijiancha<=0;theNum++){
	while(theNum<1500){
		int[] list = Numbers.num(theNum);
		//����ѡ������Ľ��
	    	
	    //	��ȡ��ǰʱ��
		long time1 =  System.nanoTime()/1000L;
		SelectionSort.selectionSort(list);
		//�ٴλ�ȡ��ǰʱ��
		long time2 = System.nanoTime()/1000L;
		
//		�������������ӡ������
//		for (int i = 0; i < list.length; i++) {
//			System.out.print(list[i]+"  ");
//			if((i+1)%10==0||i==list.length-1)
//				System.out.println();
//		}
		
		System.out.println("The key is"+theNum+"\n��������������ʱ��Ϊ��"+(time2-time1)+"΢��");
		
//		//����鲢����Ľ��
		int[] list2 = Numbers.num(theNum);
		
		 //	��ȡ��ǰʱ��
		long time3 = System.nanoTime()/1000L;
		MergeSort.diaoYong(list2);
		 //	�ٴλ�ȡ��ǰʱ��
		long time4 = System.nanoTime()/1000L;
		
//		�������������ӡ������
//		for (int i = 0; i < list2.length; i++) {
//			System.out.print(list2[i]+"  ");
//			if((i+1)%10==0||i==list2.length-1)
//				System.out.println();
//		}
		
		System.out.println("�鲢����������ʱ��Ϊ��"+(time4-time3)+"΢��\n\n");
		
		shijiancha = (time4-time3)-(time2-time1);
		theNum++;
	}
	System.out.println("The key is "+theNum);
	}
}
