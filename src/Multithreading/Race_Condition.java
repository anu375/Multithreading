package Multithreading;

public class Race_Condition
{

	public static void main(String[] args) throws InterruptedException
	{
		
		Source source = new Source();
		
		Thread_2 th_2 = new Thread_2(source); 
		Thread_2_A th_2_A = new Thread_2_A(source);
		
		th_2.start();
		th_2_A.start();
		
		th_2.join();
		th_2_A.join();
		
		System.out.println(source.getcounter());
	}

}

class Source
{
	int counter = 0;
	
	public int getcounter()
	{
		return this.counter;
	}
}

class Thread_2 extends Thread
{
	Source source;
	static int counter = 0;
	
	public Thread_2(Source source)
	{
		this.source = source;
	}
	
	public void run()
	{
		for(int i=1; i <= 10000; i++)
		{
			source.counter++;
			counter++;
		}
		System.out.println("Thread One : "+counter);
	}
}

class Thread_2_A extends Thread
{
	Source source;
	static int counter = 0;
	
	public Thread_2_A(Source source)
	{
		this.source = source;
	}
	
	public void run()
	{
		for(int i=1; i <= 10000; i++)
		{
			source.counter++;
			counter++;
		}
		
		System.out.println("Thread Two : "+counter);
	}
}