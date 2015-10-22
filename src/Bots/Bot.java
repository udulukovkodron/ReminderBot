package Bots;

public abstract class Bot extends Thread
{
	public String userName;
	public String nickName;
	private int ID;
	protected volatile boolean end = false;
	
	public void kill()
	{
		end = true;
	}
	
	public Bot(int ID, String nick_name, String user_name)
	{
		
		this.ID = ID;
		if(nick_name.isEmpty())
			this.nickName = "unknown";
		if(user_name.isEmpty())
			this.userName = "anonymous";
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	public String getNickName()
	{
		return this.nickName;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public abstract void processCommand(String cmd);

}
