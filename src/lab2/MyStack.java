package lab2;

import java.util.LinkedList;

//<T>��Ϊ���ͣ�����ʱ��֪����������ʲô
public class MyStack<T> {
	
	//����myStack��
	private LinkedList myStack;
	
	public MyStack(){
		//ʵ����һ��linkedList���͵�ʵ������
		myStack = new LinkedList<T>();
	}
	
	public T top(){
		//�˷������أ�����ɾ�����б�ĵ�һ��Ԫ�أ����û��Ԫ�ؾͷ���null��
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
