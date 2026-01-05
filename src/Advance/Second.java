package Advance;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Second 
{

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException
	{
	
		Custom custom = new Custom();
		
		System.out.println(custom.get());
		System.out.println(custom.get(10, TimeUnit.SECONDS));

	}

}

class Custom implements Future<String>
{
	
	public boolean cancel(boolean mayInterruptIfRunning)
	{
		return false;
	}
	
	public boolean isCancelled()
	{
		return false;
	}
	
	public boolean isDone()
	{
		return false;
	}
	
	public String get() throws InterruptedException,ExecutionException
	{
		return "Demo get";
	}
	
	public String get(long timeout, TimeUnit unit)throws InterruptedException,ExecutionException,TimeoutException
	{
		boolean flag = true;
		
		if(flag)
		{
			throw new TimeoutException("Your net is slow");
		}
		
		while(flag)
		{
			
		}
		
		return "demo";
	}
}