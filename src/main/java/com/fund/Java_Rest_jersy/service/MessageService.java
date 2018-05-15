package com.fund.Java_Rest_jersy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fund.Java_Rest_jersy.model.Message;
import com.fund.Java_Rest_jersy.resources.DataSource;



public class MessageService {


	private Map<Long, Message> msg = DataSource.getMessages();
	
	
	public MessageService() {
		
		msg.put(1L, new Message(1L, "Hi", "mani"));
		msg.put(2L, new Message(3L, "Hello", "jaga"));
		msg.put(3L, new Message(2L, "Hey", "dad"));
		
		//System.out.println("Initial objects"+msg );
	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(msg.values()); 
		
	}
	
	public Message getMessage(Long id) {
		
		return msg.get(id);
	}
	
	public Message putMessage(Message m) {
		m.setId(msg.size()+1);
		msg.put(m.getId(), m);
		
		return m;
	}
	
	public Message updateMessage(Message m) {
		
		if(m.getId() > 0 && msg.containsKey(m.getId())) {
			
			msg.put(m.getId(), m);
		}
		//System.out.println(msg);
		return m;
	}
	
	public Message deleteMessage(Long id) {
		
		if(id > 0 && msg.containsKey(id)) {

			return msg.remove(id);
			
		}

		return null;
		
	}
}
