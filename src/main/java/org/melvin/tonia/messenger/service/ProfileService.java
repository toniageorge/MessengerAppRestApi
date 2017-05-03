package org.melvin.tonia.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.melvin.tonia.messenger.database.DataBaseClass;
import org.melvin.tonia.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profileMap = DataBaseClass.getProfileMap();

	public ProfileService() {
		Profile p1 = new Profile(1,"ToniaG","tonia","Mel");
		Profile p2 = new Profile(2,"Melvinmp","melvin","ton");
		profileMap.put("ToniaG", p1);
		profileMap.put("Melvinmp",p2);
	}

	public List<Profile> getAllProfiles(){		
		return new ArrayList<Profile>( profileMap.values());
	}
	
	public Profile getProfile(String profileName){	
		return profileMap.get(profileName);
	}
	
	public Profile addProfile(Profile p ){		
		p.setId(profileMap.size() + 1);
		profileMap.put(p.getProfileName(), p);
		return p;		
	}
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){			
			return null;
		}
		profileMap.put(profile.getProfileName(), profile);
		return profile;
	}
	public void deleteProfile(String profileName){
		profileMap.remove(profileName);
	}
	
	

}
