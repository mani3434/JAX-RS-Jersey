package com.fund.Java_Rest_jersy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fund.Java_Rest_jersy.model.Comments;
import com.fund.Java_Rest_jersy.model.Message;
import com.fund.Java_Rest_jersy.resources.DataSource;

public class CommentService {

	
	private Map<Long, Message> msg = DataSource.getMessages();
	
	public CommentService() {
		
		Map<Long, Comments> c = new HashMap<>();
		Comments c1 = new Comments(1L,"this is my first comment","sashi");
		Comments c2 = new Comments(2L,"this is my second comment","vikas");
		Comments c3 = new Comments(3L,"this is my third comment","sainath");
		c.put(1L, c1);
		c.put(2L, c2);
		c.put(3L, c3);
		
		msg.get(1L).setComments(c);
		msg.get(2L).setComments(c);
		msg.get(3L).setComments(c);
		
	}
	
	public List<Comments> allCommnets(long messageId){
		
		Map<Long, Comments> cs = msg.get(messageId).getComments();
	
		List<Comments> li = new ArrayList<>(cs.values());
		
	 return li;
	}
	
	
	public Comments getComment(long mid, long id) {
		
		Map<Long, Comments> cs = msg.get(mid).getComments();
				
		return cs.get(id);
	}
	
	
	public Comments addComment(long id, Comments c) {
		
		Map<Long,Comments> cs = msg.get(id).getComments();
		
		c.setId(cs.size()+1);
		cs.put(c.getId(), c);
		
		return c;
	}
	
	public Comments updateComment(long id, Comments c) {
		
		Map<Long,Comments> cs = msg.get(id).getComments();
		if(cs.containsKey((c.getId()))){
			cs.put(c.getId(), c);
		}
		
		return c;
		
	}
	
	public Comments deleteComment(long mid, long cid) {
	
		Map<Long,Comments> cs = msg.get(mid).getComments();
		
		return cs.remove(cid);
	}
	
	
}
