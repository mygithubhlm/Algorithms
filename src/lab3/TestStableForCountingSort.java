package lab3;
/*
 * �������ڲ�����д��countingSort�Ƿ�Ϊstable
 * 
 */
public class TestStableForCountingSort {
	public static void main(String[] args){
		int[] A = {2,5,3,0,2,3,0,3};
/*
 * 		aString������A��Ӧ������A�����е�����2��aString�зֱ��á��ҡ��͡��ǡ�����
 * 	aString�е������±��A�����е��±���ͬ���ı䶯����ô������ͨ����ӡ����aString
 * 	�С��ҡ��͡��ǡ������λ���Ƿ�仯�Ϳ���֪��A�����Ƿ�Ϊstable.
 */
		
//		���ڼ�������
		String[] aString = {"��","5","3","0","��","3","0","3"};
		int[] B = new int[A.length];
		String[] bString = new String[aString.length];
		int k = 0;
		for(int i=0;i<A.length;i++){
			if(k<A[i]){
				k = A[i];
			}
		}
		k++;
		int[] re = countingSort(A, B, aString,bString,k);
		for(int i=0;i<re.length;i++){
			System.out.println(re[i]);
		}
	}
	public static int[] countingSort(int[] A,int[] B,String[] AString,String[] BString,int k){
		int[] C = new int[k];
//		��C��ʼ��
		for(int i=0;i<k;i++){
			C[i] = 0;
		}
//		����ÿ��Ԫ�صĸ���
		for(int j=0;j<A.length;j++){
			C[A[j]] = C[A[j]]+1; 
		}
//		����C[i]��λ��
		for(int i=1;i<k;i++){
			C[i] = C[i] + C[i-1];
		}
//		�����ظ��������ֵ����
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]-1] = A[j];
			BString[C[A[j]]-1] = AString[j];
			C[A[j]] = C[A[j]]-1;
		}
//		��ӡ�������������ݣ����Ƿ�Ϊstable�������ҡ��͡��ǡ������λ�ã�
		for (int i = 0; i < BString.length; i++) {
			System.out.print(BString[i]+" , ");
		}
		System.out.println();
		return B;
	}
}
