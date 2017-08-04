package lab6;

import java.util.LinkedList;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.INTERNAL;

/*
 * �˸�λ�÷ֱ��ʾ���졢�ﷸ���ְ֡����衢����1������2��Ů��1��Ů��2
 * ״̬0��ʾ�ںӵ���ߣ�״̬1��ʾ�ںӵ��Ǳߡ�
 * 
 */

public class CrossRiver {
	public static boolean isSafe(int num){
		
//		�ﷸ��û�о������ͬ�²��ܺȼ�����һ��.�����죺0���ﷸ��1�����ˣ�����1
		int temp0 = num<<2;
		int temp = temp0&0xff;
		if((temp>0)&&((num&0x40)>0)&&((num&0x80)==0)){
			return false;
		}
		
//		������û�аְֵ���ͬ�ºͶ�����һ�顣���ְ֣�0�����裺1�����ӣ�1.
//		if (((num&0x20)==0)&&((num&0x10)==1)&&(((num&0x08)==1)||((num&0x04)==1))) {
//			return false;
//		}
		if((num&0x20)==0){
			if((num&0x10)>0){
				if((num&0x08)>0||(num&0x04)>0){
					return false;
				}
			}
		}
//		�ְ���û���������ͬ�º�Ů����һ�𡣼��ְ֣�1�����裺0��Ů����1
		if((num&0x20)>0&&(num&0x10)==0&&((num&0x02)>0||(num&0x01)>0)){
			return false;
		}
		
		if(num>255)
			return false;
//		����״̬�ǰ�ȫ��
		return true;
	}
	
//	�õ����п��е�״̬
	@SuppressWarnings("null")
	public static LinkedList<Integer> getQ(){
		LinkedList<Integer> result = new LinkedList<Integer>();
		for(int i=0; i<=0xff; i++){
			if(isSafe(i)){
				result.add(i);
			}
		}
		return result;
	}
	
	public static LinkedList<Integer> getPath(){
		int re = 0;
		LinkedList<Integer> path = new LinkedList<Integer>();
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(16);
		a.add(32);
		a.add(128);
		LinkedList<Integer> b = new LinkedList<Integer>();
		b.add(1);
		b.add(2);
		b.add(4);
		b.add(8);
		b.add(16);
		b.add(32);
		b.add(64);
		b.add(128);
		
//		addAll(1,2,4,8,16,32,64,128);
		int time=0;
		
		while(re!=255&&time<5000){
			
		for(int i=0;i<a.size();i++){
			for(int j=0;j<b.size();j++){
				if(a.get(i)!=b.get(j)){
					if(isSafe(re+a.get(i)+b.get(j))&&isSafe(re+b.get(j))){
						if((re&a.get(i))==0&&(re&b.get(j))==0){
//							����ʱ�ְֻ�������ﷸһ����ӵ����
							if((b.get(j)==64&&(a.get(i)==32||a.get(i)==16))){
								continue;
							}
//							����ʱ�ְֺ�Ů��һ����ӵ����
							if(a.get(i)==32&&(b.get(j)==2||b.get(j)==1)){
								continue;
							}
//							����ʱ����Ͷ���һ����ӵ����
							if(a.get(i)==16&&(b.get(j)==4||b.get(j)==8)){
								continue;
							}
							if(re+a.get(i)+b.get(j)!=255){
								path.add(re+a.get(i)+b.get(j));
								path.add(re+b.get(j));
								re += b.get(j);
							}else {
								re = 255;
								path.add(re+a.get(i)+b.get(j));
								break;
							}
						}
					}
				}
			}
		}
		time++; 
//		if(re!=255&&time>=8*11){
//			int temp = b.removeLast();
//			b.addFirst(temp);
//		}else if(re!=255&&time>=8*12) {
//			int temp1 = a.removeLast();
//			a.addFirst(temp1);
//		}else if(re!=255&&time>=12*12){
//			re = 0;
//			path.clear();
//			time=1;
//		}
		
		
		}
		return path;
	}
	
//	 
	public static void main(String[] args){
		LinkedList<Integer> aa = getPath();
		System.out.println("size is: "+aa.size());
		for(Integer a: aa){
			System.out.printf(Integer.toBinaryString(a)+"\n");
		}
	}
}
