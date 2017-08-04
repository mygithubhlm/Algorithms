package lab2;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GU
 *����24��  �ѵ��ǵݹ��㷨����(˫��forѭ���ӵݹ鰡  ������) �Լ�������(�������)����
 *������4����  ��6����ʱ  �����Ѿ��൱����
 *�����߼�����ȥ���ظ���(�ӷ��˷������� �����ظ�)  ���޷���ȫ  ���ֻ����Set �������
 */
public class Test24
{

	static int[] arr = {1,2,3,4};

	static Set<String> result = new HashSet<String>();

	public static void main(String[] args)
	{

		Num[] num = new Num[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			num[i] = new Num(arr[i], arr[i] + "", -1);
		}

		start(num, 0);

		for (String s : result)
		{
			System.out.println(s);
		}
	}

	public static void start(Num[] num, int from)
	{

		if (from == num.length - 1)
		{
			if (Math.abs(num[from].value - 24) < 0.001)
			{
				result.add(num[from].str);
			}
		}

		for (int k = from; k < num.length; k++)
		{
			if (k != from && num[k].str.equals(num[from].str))//����ȥ���ظ��⣬���������ظ�����
				// ���磺
				// ��12+12+12��+12��12+��12+12+12��ȥ���ź�һ�����޷�ȥ�� ֻ�ܽ���Set��
				continue;
			swap(k, from, num);

			for (int i = from + 1; i < num.length; i++)
			{
				if (i != from + 1 && num[i].str.equals(num[from + 1].str))// ���Ǿ���ȥ���ظ���
					continue;
				swap(from + 1, i, num);
				Num temp = num[from + 1];

				num[from + 1] = new Num(num[from].value + temp.value, addKH(num[from].type, 0, true, num[from].str) + "+" + addKH(temp.type, 0, false, temp.str), 0);
				start(num, from + 1);

				num[from + 1] = new Num(num[from].value - temp.value, addKH(num[from].type, 1, true, num[from].str) + "-" + addKH(temp.type, 1, false, temp.str), 1);
				start(num, from + 1);

				num[from + 1] = new Num(num[from].value * temp.value, addKH(num[from].type, 2, true, num[from].str) + "*" + addKH(temp.type, 2, false, temp.str), 2);
				start(num, from + 1);

				if (temp.value != 0.0)
				{
					num[from + 1] = new Num(num[from].value / temp.value, addKH(num[from].type, 3, true, num[from].str) + "��" + addKH(temp.type, 3, false, temp.str), 3);
					start(num, from + 1);
				}

				num[from + 1] = temp;
				swap(from + 1, i, num);

			}
			swap(k, from, num);
		}
	}

	public static void swap(int i, int j, Num[] a)
	{
		Num temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static String addKH(int m, int c, boolean mb, String str)// �ж��Ƿ�Ҫ������m���ϱ��ʽ�ķ��ţ�1+2�� c ��ǰ���� mb����ʽ�Ƿ���ǰ�� str ����ʽ���ַ���
	{
		if (m == -1)
			return str;

		if (mb)
		{
			switch (m)
			{
				case 0:

				case 1:
					if (c == 2 || c == 3)
						return "(" + str + ")";

				case 2:

				case 3:
					return str;
			}
		} else
		{
			switch (m)
			{
				case 0:

				case 1:
					if (c == 0)
						return str;
					else
						return "(" + str + ")";

				case 2:

				case 3:
					if (c == 3)
						return "(" + str + ")";
					else
						return str;
			}
		}
		return null;
	}

	static class Num
	{
		public double value; //ʵ��ֵ
		public String str;//���ʽ
		public int type;//���ʽ���� 0,1,2,3�Ӽ��˳� -1���Ǹ��ϱ��ʽ

		public Num(double value, String str, int type)
		{
			this.str = str;
			this.value = value;
			this.type = type;
		}

	}
}
