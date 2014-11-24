import org.jibble.pircbot.PircBot;

public class MainBot extends PircBot {

    public MainBot() {
      this.setName("k1llerbot");
    }
    /*public void testSql(String sender){
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admins", "user", "p");
            Statement mystmnt = myconn.createStatement();
            String SQL = "insert into admins " + " (username, email)" + " values ( , 'k1llerk4se@live.com')";
            mystmnt.executeUpdate(SQL);
            //Statement allUser = myconn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
    /*public String isListed(String sender){
        String allSenders = null;
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admins", "k1llerk4se", "Kazm9495893");
            Statement allUser = myconn.createStatement();
            ResultSet allUserRest = allUser.executeQuery("select user from users where user ='" + sender + "'");
            allSenders = allUserRest.toString();
            if (allSenders != sender){
                CallableStatement userCall = myconn.prepareCall("{call insert_user(?)}");
                userCall.setString(1, allSenders);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return allSenders;
    }*/

    public void onMessage(String channel, String sender,
                          String login, String hostname, String message) {
        if(message.contains("adblock")) {
            if (message.equalsIgnoreCase("!adblock")) {
                sendMessage(channel, "Hey don't mention Adblock in this channel, We all know it exist but it hurts us as streamers and content creators.");
            }
            else {
                sendMessage(channel, ".timeout " + sender);
                sendMessage(channel, ".unban " + sender);
                sendMessage(channel, "Hey " + sender + " don't mention Adblock in this channel, We all know it exist but it hurts us as streamers and content creators.");
            }
        }
        if(message.equalsIgnoreCase("!age")){
            sendMessage(channel ,"I'm 21, so stop asking!");
        }
        if (message.equalsIgnoreCase("!botderp")){
            sendMessage(channel, "K1llerbot you just done derped boy.");
        }
        if (message.equalsIgnoreCase("!badbot")){
            sendMessage(channel, "/me hides in a corner");
        }
        if(message.equalsIgnoreCase("!crash")){
            sendMessage(channel, "Oops it looks like Mikel broke his game AGAIN, get out the popcorn");
        }
        /*if (message.equalsIgnoreCase("!mod")) {
            if (sender == "k1llerk4se") {
                String name;
                name = message.split(" ")[1];
                testSql(name);
            }
        }*/
        if (message.equalsIgnoreCase("!pif")){
            sendMessage(channel, "Every 50 dollars of donations, I will give away a game on steam. #playitforward.");
        }
        if (message.equalsIgnoreCase("!riot")) {
            sendMessage(channel, "༼ つ◕_◕༽つ Death or Riot ༼ つ◕_◕༽つ");
        }
        if (message.equalsIgnoreCase("!riot1")) {
            String riot = message.split(" ")[1];
            sendMessage(channel, "༼ つ◕_◕༽つ" + riot + "or Riot ༼ つ◕_◕༽つ");
        }
        if (message.equalsIgnoreCase("!twitter")) {
            sendMessage(channel, "Follow me on twitter https://twitter.com/k1llerk4se");
        }
        if (message.equalsIgnoreCase("hey")|| message.equalsIgnoreCase("hi") || message.equalsIgnoreCase("hello")){
            sendMessage(channel, "o/ Heyo \\o. " + sender + " how are you tonight?");
        }
        if (message.contains("***")) {
            sendMessage(channel, ".timeout " + sender);
            sendMessage(channel, ".unban " + sender);
            sendMessage(channel, "HEY! " + sender + " Just because I curse that dosen't mean you should so stop it.");
        }
    }
    /*public void onJoin(String channel, String sender, String login, String hostname) {
        String sqlUser;
        sqlUser = isListed(sender);
        if (sqlUser != sender) {
            sendMessage(channel, "Welcome to the crew " + sender);
        }
        else{
            sendMessage(channel, "Welcome back " + sender + " good to see you again");
        }
    }*/
}
