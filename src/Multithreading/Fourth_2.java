package Multithreading;

public class Fourth_2 
{

	public static void main(String[] args) throws InterruptedException
	{
		Resource res = new Resource();
		IncreamentThread thread = new IncreamentThread(res);
		
		thread.start();
		thread.join();
		System.out.println(res.getCounter());
	}

}

class Resource
{
	int counter = 1;
	
	public int getCounter()
	{
		return this.counter;
		
	}
}

class IncreamentThread extends Thread
{
	Resource res;
	
	public IncreamentThread(Resource res)
	{
		this.res = res;
	}
	
	public void run()
	{
		int sum = 1;
		while(sum<1500)
		{
			this.res.counter++;
			sum++;
		}
		System.out.println("total counter : "+this.res.counter);
	}
}