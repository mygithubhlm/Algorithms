package lab5;

import java.util.ArrayList;

public class CoinsChange {
	public static void main(String[] args){
		CoinsChange a = new CoinsChange();
		ArrayList<Integer> b = new ArrayList<Integer>();
/*
 * �˴��������������ֵ��Ӳ�ҵ�����
 */
		b.add(4);
		b.add(3);
		b.add(6);
		b.add(10);
/*
 * �ֱ��ӡ�����ú���ǰ������ҵ�����
 */
		System.out.println("����ǰ��Ӳ��ö���ֱ��ǣ�"+b.toString());
		b = a.change(99, b);
		System.out.println("ʣ���Ӳ��ö���ֱ��ǣ�"+b.toString());
	}
	
	public ArrayList<Integer> change(int total, ArrayList<Integer> coins) {
		// TODO Auto-generated method stub
//		����coins���ĸ�λ�÷ֱ�洢25���֣�10���֣�5���ֺ�1���ֵ�Ӳ������
		int num25,num10,num5,num1;
		int sumMon = total;
		num25 = Math.min(total/25, coins.get(0));
		coins.set(0, coins.get(0)-num25);
		total = total - 25*num25;
//		10���ֵ�����
		num10 = Math.min(total/10, coins.get(1));
		total = total - num10*10;
		coins.set(1, coins.get(1)-num10);
//		5���ֵ�����
		num5 = Math.min(total/5, coins.get(2));
		total = total - num5*5;
		coins.set(2, coins.get(2)-num5);
//		1���ֵ�����
		num1 = total;
		coins.set(3, coins.get(3)-num1);
		if(num1>coins.get(3)){
			System.out.println("��Ǯ�������ˣ�");
		}
		System.out.println("Ҫ�����Ǯ���ǣ�"+sumMon+";\n��Ҫ25���֣�"+num25+"��, 10����:"+num10+"��, 5����:"+num5+"��, 1����:"+num1+"��"
				+ "\n�����ܵ�Ӳ����Ϊ"+(num25+num10+num5+num1));
		return coins;
	} 
}
