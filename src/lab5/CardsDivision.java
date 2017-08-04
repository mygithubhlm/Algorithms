package lab5;

import java.util.ArrayList;

public class CardsDivision {
	public static void main(String[] args){
		int[] a = {30,2,3,14,1};
		CardsDivision card = new CardsDivision();
		card.movingCards(a);
	}
	public ArrayList movingCards(int[] array) {
		// TODO Auto-generated method stub
		ArrayList<Integer> res = new ArrayList<Integer>();
		int option = 0;
//		打印初始数组
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j]+",");
		}
		System.out.println();
		
		int n = array.length;
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		avg = sum/n;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==avg)
				continue;
			if(array[i]<avg){
				int k = i+1;
				int have = 0;
				int need = avg-array[i];
//				找到纸牌数量足够移动的那个堆
				while(array[k]+have<avg+need){
					if(array[k]<avg){
						need+=avg-array[k];
					}else if(array[k]>avg){
						have += array[k]-avg;
					}else {
					}
					k++;
				}
//				将纸牌移动
				array[k]=array[k]-(need-have);
				array[k-1]=array[k-1]+(need-have);
				k--;
				for (int j = 0; j < array.length; j++) {
					System.out.print(array[j]+",");
				}
				option++;
				System.out.println();
				while(k>i){
					array[k-1]=array[k-1]+array[k]-avg;
					array[k]=avg;
					for (int j = 0; j < array.length; j++) {
						System.out.print(array[j]+",");
					}
					option++;
					System.out.println();
					k--;
				}
			}
			if(array[i]>avg){
				array[i+1]=array[i+1]+array[i]-avg;
				array[i]=avg;
				for (int j = 0; j < array.length; j++) {
					System.out.print(array[j]+",");
				}
				option++;
				System.out.println();
			}
		}
		for (int i = 0; i < array.length; i++) {
			res.add(array[i]);
		}
		System.out.println("总的操作步数是："+option);
		return res;
	}
}
