package Advance;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		ConcurrentHashMap<Integer, String>map = new ConcurrentHashMap<Integer, String>();
		
		Thread t1 = new Thread(()->{
			
			int i = 1;
			
			while(i <= 10)
			{
				map.put(i, "AB");
				i++;
			}
		});
		
		Thread t2 = new Thread(()->{
			
			int j = 11;
			
			while(j <= 20)
			{
				map.put(j, "CD");
				j++;
			}
		});
		
		t1.start();
		t2.start();
		
		Thread.sleep(3000);
		
		System.out.println(map);

	}

}