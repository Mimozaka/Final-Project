package sender;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.jms.QueueConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender {
	
	private static final Logger log = LoggerFactory.getLogger(MySender.class);

	public static void main(String[] args) {
		
		
		try{
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			QueueSession session;
			QueueConnection cnx;
			QueueSender sender;
			TextMessage message;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			cnx = (QueueConnection) factory.createConnection();
			log.info("\nCr�ation de la connexion.");	
			
			// Open a session without transaction and acknowledge automatic
			session = (QueueSession) cnx.createSession(false, Session.AUTO_ACKNOWLEDGE);
			log.info("\nCr�ation de la session.");
			
			// Start the connection
			cnx.start();
			log.info("\nLancement de la connexion.");	
			
			// Create a sender
			sender = session.createSender(queue);
			log.info("\nSender Cr��");
					
			// Create a message
			message = session.createTextMessage("\nThis is the first message. Well done ! WESH MGL \n\n");
			log.info("\nMesssage r�dig�.");	
			
			// Send the message
			sender.send(queue, message);
			log.info("\nMessage envoy�.");		
			
			// Close the session
			session.close();
			log.info("\nSession termin�.");	
			
			// Close the connection
			cnx.close();
			log.info("\nConnexion ferm�.");	

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
