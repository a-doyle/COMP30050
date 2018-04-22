
public class Money 
{
	int money;
	
	public Money()
	{
		
	}
	public int getMoney()
	{
		return money;
	}
	
	public void addMoney(int amount) 
	{
		money += amount;
	}
	
	public void substractMoney(int amount) 
	{
		money -= amount;
		
	}
	
	public boolean noMoney() 
	{
		return money < 0;
	}
}
