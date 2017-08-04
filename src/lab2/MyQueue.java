package lab2;

import java.util.LinkedList;


public class MyQueue<T> {
		//声明myQueue；
		private LinkedList myQueue;
		
		public MyQueue(){
			//实例化一个linkedList类型的实例变量
			myQueue = new LinkedList<T>();
		}
		
		public T front(){
			//此方法返回（但不删除）列表的第一个元素，如果没有元素就返回null；
			return (T) myQueue.peekLast();
//			if(!isEmpty()){
//				return (T)myQueue.getFirst();
//			}else
//			return null;
		}
		
		public T deQueue(){
			return (T)myQueue.pollLast();
		}
		
		public void enQueue(T str){
			myQueue.addFirst(str);
			
		}
		public int size(){
			return myQueue.size();
		}
		public boolean isEmpty(){
			if(myQueue.size()==0)
				return true;
			else {
				return false;
			}
		}
		
		public static void main(String[] args){
			String[] arr = "I am super star".split(" ");
			MyQueue<String> myQueue0 = new MyQueue<String>(); 
			for(int i = 0;i<arr.length;i++){
				myQueue0.enQueue(arr[i]);
			}
			while(!myQueue0.isEmpty())
				System.out.println("pop is "+myQueue0.deQueue()+"; size is "+myQueue0.size()+"; front is "+myQueue0.front());
		}
}
