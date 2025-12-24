package Multithreading;

public class Third 
{

	public static void main(String[] args) throws InterruptedException
	{
		One one = new One();
		
		one.run();
		one.start();
		
		for(int i =0;i<=10;i++)
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

class One extends Thread
{
	public void run()
	{
		for(char i='a';i<='z';i++)
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
}