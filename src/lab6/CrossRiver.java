package lab6;

import java.util.LinkedList;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.INTERNAL;

/*
 * 八个位置分别表示警察、罪犯、爸爸、妈妈、儿子1、儿子2、女儿1、女儿2
 * 状态0表示在河的这边，状态1表示在河的那边。
 * 
 */

public class CrossRiver {
	public static boolean isSafe(int num){
		
//		罪犯在没有警察的陪同下不能喝家人在一块.即警察：0，罪犯：1，家人：存在1
		int temp0 = num<<2;
		int temp = temp0&0xff;
		if((temp>0)&&((num&0x40)>0)&&((num&0x80)==0)){
			return false;
		}
		
//		妈妈在没有爸爸的陪同下和儿子在一块。即爸爸：0，妈妈：1，儿子：1.
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
//		爸爸在没有妈妈的陪同下和女儿在一起。即爸爸：1，妈妈：0，女儿：1
		if((num&0x20)>0&&(num&0x10)==0&&((num&0x02)>0||(num&0x01)>0)){
			return false;
		}
		
		if(num>255)
			return false;
//		其他状态是安全的
		return true;
	}
	
//	得到所有可行的状态
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
//							过河时爸爸或妈妈和罪犯一起过河的情况
							if((b.get(j)==64&&(a.get(i)==32||a.get(i)==16))){
								continue;
							}
//							过河时爸爸和女儿一起过河的情况
							if(a.get(i)==32&&(b.get(j)==2||b.get(j)==1)){
								continue;
							}
//							过河时妈妈和儿子一起过河的情况
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
