package sender;

import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySenderTopic {

	public static void main(String[] args) {

		try
		{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Topic topic = (Topic) applicationContext.getBean("topic");
			TopicSession session;
			TopicConnection cnx;
			TopicPublisher MyTopic;
			TextMessage message;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			cnx = (TopicConnection) factory.createTopicConnection();
			System.out.println("Création de la connexion.");	
			
			// Open a session without transaction and acknowledge automatic
			session = cnx.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("Création de la session.");
			
			// Start the connection
			cnx.start();
			System.out.println("Lancement de la connexion.");	
			
			// Create a sender
			MyTopic = session.createPublisher(topic);
			System.out.println("Topic Créé.");
					
			// Create a message
			message = session.createTextMessage("\n \nSecond Message on this topic ! \n");
			System.out.println("Messsage rédigé.");	
			
			// Send the message
			MyTopic.send(message, DeliveryMode.PERSISTENT, 4, 10000);
			//MyTopic.send(topic, message);
			System.out.println("Message envoyé.");		
			
			// Close the session
			session.close();
			System.out.println("Session terminé.");	
			
			// Close the connection
			cnx.close();
			System.out.println("Connexion fermé.");	
			

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
