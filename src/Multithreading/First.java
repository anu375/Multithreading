package Multithreading;

public class First 
{

	public static void main(String[] args) throws InterruptedException 
	{
		MyThread mythread = new MyThread();
		mythread.start();
		mythread.join();
		System.out.println("Main Thread");
	}

}

class MyThread extends Thread
{
	public void run()
	{
		for(int i=0; i<=3; i++)
		{
			System.out.println("Child Thread");
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}