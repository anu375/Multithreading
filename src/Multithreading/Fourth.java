package Multithreading;

public class Fourth 
{

	public static void main(String[] args)
	{
		
		Fourth_1 fourth = new Fourth_1();
		
		fourth.start();
		
		Prime prime = new Prime();
		prime.start();
	}

}

class Fourth_1 extends Thread
{
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			if(i%2==0)
			{
				System.out.println(i);
			}
		}
	}
}

class Prime extends Thread
{
	public void run()
	{
		for(int i=2;i<20;i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			
			boolean flag = false;
			
			for(int j=2;j<i;j++)
			{
				if(i%j == 0)
				{
					flag = true;
				}
			}
			
			if(!flag)
			{
				System.out.println("Prime : "+i);
			}
		}
	}
}