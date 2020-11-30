package com.smp.core.app.services.message.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.smp.core.app.services.message.receiver.MessageReceiver;

@Configuration
public class MessagingConfiguration
{

	private static final String DEFAULT_BROKER_URL = "ssl://b-d95ea51a-8dc6-4c11-bca8-1f6b828e1b88-1.mq.us-east-2.amazonaws.com:61617";
	private static final String MESSAGE_QUEUE = "message_queue";

	@Autowired
	MessageReceiver messageReceiver;

	@Bean
	public ConnectionFactory connectionFactory()
	{
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setUserName("root");
		connectionFactory.setPassword("estrellaestrella");
		connectionFactory
				.setTrustedPackages(Arrays.asList("com.smp.core.app.services.message"));
		return connectionFactory;
	}

	/*
	 * Message listener container, used for invoking
	 * messageReceiver.onMessage on message reception.
	 */
	@Bean
	public MessageListenerContainer getContainer()
	{
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(MESSAGE_QUEUE);
		container.setMessageListener(messageReceiver);
		return container;
	}

	/*
	 * Used here for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(MESSAGE_QUEUE);
		return template;
	}

	@Bean
	MessageConverter converter()
	{
		return new SimpleMessageConverter();
	}

}
