package Multithreading;

public class Second
{

	public static void main(String[] args) throws InterruptedException
	{
		boolean status=true;
		
		
		Hello hello = new Hello();
		Hello hello1 = new Hello();
		Hello hello2 = new Hello();
		Hello hello3 = new Hello();
		
	 	hello.start();
	 	hello.join();
		hello1.start();
		hello2.start();
		hello3.start();
		
		while(status)
		{
			Thread.sleep(1000);
			System.out.println("*");
		}
		
		
	}

}

class Hello extends Thread
{
	public void run()
	{
		for(char i='A';i<='Z';i++)
		{
			System.out.println(i);
			
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}