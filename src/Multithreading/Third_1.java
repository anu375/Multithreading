package Multithreading;

public class Third_1 
{

	public static void main(String[] args)
	{
		
		Number num = new Number();
		Thread thread = new Thread(num);
		thread.start();
	}

}

class Number implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println(i);
		}
	}
}