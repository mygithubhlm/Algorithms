package lab4;

public class getUgly {
	
	public static void main(String[] args){
		System.out.println(ugly(100));
	}
	
//	Ѱ�ҵ�n������
	public static int ugly(int n) {
	    int[] uglys = new int[n];
	    uglys[0] = 1;
	    int index2 = 0;
	    int	index3 = 0;
	    int	index5 = 0;
	    int uglysOf2 = 2, uglysOf3 = 3, uglysOf5 = 5;
//	    �ҳ�����������С��������uglys�������Ӧλ�ô�
	    for (int i = 1; i < n; i++) {
	        int min = Math.min(Math.min(uglysOf2, uglysOf3), uglysOf5);
	        uglys[i] = min;
	        if (uglysOf2 == min)
	        	uglysOf2 = 2 * uglys[++index2];
	        if (uglysOf3 == min)
	        	uglysOf3 = 3 * uglys[++index3];
	        if (uglysOf5 == min)
	        	uglysOf5 = 5 * uglys[++index5];
	    }
	    return uglys[n - 1];
	}
}
