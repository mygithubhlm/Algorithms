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
		 file = new FileInputStream("E:/xiaoming/Algorithms/src/lab3/names.txt");// ��ָ�����ļ�·���¶�ȡ�ļ�
   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
		 
		 isr = new InputStreamReader(file,"utf-8");// InputStreamReader ���ֽ���ͨ���ַ���������,
		 br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
		 while ((str = br.readLine()) != null) {
			 insert(str, 58);
			 System.out.println(str);// ��ӡ��str
		 }
		 
	 } catch (FileNotFoundException e) {
		 System.out.println("�Ҳ���ָ���ļ�");
	 } catch (IOException e) {
		 System.out.println("��ȡ�ļ�ʧ��");
	 } finally {
		 try {
			 br.close();
			 isr.close();
			 file.close();
    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
//	 ��������ɾ��һ������
	 delete("������", 58);
//	 ������T�е�Ԫ�ش�ӡ����
	 for (int i = 0; i < T.length; i++) {
		System.out.println("the line "+i+" is : "+T[i]);
	}
	 if(search("������", 58)!=-1){
		 System.out.println("when the name is ��������the index is : "+search("������", 58)+"\nAnd the count is:"+count);
	 }else {
		 System.out.println("�����������ǡ���������ʱ�������ڣ�");
	}
 }
 
// hash function
 public static int h(String nameInput,int i){
//	 �����ж���������
	 if(nameInput.length()>2){
		 return (nameInput.charAt(0)*100+nameInput.charAt(1)*10+nameInput.charAt(2)+i)%58;
	 }else//����ֻ��������
	 return (nameInput.charAt(0)*100+nameInput.charAt(1)*10+i)%58;
 }
 
// ��������
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
		 System.out.println("�����");
 }
 
// ɾ������
 public static void delete(String name,int range){
	 int j = search(name, range);
	 if(j!=-1){
		 T[j]="DELETED";
		 System.out.println("��ɾ��������"+name+"ʱ��ɾ���ɹ���");
	 }else {
		System.out.println("��ɾ��������"+name+"ʱ��û�д�ֵ���޷�ִ��ɾ��������");
	}
 }
 
// ��������
 public static int search(String name,int range){
	 int i=0;
	 int j=0;
	 do{
		 j = h(name, i);
		 if(T[j].equals(name)){
//			 �����Ƿ���ָ�����±�
			 return j;
		 }
		 i++;
	 }while(T[j]!=null&&i<range);
//	 ������ʱ����-1
	 return -1;
 }
}