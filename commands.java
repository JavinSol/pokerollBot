package main.copy;


import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;


// Might Want to remove the crit thing. Can Get confusing near the end. 

public class commands extends ListenerAdapter{
	public String prefix = "p";
	Random rng = new Random();
	
	MessageReceivedEvent event = null;
	
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		//Rolls
		if(args[0].equalsIgnoreCase(prefix + "roll")) {
			if(args.length < 2) {
				//TODO Error
			}
			else {
				Roll yup = new Roll(args[1]);
				event.getMessage().reply(yup.rollDice()).queue();;
			}
				
			}
		
		
		//Moves
		if(args[0].equalsIgnoreCase(prefix + "move")) {
			
			if(args.length < 2) {
				event.getMessage().reply("Please type in a move").queue();
			}
			else {
				String moveWord = "";
				for(int i = 1; i < args.length -1; i++) {
					moveWord += args[i] + " ";
				}
				moveWord += args[args.length - 1];
				
				//"C:\Users\javin\Desktop\PokeRole\Moves\Attack Order .jpg"
				//"C:\Users\javin\Desktop\PokeRole\Backup Moves\Bug\Attack Order.jpg"
				
				if(moveWord.compareTo("Curse") == 0||moveWord.compareTo("curse") == 0) {
					File f = new File("FILELOCATION\\Curse.jpg");
					File g = new File("FILELOCATION\\Cursed.jpg");
					ArrayList<File> multi = new ArrayList<File>();
					multi.add(g);
					multi.add(f);
					event.getMessage().replyFiles(FileUpload.fromData(f), FileUpload.fromData(g)).queue();
//					event.getMessage().replyFiles(FileUpload.fromData(g)).queue();
				}
				else {
				
				File f = new File("FILELOCATION\\Moves\\" + moveWord + ".jpg");
				event.getMessage().replyFiles(FileUpload.fromData(f)).queue();//SHoves a file to the bot
				}
			}
		}
				

		//Sends all the commands to it
		if(args[0].equalsIgnoreCase(prefix + "help")) {
			EmbedBuilder help = new EmbedBuilder();
			help.setTitle("Commands");
			help.setDescription("Used to find the ammount of successes without having to count it. Can be used for any dice");
			help.addField("proll xDx", "Rolls the ammount of dice based on the first number. The dice will be based on the second number. Default successes is (1/2) the dice + 1. Ex: 5d6", false);
			help.addField("pmove x", "Searches and sends a jpg of the move that you are looking for. If missing will not show. Note: acupresure is spelled accupresure cause the dumbasses spelled it wrong", false);
			help.addField("pability x", "comming soon", false);
			help.addField("pmon x", "comming soon", false);
			help.setColor(0xb00707);
			event.getMessage().replyEmbeds(help.build()).queue();
//			event.getMessage().reply(help.build()).queue();
		}
	}
		
}
