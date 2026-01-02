package Multithreading;

import java.util.ArrayList;
import java.util.List;

public class Mutual_Demo 
{

	public static void main(String[] args) 
	{

		Reso res=new Reso();
				
		ProducerThread thred=new ProducerThread(res);
		ConsumerThread  t2=new ConsumerThread(res);
				
		thred.start();
		t2.start();
	}
}

class Reso
{
	List<Integer> list=new ArrayList<Integer>();
			
			
	public synchronized  void addtoList(int value) throws InterruptedException
	{
		if(list.size()==10)
		{
			System.out.println(" I am waiting...the memory is full...please remove the elements...");
			wait();
		}
				
		System.out.println("adding the number:"+value);
		list.add(value);
		System.out.println("notyfying the consumer....");
		notify();
				
				
	}
			
			
	public synchronized void useNumber() throws InterruptedException
	{
		if(list.size()==0)
		{
			System.out.println("I am waiting for the number to be added...");
			wait();
		}
		int num=list.remove(0);
		System.out.println("removed number:"+num);
		System.out.println("notifying the producer that I have removed a numner so it can add a new number");
		notify();
	}
}

class ProducerThread extends Thread
{
	Reso res;
			
	public ProducerThread(Reso res)
	{
		this.res=res;
	}
			
	public void run()
	{
		int counter=1;
		while(true) 
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			try 
			{
				res.addtoList(counter);
				counter++;
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}


class ConsumerThread extends Thread
{
			Reso res;
			
			public ConsumerThread(Reso res)
			{
				this.res=res;
			}
			
			public void run()
			{ 
				while(true)
				{
					try 
					{
						Thread.sleep(50000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				try 
				{
					res.useNumber();
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				}
			}


}


