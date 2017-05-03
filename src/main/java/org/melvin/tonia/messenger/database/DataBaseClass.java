package org.melvin.tonia.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.melvin.tonia.messenger.model.Message;
import org.melvin.tonia.messenger.model.Profile;

public class DataBaseClass {

	private static Map<Long, Message> messageMap = new HashMap<Long, Message>();
	private static Map<String, Profile> profileMap = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessageMap() {
		return messageMap;
	}
	public static Map<String, Profile> getProfileMap() {
		return profileMap;
	}
	
	
}
