package com.txu.webserviceclients.jms;

import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


/**
 * Sends the cust_id, sevice_id as a message to the JMS receiver.
 */
@Component("messageSender")
public class MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * Sends the cust_id, sevice_id as a message to the JMS receiver.
	 * @param message[service_id + cust_id]
	 */
	public void sendMessage(final String message) {

		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}

		});

	}
}