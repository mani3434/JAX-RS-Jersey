package com.fund.Java_Rest_jersy.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fund.Java_Rest_jersy.model.Profile;
import com.fund.Java_Rest_jersy.service.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService ps = new ProfileService();
	
	@GET
	public List<Profile> allProfiles(@BeanParam FilterBean fb){
		
		if(fb.getYear() >0) {
			return ps.getProfileByYear(fb.getYear());
		}
		if(fb.getStart()>= 0 && fb.getSize()>=0 && fb.getStart() < fb.getSize()) 
		{
			return ps.filterProfiles(fb.getStart(), fb.getSize());
		}
		
		return ps.getAllProfiles();
		
	}
	
	
	@GET
	@Path("/{id}")
	public Profile getProfile(@PathParam("id") String name) {
		
		return ps.getProfile(name);
		
	}
	
	@PUT
	@Path("/{id}")
	public Profile updateProfile(@PathParam("id") String name, Profile p) {
		
		p.setProfileName(name);
		return ps.updateProfile(p);
	}
	
	
	@POST
	public Profile createProfile(Profile profile) {
		
		return ps.createProfile(profile);
	}
	
	
	@DELETE
	@Path("/{id}")
	public void deleteProfile(@PathParam("id") String name) {
		
		 ps.deleteProfiles(name);
	}
	
	
	
}
