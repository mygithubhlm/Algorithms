package lab5;

import java.util.ArrayList;

public class CoinsChange {
	public static void main(String[] args){
		CoinsChange a = new CoinsChange();
		ArrayList<Integer> b = new ArrayList<Integer>();
/*
 * 此处插入的是四中面值的硬币的数量
 */
		b.add(4);
		b.add(3);
		b.add(6);
		b.add(10);
/*
 * 分别打印出调用函数前后的银币的数量
 */
		System.out.println("找零前的硬币枚数分别是："+b.toString());
		b = a.change(99, b);
		System.out.println("剩余的硬币枚数分别是："+b.toString());
	}
	
	public ArrayList<Integer> change(int total, ArrayList<Integer> coins) {
		// TODO Auto-generated method stub
//		链表coins的四个位置分别存储25美分，10美分，5美分和1美分的硬币数量
		int num25,num10,num5,num1;
		int sumMon = total;
		num25 = Math.min(total/25, coins.get(0));
		coins.set(0, coins.get(0)-num25);
		total = total - 25*num25;
//		10美分的数量
		num10 = Math.min(total/10, coins.get(1));
		total = total - num10*10;
		coins.set(1, coins.get(1)-num10);
//		5美分的数量
		num5 = Math.min(total/5, coins.get(2));
		total = total - num5*5;
		coins.set(2, coins.get(2)-num5);
//		1美分的数量
		num1 = total;
		coins.set(3, coins.get(3)-num1);
		if(num1>coins.get(3)){
			System.out.println("零钱不够用了！");
		}
		System.out.println("要找零的钱数是："+sumMon+";\n需要25美分："+num25+"个, 10美分:"+num10+"个, 5美分:"+num5+"个, 1美分:"+num1+"个"
				+ "\n并且总的硬币数为"+(num25+num10+num5+num1));
		return coins;
	} 
}
