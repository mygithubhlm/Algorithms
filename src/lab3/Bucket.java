package lab3;

public class Bucket {

	int max;
	int min;
	
	boolean isEmpty;
	
	Bucket(){
		isEmpty = true;
	}
	
	//O(1)
	void insert(int a){
		
		if(this.isEmpty){
			this.isEmpty = false;
			this.max = a;
			this.min = a;
		}
			
		else{		
			if(a > max)
				this.max = a;
		
			if(a < min)
				this.min = a;
	
			}
		}
	
	static int maximumGap(int[] unsorted){
		
		if(unsorted == null || unsorted.length < 2)
			return 0;
		
		int min_value = unsorted[0];
		int max_value = unsorted[0];
		
		//O(n);
		for(int i = 1; i < unsorted.length; i++){
			if(unsorted[i] < min_value)
				min_value = unsorted[i];
			if(unsorted[i] > max_value)
				max_value = unsorted[i];
		}
		
		//The range of a bucket
		double rangeDouble = Math.ceil((double)(max_value - min_value) / (unsorted.length - 1));
		
		int range = -1;
		
		try{
			range = (int)rangeDouble;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
		Bucket[] bkts = new Bucket[unsorted.length];
		
		//O(n)
		for(int i = 0; i < unsorted.length; i++){
			
			int index = (unsorted[i] - min_value) / range;
			
			if(bkts[index] == null)
				bkts[index] = new Bucket();
			
			bkts[index].insert(unsorted[i]);
		}
	
		int gap = 0;
		int pre = 0;
		
		//O(n)
		for(int i = 0; i < bkts.length; i++){
			if(bkts[i] == null || bkts[i].isEmpty)
				continue;
			gap = Math.max(gap, bkts[i].min - bkts[pre].max);
			pre = i;
			
		}
		
		return gap;
	}

	public static void main(String args[]){
		int[] A = {3, 1, 11, 7, 17, 15, 3};
		System.out.println(maximumGap(A));
	}
	
}