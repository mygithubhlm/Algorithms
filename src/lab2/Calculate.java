package lab2;

//进行运算
public class Calculate {

	public static double toCalculate(String operator,String a,String b){
		//x,y是传进来的需要运算的数
		double x = Double.parseDouble(a);
		double y = Double.parseDouble(b);
		//z 为运算结果
		double z = 0;
		//对数据进行运算
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
				System.out.println("分母不能为0！");
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
