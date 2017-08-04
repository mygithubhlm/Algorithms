

//产生指定个数的随机数
public class Numbers {
	//a为随机数的个数
	public static int[] num(int a) {
		int[] result = new int[a]; 
		for(int i=0;i<a;i++){
			result[i] = (int)(Math.random()*a*10+1);
		}
		SelectionSort.selectionSort(result);
		return result;
	}
	
	public static void main(String[] args){
		int[] aaa = num(20);
		for(int i=0;i<aaa.length;i++){
			System.out.println(aaa[i]);
		}
	}
}
