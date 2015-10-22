package Bots;

public final class TyperBot extends Bot {

	public TyperBot(int ID, String nick_name, String user_name) 
	{
		super(ID, nick_name, user_name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processCommand(String cmd) 
	{
		System.out.println(cmd);
		
		switch(cmd)
		{
		case "hello":
			System.out.println("hello Creep");
			break;
		case "How are you?":
			System.out.println("I\'m fine and you?");
			break;
			default :
				System.out.println("What oO?");
				break;
		
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
