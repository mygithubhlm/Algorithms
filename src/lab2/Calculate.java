package lab2;

//��������
public class Calculate {

	public static double toCalculate(String operator,String a,String b){
		//x,y�Ǵ���������Ҫ�������
		double x = Double.parseDouble(a);
		double y = Double.parseDouble(b);
		//z Ϊ������
		double z = 0;
		//�����ݽ�������
		switch (operator) {
		case "+":
			z = x+y;
			break;
		case "-":
			z = y-x;
			break;
		case "*":
			z = x*y;
			break;
		case "/":
			if(x==0){
				System.out.println("��ĸ����Ϊ0��");
				System.exit(0);
			}else
				z = y/x;
			break;
		case "^":
			z=1;
			for(int i=0;i<x;i++){
				z=z*y;
			}
			break;
		default:
			break;
		}
		return z;
	}
	
}
