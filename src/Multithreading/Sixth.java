package Multithreading;

public class Sixth 
{

	public static void main(String[] args) throws InterruptedException
	{
				
				Prime_1 p1 = new Prime_1();
				
				//Prime p2=new Prime();
				
				Thread_pratham t1 = new Thread_pratham(p1,"one");
				Thread_second t2 = new Thread_second(p1,"two");
				
				t2.setPriority(1);
				t1.setPriority(10);
				/**
				 * 1=>lowest.
				 * 10=>highest.
				 */
				 
				t1.start();
				t2.start();
				
				
				Thread.sleep(1500);
				System.out.println(p1.counter);
				//System.out.println(p2.counter);
				
		}
}

class Prime_1
{

	 int counter = 2;
			
	public  synchronized void increase()
	{
			
		counter++;
				
	}
}

class Thread_pratham extends Thread
{
			 
	Prime_1 p;
			 
	public Thread_pratham(Prime_1 p,String s)
	{
		super(s);
		this.p = p;
	}
			
	public void run()
	{
		 int counter = 1;
				 
		 System.out.println(this.getName()+"working");
		
		 while(counter<10000)
		 {
			p.increase();
			counter++;
		 }
	}
}

class Thread_second extends Thread
{
			 
	Prime_1 p;
			 
	public Thread_second( Prime_1 p,String s)
	{
		super(s);
		this.p = p;
	}
			 
			 
	public void run()
	{
		System.out.println(this.getName()+"working....");
		int counter = 1;
				 
		while(counter<10000)
		{
			p.increase();
			counter++;
		}
	}
}




