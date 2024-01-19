package main.copy;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class BotStartup {

	public static void main(String[] args) throws LoginException{
		JDABuilder jda = JDABuilder.createDefault("ENTER TOKEN HERE");
		jda.setActivity(Activity.playing("PokeRole"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.enableIntents(GatewayIntent.MESSAGE_CONTENT);
		jda.addEventListeners(new commands());
		jda.build();
	}

}
