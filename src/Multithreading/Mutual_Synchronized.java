package Multithreading;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Mutual_Synchronized
{

	public static void main(String[] args) 
	{
		
		Student_Utilizer util = new Student_Utilizer();
		Student_Utilizer util2 = new Student_Utilizer();
		
		Getdet get = new Getdet(util);
		Senddet send = new Senddet(util,"First");
		
		get.start();
		send.start();

	}

}

class Student
{
	int id;
	String name;
	String email;
	String city;
	
	public Student(int id, String name, String email, String city)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
	}
}

class Student_Utilizer
{
	List<Student>uss = new ArrayList<Student>();
	
	public synchronized void signstudents() throws InterruptedException
	{
		if(uss.size() == 2)
		{
			System.out.println("Memory full....remove the students....");
			wait();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the name....");
		String name = sc.next();
		
		System.out.println("enter the email...");
		String email = sc.next();
		
		Student student = new Student(0, name, email, null);
		uss.add(student);
		System.out.println("student added....");
		
		System.out.println("Notifying mail sender...");
		notifyAll();
	}
	
	public void sendmails() throws InterruptedException
	{
		synchronized(this)
		{
			if(uss.size() == 0)
			{
				System.out.println("Empty list... entering waiting stage...");
				wait();
			}
			
			Student st = uss.remove(0);
			System.out.println("sending the email to : "+st.email);
			System.out.println("notifying get details");
			notifyAll();
		}
	}
}

class Getdet extends Thread
{
	Student_Utilizer stud;
	
	public Getdet(Student_Utilizer stud)
	{
		this.stud = stud;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				stud.signstudents();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

class Senddet extends Thread
{
	Student_Utilizer stud;
	
	public Senddet(Student_Utilizer stud, String name)
	{
		super(name);
		this.stud = stud;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				stud.sendmails();
				System.out.println(this.getName()+"executing...");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}