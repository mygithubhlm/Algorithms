package lab2;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GU
 *计算24点  难点是递归算法归纳(双重for循环加递归啊  容易蒙) 以及加括号(完美解决)问题
 *不限于4个数  但6个数时  运行已经相当吃力
 *程序逻辑竭力去除重复解(加法乘法交换律 不算重复)  但无法完全  最后只能以Set 解决问题
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
			if (k != from && num[k].str.equals(num[from].str))//尽量去除重复解，但还是有重复比如
				// 比如：
				// （12+12+12）+12与12+（12+12+12）去括号后一样，无法去除 只能借助Set了
				continue;
			swap(k, from, num);

			for (int i = from + 1; i < num.length; i++)
			{
				if (i != from + 1 && num[i].str.equals(num[from + 1].str))// 还是尽量去除重复解
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
					num[from + 1] = new Num(num[from].value / temp.value, addKH(num[from].type, 3, true, num[from].str) + "÷" + addKH(temp.type, 3, false, temp.str), 3);
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

	public static String addKH(int m, int c, boolean mb, String str)// 判断是否要加括号m复合表达式的符号（1+2） c 当前符号 mb多表达式是否在前面 str 多表达式的字符串
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
		public double value; //实际值
		public String str;//表达式
		public int type;//表达式类型 0,1,2,3加减乘除 -1不是复合表达式

		public Num(double value, String str, int type)
		{
			this.str = str;
			this.value = value;
			this.type = type;
		}

	}
}
