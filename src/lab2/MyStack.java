package lab2;

import java.util.LinkedList;

//<T>称为泛型，即暂时不知道其类型是什么
public class MyStack<T> {
	
	//声明myStack；
	private LinkedList myStack;
	
	public MyStack(){
		//实例化一个linkedList类型的实例变量
		myStack = new LinkedList<T>();
	}
	
	public T top(){
		//此方法返回（但不删除）列表的第一个元素，如果没有元素就返回null；
		return (T) myStack.peekFirst();
//		if(!isEmpty()){
//			return (T)myStack.getFirst();
//		}else
//		return null;
	}
	
	public T pop(){
		return (T)myStack.pollFirst();
	}
	
	public void push(T str){
		myStack.addFirst(str);
		
	}
	public int size(){
		return myStack.size();
	}
	public boolean isEmpty(){
		if(myStack.size()==0)
			return true;
		else {
			return false;
		}
	}
	
	public static void main(String[] args){
		String[] arr = "I am super star".split(" ");
		MyStack<String> myStack0 = new MyStack<String>(); 
		for(int i = 0;i<arr.length;i++){
			myStack0.push(arr[i]);
		}
		while(!myStack0.isEmpty())
			System.out.println("pop is "+myStack0.pop()+"; size is "+myStack0.size()+"; top is "+myStack0.top());
	}
}
