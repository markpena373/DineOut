package application;
import twitter4j.*;
import twitter4j.auth.*;

public class TwitterClass {

			private String consumerKey;
			private String consumerSecret;
			private String accessToken;
			private String accessTokenSecret;
			private PersonArray userList;
			private Restaurant selectedRestaurant;
			
			public TwitterClass(PersonArray users, Restaurant selected) {
				this.consumerKey="YXRc3rKIpIz3vxxS9qjgp4ndQ";
				this.consumerSecret="zmnmimOKqfB0fILN0VcrJB0TGyZB2339kECPk02cF0sVmkGTOb";
				this.accessToken="922922886708506625-jz5RY1aAZq9id2CDEpO45tHpXMfQc4v";
				this.accessTokenSecret="9X5App0pwzeZ1mvXrtPlZre85zYCPq0T5KPjPhpUs4oTH";
				this.selectedRestaurant = selected;
				this.userList = users;
				
			}
			
			
			@SuppressWarnings("unused")
			public void sendTweet()
			{
				TwitterFactory factory = new TwitterFactory();
				Twitter twitter = factory.getInstance();
				twitter.setOAuthConsumer(this.consumerKey, this.consumerSecret);
				AccessToken accessToken = new AccessToken(this.accessToken, this.accessTokenSecret);
				twitter.setOAuthAccessToken(accessToken);
				
				for(int i = 0; i < this.userList.getArraySize(); i++)
				{
					String twitterName =  this.setHandle(i);
					User user = null;
					try {
						user = twitter.showUser(twitterName);
					} catch (TwitterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String name = user.getName();
					String directMessage=this.createMessage(i, name);
	
					try {
						DirectMessage message = twitter.sendDirectMessage(twitterName, directMessage);
					} catch (TwitterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

			}
			
			public String createMessage(int i, String name)
			{
				String message = "Thanks for using DineOut: The results are in " + name + ". Your group is going to meet at "
						+ this.selectedRestaurant.getName() + " located at " + this.selectedRestaurant.getAddress() ;
				
				return message;
			}
			
			public String setHandle(int i)
			{
				return this.userList.getHandle(i);
			}
					
			
			
			public Restaurant getSelectedRestaurant() {
				return selectedRestaurant;
			}

			public void setSelectedRestaurant(Restaurant selectedRestaurant) {
				this.selectedRestaurant = selectedRestaurant;
			}



			public String getConsumerKey() {
				return consumerKey;
			}

			public void setConsumerKey(String consumerKey) {
				this.consumerKey = consumerKey;
			}

			public String getConsumerSecret() {
				return consumerSecret;
			}

			public void setConsumerSecret(String consumerSecret) {
				this.consumerSecret = consumerSecret;
			}

			public String getAccessToken() {
				return accessToken;
			}

			public void setAccessToken(String accessToken) {
				this.accessToken = accessToken;
			}

			public String getAccessTokenSecret() {
				return accessTokenSecret;
			}

			public void setAccessTokenSecret(String accessTokenSecret) {
				this.accessTokenSecret = accessTokenSecret;
			}

			public PersonArray getUserList() {
				return userList;
			}

			public void setUserList(PersonArray userList) {
				this.userList = userList;
			}
			
	
}
