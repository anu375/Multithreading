package Multithreading;

public class Fifth 
{

	public static void main(String[] args) 
	{
		
//		Hii hi = new Hii();
//		hi.start();
//		
//		Buy buy = new Buy();
//		buy.start();
		
		Thread thread = new Thread() {
			public void run()
			{
				for(int i=0;i<10;i++)
				{
				
					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException ie)
					{
						ie.printStackTrace();
					}
					System.out.println(i);
				}
			}
		};
		thread.start();
	}

}

class Hii extends Thread
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
			if(i%2 == 0)
			{
				System.out.println(i);
			}
		}
	}
}

class Buy extends Thread
{
	public void run()
	{
		for(int i=2;i<20;i++)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			boolean flag = false;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
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