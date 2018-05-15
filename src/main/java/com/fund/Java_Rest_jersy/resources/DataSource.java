package com.fund.Java_Rest_jersy.resources;

import java.util.HashMap;
import java.util.Map;

import com.fund.Java_Rest_jersy.model.Message;
import com.fund.Java_Rest_jersy.model.Profile;


public class DataSource {

	
	private static Map<Long, Message> messages = new HashMap<>();
	
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
