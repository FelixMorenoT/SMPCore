package com.smp.core.app.services.message.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver implements MessageListener
{
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message)
	{
		try
		{
			String product = (String) messageConverter.fromMessage(message);

			System.out.println("------- CORE Inside onMessage-------");
			System.out.println(product);
			System.out.println("------- CORE Inside onMessage-------");
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}
	}
}
