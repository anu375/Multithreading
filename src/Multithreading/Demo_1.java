package Multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo_1
{

	public static void main(String[] args) 
	{

	      ExecutorService exec=Executors.newFixedThreadPool(3);
	      
	      for(int i=0;i<15;i++)
	      {
	    	  exec.execute(new Threaddemo(i));
	      }
	      
	     exec.shutdown();
	}
}

class Threaddemo extends Thread
{
		
	int id;
		
	public Threaddemo(int id)
	{
		this.id=id;
	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+"executing the thread..."+this.id);
		
		try 
		{
			Thread.sleep(1500);
		}
		
		catch (InterruptedException e)
		{
				e.printStackTrace();
		}
	}
	
}