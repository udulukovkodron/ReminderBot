
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Bots.Bot;
import Bots.ReminderBot;
import Bots.TyperBot;

public class BotsMaint {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Type \"exit\" to exit programm");
		ReminderBot tb = new ReminderBot(1, "", "");
		tb.start();
		String input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
//			System.out.println("Main");exit
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			input = br.readLine();

			if(input.equals("exit"))
			{
				tb.kill();
				break;
			}
			if(input != null)
				tb.processCommand(input);
		}
	}
}
