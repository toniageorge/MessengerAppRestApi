package org.melvin.tonia.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.melvin.tonia.messenger.model.Profile;
import org.melvin.tonia.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ProfileResource {


	ProfileService pservice = new ProfileService();
	@GET
	public List<Profile> getProfiles(){
		return pservice.getAllProfiles();
		
	}
	
	@GET
	@Path("/{profileName}")	
	public Profile getProfile(@PathParam("profileName") String profileName){	
		return pservice.getProfile(profileName);
	}
	
	@POST
	
	public Profile getProfiles(Profile profile){
		
		return pservice.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return pservice.updateProfile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void  deleteProfile(@PathParam("profileName") String profileName){	
		 pservice.deleteProfile(profileName);
	}

}
