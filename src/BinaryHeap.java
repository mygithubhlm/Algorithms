/** 
 * @category ����ѵ�ʵ�� 
 * @author Bird 
 * 
 */  
public class BinaryHeap {  
      
    private static final int DEAFAULT_CAPACITY = 100;  
    private int currentSize;//���е�Ԫ�ظ���  
    private int[] array;//�洢���е�Ԫ��ʹ������洢��ʽ  
      
    public BinaryHeap(){  
        this(DEAFAULT_CAPACITY); 
        array = new int[DEAFAULT_CAPACITY];
    }  
      
    public BinaryHeap(int capacity){  
        currentSize = 0;  
        array = new int[capacity+1];  
          
    }  
      
    public boolean isEmpty(){  
        return currentSize == 0;  
    }  
      
    public boolean isFull(){  
        return currentSize == array.length-1;  
    }  
      
    public void makeEmpty(){  
        currentSize = 0;  
    }  
      
    /** 
     * ����ʹ�á����ơ��� 
     * @param x 
     */  
    public void insert(int x){  
        if(isFull())  
            throw new RuntimeException("���");  
          
        int hole = ++currentSize;  
        for(; hole >1 && (x-array[hole/2]) < 0; hole /= 2)  
            array[hole] = array[hole/2];  
        array[hole] = x;   
    }  
      
    /** 
     * ʹ�����編����ɾ������ 
     * @return 
     */  
    public int deleteMin(){  
        if(isEmpty())  
            return -100;  
          
        int minItem = array[1];  
        array[1] = array[currentSize--];  
        percolateDown(1);  
          
        return minItem;  
    }  
      
    private void percolateDown(int hole){  
        int child = 0;  
        int tmp = array[hole];  
          
        for(; hole * 2 <= currentSize; hole = child){  
            child = hole * 2;  
            if(child != currentSize && array[child+1]-array[child]<0)  
                child++;  
            if(array[child]-tmp<0)  
                array[hole] = array[child];  
            else   
                break;  
        }  
        array[hole] = tmp;  
    }  
    
    public int getMin(){
    	return array[0];
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5};
    	BinaryHeap heap = new BinaryHeap();
    	for (int i = 0; i < a.length; i++) {
    		heap.insert(a[i]);
		}
    	System.out.println(heap.getMin());
    }
}  
  
       