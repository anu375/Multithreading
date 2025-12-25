package Multithreading;

public class Fourth_3 
{

	public static void main(String[] args) 
	{
		
		Shared shared = new Shared();
		
		OnE one = new OnE(shared);
		TwO two = new TwO(shared);
		
		one.Append_First("Hello");
		two.Append_Second("World");
		
		System.out.println(shared.showString());
		
		System.out.println(one.shared.sb == two.shared.sb);
	}

}

class Shared
{
	StringBuffer sb = new StringBuffer();
	
	public String showString()
	{
		return sb.toString();
	}
}

class OnE
{
	Shared shared;
	
	public OnE(Shared shared)
	{
		this.shared = shared;
	}
	
	public void Append_First(String str)
	{
		shared.sb.append(str);
	}
}

class TwO
{
	Shared shared;
	
	public TwO(Shared shared)
	{
		this.shared = shared;
	}
	
	public void Append_Second(String str)
	{
		shared.sb.append(str);
	}
}