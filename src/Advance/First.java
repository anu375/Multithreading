package Advance;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class First 
{

	public static void main(String[] args) throws Exception
	{
	
		ExecutorService ser = Executors.newCachedThreadPool();
		
		for(int i=1; i<=100; i++)
		{
			Thread_demo demo = new Thread_demo(i);
			
			ser.execute(demo);
		}
		
		ser.shutdown();
		
	}

}


class Thread_demo extends Thread
{
	
	int id;
	
	public Thread_demo(int id)
	{
		this.id = id;
	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+"executing the "+this.id);
		
		for(int i=0; i<10; i++)
		{
			System.out.println(i);
		}
	}
}