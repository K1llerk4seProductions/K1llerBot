public class MainClass {

public static void main(String[] args){
	MainBot bot = new MainBot();
	int ircPort = 6667;
try{
bot.setVerbose(true);
bot.connect("irc.twitch.tv", ircPort, "oauth");
bot.joinChannel("#k1llerk4se");
}
catch (Exception e){e.printStackTrace();}
}
}