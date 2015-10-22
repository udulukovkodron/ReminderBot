package Bots;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ReminderBot extends Bot {

	Date theTime = null;
	String message = null;
	boolean dateEntered = false;
	
	private final String help = "Please use /remind with flags: \n"
			+ "-m <Message> \n" 
			+ "-t <date-time> 		- specifies the date and time in dd.MM.yyyy hh:mm format\n"; 
	
	public ReminderBot(int ID, String nick_name, String user_name) 
	{
		super(ID, nick_name, user_name);
	}

	@Override
	public void processCommand(String cmd) {
		
		boolean	res = parseCommand(cmd);
		if(res)
			this.doRemind();
		else
		{
			System.out.println("Can't parse your reqeust");
			System.out.println(help);
		}
	}
	private void doRemind() {
		// TODO Auto-generated method stub
		
	}

	Boolean parseCommand(String cmd) {
		String curstr = cmd;
		if(!cmd.startsWith("/remind"))
		{
			return false;
		}		
		curstr = curstr.substring("/remind".length() );
		String[] params = curstr.split("-");
		for (String item : params) 
		{
			if(item == null)
				continue;
			String tmp = item;
			if(item.startsWith("t"))
			{
				tmp = item.substring(2);
				try {
					theTime = new SimpleDateFormat("dd.MM.yyyy hh:mm").parse(tmp);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dateEntered = true;
			}
			if(item.startsWith("m"))
				message = item.substring(2);
		}
		return (dateEntered && (message != null));
	}


	@Override
	public void run() {
		System.out.println("I am the reminder bot!");
		while (true)
		{
			if(!end)
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				}

				if(theTime == null)
					continue;
				Date now = new Date();
				if(theTime.compareTo(now) <= 0 )
				{
					theTime = null;
					System.out.println(this.message);
				}
			}
			else
				return;
		}
		// TODO Auto-generated method stub
		
	}
}
