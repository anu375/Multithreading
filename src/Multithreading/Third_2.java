package Multithreading;

public class Third_2 
{

	public static void main(String[] args) throws InterruptedException
	{
		Runnable r = ()->{
			for(int i=0;i<=15;i++)
			{
				System.out.println("*******");
				try
				{
					Thread.sleep(300);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(r);
		
		t.start();
		t.join();
		
		for(int i=0;i<10;i++)
		{
			System.out.println("*");
			Thread.sleep(1000);
		}

//		Number_1 no = new Number_1();
//		Thread t = new Thread(no);
//		t.start();
	}

}

class Number_1 implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(i%2==0)
			{
				System.out.println(i);
			}
		}
	}
}