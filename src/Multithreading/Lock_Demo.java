package Multithreading;

public class Lock_Demo
{

	public static void main(String[] args) throws InterruptedException
	{
		
		Mutable_resource mt = new Mutable_resource();
		One_Thread one = new One_Thread(mt, "First Thread");
		Two_Thread two = new Two_Thread(mt, "Second Thread");
		One_Thread tree = new One_Thread(mt, "Third Thread");
		
		one.start();
		two.start();
		tree.start();
		
		System.out.println(one.getName());
		System.out.println(two.getName());
		
		Thread.sleep(6000);
		System.out.println(mt.getCounter());

	}

}

class Mutable_resource
{
	int counter = 0;
	
	String increase()
	{
		synchronized(this)
		{
			this.counter++;
		}
		
		return "Hello";
	}
	
	public int getCounter()
	{
		return this.counter;
	}
	
	public String getmessage()
	{
		return "Hello brother !";
	}
}

class One_Thread extends Thread
{
	Mutable_resource mt;
	
	public One_Thread(Mutable_resource mt, String name)
	{
		super(name);
		this.mt = mt;
	}
	
	public void run()
	{
		System.out.println(mt.getmessage());
		
		int num = 1;
		
		while(num <= 10000)
		{
			mt.increase();
			num++;
		}
	}
}

class Two_Thread extends Thread
{
	Mutable_resource mt;
	
	public Two_Thread(Mutable_resource mt, String str)
	{
		super(str);
		this.mt = mt;
	}
	
	public void run()
	{
		System.out.println(mt.getmessage());
		int num = 1;
		
		while(num <= 10000)
		{
			mt.increase();
			num++;
		}
	}
}