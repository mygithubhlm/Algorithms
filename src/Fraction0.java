
import java.util.ArrayList;
import java.util.List;
public class Fraction0 {
	private int  molecular;//����
	private int assignment;//��ĸ
	//get  set����
	public int getMolecular() {
		return molecular;
	}
	public void setMolecular(int molecular) {
		this.molecular = molecular;
	}
	public int getAssignment() {
		return assignment;
	}
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	//���캯��
	public Fraction0(int fenzi,int fenmu){
		//������ķ�ĸΪ0   �������������һ��  �������Ϊ0  ��ô���׳�һ���쳣
		int test=1/fenmu;
		molecular=fenzi;
		assignment=fenmu;
	}
	//�����������
	public String add(Fraction0 b){
		this.molecular=this.molecular*b.assignment+b.molecular*this.assignment;
		this.assignment=this.assignment*b.assignment;
		return this.toString();
	}
	//��������
	public Fraction0 anonym(){
		int small;//��¼�൱С����
		int big;//��¼��Դ����
		if(molecular>assignment){
			small=assignment;
			big=molecular;
		}else{
			small=molecular;
			big=assignment;
		}
		//�õ����С����������Լ��
		List<Integer> list=new ArrayList<Integer>();
		for(int i=2;i<=small/2;i++){
			if(small%i==0){
				list.add(i);
			}
		}
		//�ж��Ƿ��ǹ�Լ��  ��������
		if(list.size()>0){
			for(int i=list.size()-1;i>=0;i--){
				if(big%list.get(i)==0&&small%list.get(i)==0){
					big=big/list.get(i);
					small=small/list.get(i);
					molecular=molecular/list.get(i);
					assignment=assignment/list.get(i);
				}
			}
		}
		return this;
	}
	//��дtoString����
	@Override
	public String toString() {
		this.anonym();
		if(this.molecular%this.assignment==0){
			return ""+this.molecular/this.assignment;
		}else{
			return ""+this.molecular+"/"+this.assignment;
		}
	}
	//������  ���ڲ���
	public static void main(String[] args) {
		Fraction0 f1=new Fraction0(6,14);
		Fraction0 f2=new Fraction0(7,15);
		System.out.println(f1.add(f2));
	}
}