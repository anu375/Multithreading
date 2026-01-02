package Multithreading;

public class Demo
{

	public static void main(String[] args)
	{

		int i = 100;
		int j = 200;
		
		i = i+j;
		j = i-j;
		i = i-j;
		
		System.out.println("i : "+i);
		System.out.println("j : "+j);

	}

}