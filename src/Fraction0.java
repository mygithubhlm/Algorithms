
import java.util.ArrayList;
import java.util.List;
public class Fraction0 {
	private int  molecular;//分子
	private int assignment;//分母
	//get  set方法
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
	//构造函数
	public Fraction0(int fenzi,int fenmu){
		//怕输入的分母为0   所有在这里测试一下  如果输入为0  那么会抛出一个异常
		int test=1/fenmu;
		molecular=fenzi;
		assignment=fenmu;
	}
	//两个分数相加
	public String add(Fraction0 b){
		this.molecular=this.molecular*b.assignment+b.molecular*this.assignment;
		this.assignment=this.assignment*b.assignment;
		return this.toString();
	}
	//分数化简
	public Fraction0 anonym(){
		int small;//记录相当小的数
		int big;//记录相对大的数
		if(molecular>assignment){
			small=assignment;
			big=molecular;
		}else{
			small=molecular;
			big=assignment;
		}
		//得到相对小的数的所有约数
		List<Integer> list=new ArrayList<Integer>();
		for(int i=2;i<=small/2;i++){
			if(small%i==0){
				list.add(i);
			}
		}
		//判断是否是公约数  并做操作
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
	//重写toString方法
	@Override
	public String toString() {
		this.anonym();
		if(this.molecular%this.assignment==0){
			return ""+this.molecular/this.assignment;
		}else{
			return ""+this.molecular+"/"+this.assignment;
		}
	}
	//主方法  用于测试
	public static void main(String[] args) {
		Fraction0 f1=new Fraction0(6,14);
		Fraction0 f2=new Fraction0(7,15);
		System.out.println(f1.add(f2));
	}
}