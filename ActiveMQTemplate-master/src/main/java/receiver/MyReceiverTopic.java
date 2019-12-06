package receiver;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyReceiverTopic {

	public static void main(String[] args) {
		
		try
		{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");			
			TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Topic topic = (Topic) applicationContext.getBean("topic");
			TopicConnection cnx;
			TopicSubscriber receiver;
			TopicSession session;
			TextMessage receivedMessage;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			cnx =  factory.createTopicConnection();
			System.out.println("Création de la connexion.");	
			
			// Open a session
			session =  cnx.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("Session ouverte.");
			
			// start the connection	
			cnx.start();
			System.out.println("Connexion ouverte.");
			
			// Create a receive	
			receiver = session.createSubscriber(topic);
			System.out.println("Subscriber créé.");
			
			// Receive the message
			receivedMessage = (TextMessage) receiver.receive();
			System.out.println("Voici le message reçu : \n" + receivedMessage.getText());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
