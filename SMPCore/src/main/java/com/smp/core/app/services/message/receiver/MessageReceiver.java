package com.smp.core.app.services.message.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smp.core.app.entity.Alarma;
import com.smp.core.app.services.alarma.AlarmasServiceRepository;
import com.smp.core.app.services.signo.ISignos;

@Component
public class MessageReceiver implements MessageListener
{
	
	private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	MessageConverter messageConverter;

	@Autowired
	private AlarmasServiceRepository servicesSignos;
	
	@Autowired
	private ISignos signosRepo;
	
	public void onMessage(Message message)
	{
		try
		{
			log.info("MQ Init");
			ObjectMapper mapper = new ObjectMapper();
			Alarma m = new Alarma();
			
			String product = (String) messageConverter.fromMessage(message);
			m = mapper.readValue(product, Alarma.class);
			m.setDescripcionMedida(signosRepo.findBySignoCode(m.getMedida()));
			servicesSignos.saveSignos(m);
			log.info("MQ Finish");
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
