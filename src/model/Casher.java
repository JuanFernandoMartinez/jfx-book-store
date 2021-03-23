package model;

public class Casher {
	private Client c;
	private int bs;
	
	public Casher() {
		c = null;
		bs = 0;
	}
	
	public void setClient(Client c)
	{
		this.c = c;
		bs = c.getDeck().size();
	}
	
	public void step()
	{
		bs--;
		
		if (bs == 0)
		{
			c = null;
		}
	}
	
	
	public boolean isEmpty()
	{
		if (c == null)
		{
			return true;
		}
		
		return false;
	}
	
	public Client getClient()
	{
		return c;
	}
	
	public int getBS()
	{
		return bs;
	}
}
