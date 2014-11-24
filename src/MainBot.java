import org.jibble.pircbot.PircBot;

import java.sql.*;

public class MainBot extends PircBot {

    public MainBot() {
      this.setName("k1llerbot");
    }
    public void testSql(String sender){
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admins", "user", "pass");
            Statement mystmnt = myconn.createStatement();
            String SQL = "insert into admins " + " (username, email)" + " values ( , 'k1llerk4se@foo.com')";
            mystmnt.executeUpdate(SQL);
            //Statement allUser = myconn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String isListed(String sender){
        String allSenders = null;
        try {
            Connection myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admins", "user", "pass");
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
    }

    public void onMessage(String channel, String sender,
                          String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        if (message.equalsIgnoreCase("!twitter")) {
            sendMessage(channel, "Follow me on twitter https://twitter.com/k1llerk4se");
        }
        if (message.equalsIgnoreCase("!riot")) {
            sendMessage(channel, "༼ つ◕_◕༽つ Death or Riot ༼ つ◕_◕༽つ");
        }
        if (message.equalsIgnoreCase("!riot1")) {
            String riot = message.split(" ")[1];
            sendMessage(channel, "༼ つ◕_◕༽つ" + riot + "or Riot ༼ つ◕_◕༽つ");
        }
        if (message.equalsIgnoreCase("!mod")) {
            if (sender.equals("k1llerk4se")) {
                String name;
                name = message.split(" ")[1];
                testSql(name);
            }
        }
        if (message.contains("***")) {
            sendMessage(channel, ".timeout " + sender);
        }
        if (message.contains("test")) {
            sendMessage(channel, ".timeout " + sender);
            unBan(channel, hostname);
        }
    }
    public void onJoin(String channel, String sender, String login, String hostname) {
        String sqlUser;
        sqlUser = isListed(sender);
        if (sqlUser != sender) {
            sendMessage(channel, "Welcome to the crew " + sender);
        }
        else{
            sendMessage(channel, "Welcome back " + sender + " good to see you again");
        }
    }
}
