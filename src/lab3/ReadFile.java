package lab3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReadFile {

//	count
	static int count=0;
	static String[] T = new String[58];
 public static void main(String[] args) {
	 FileInputStream file = null;
	 InputStreamReader isr = null;
	 BufferedReader br = null; //
	 try {
		 String str = "";
		 file = new FileInputStream("E:/xiaoming/Algorithms/src/lab3/names.txt");// 从指定的文件路径下读取文件
   // 从文件系统中的某个文件中获取字节
		 
		 isr = new InputStreamReader(file,"utf-8");// InputStreamReader 是字节流通向字符流的桥梁,
		 br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
		 while ((str = br.readLine()) != null) {
			 insert(str, 58);
			 System.out.println(str);// 打印出str
		 }
		 
	 } catch (FileNotFoundException e) {
		 System.out.println("找不到指定文件");
	 } catch (IOException e) {
		 System.out.println("读取文件失败");
	 } finally {
		 try {
			 br.close();
			 isr.close();
			 file.close();
    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
//	 从数组中删除一个数据
	 delete("黄黎明", 58);
//	 将数组T中的元素打印出来
	 for (int i = 0; i < T.length; i++) {
		System.out.println("the line "+i+" is : "+T[i]);
	}
	 if(search("黄黎明", 58)!=-1){
		 System.out.println("when the name is 黄黎明，the index is : "+search("黄黎明", 58)+"\nAnd the count is:"+count);
	 }else {
		 System.out.println("当搜索内容是‘黄黎明’时，不存在！");
	}
 }
 
// hash function
 public static int h(String nameInput,int i){
//	 名字有多于两个字
	 if(nameInput.length()>2){
		 return (nameInput.charAt(0)*100+nameInput.charAt(1)*10+nameInput.charAt(2)+i)%58;
	 }else//名字只有两个字
	 return (nameInput.charAt(0)*100+nameInput.charAt(1)*10+i)%58;
 }
 
// 插入数据
 public static void insert(String name,int range){
	 int i =0;
	 do {
		int j = h(name, i);
		count++;
		if(T[j]==null||T[j].equals("DELETED")){
			T[j]=name;
			break;
		}else{
			i=i+1;
		}
	} while (i<range);
	 if(i>=range)
		 System.out.println("溢出！");
 }
 
// 删除数据
 public static void delete(String name,int range){
	 int j = search(name, range);
	 if(j!=-1){
		 T[j]="DELETED";
		 System.out.println("当删除内容是"+name+"时，删除成功！");
	 }else {
		System.out.println("当删除内容是"+name+"时，没有此值，无法执行删除操作！");
	}
 }
 
// 搜索数据
 public static int search(String name,int range){
	 int i=0;
	 int j=0;
	 do{
		 j = h(name, i);
		 if(T[j].equals(name)){
//			 存在是返回指定的下标
			 return j;
		 }
		 i++;
	 }while(T[j]!=null&&i<range);
//	 不存在时返回-1
	 return -1;
 }
}