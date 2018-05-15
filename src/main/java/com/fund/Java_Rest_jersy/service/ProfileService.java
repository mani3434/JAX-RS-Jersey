package com.fund.Java_Rest_jersy.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.fund.Java_Rest_jersy.model.Profile;
import com.fund.Java_Rest_jersy.resources.DataSource;

public class ProfileService {

	private Map<String, Profile> profiles = DataSource.getProfiles();

	public ProfileService() {

		profiles.put("mani", new Profile(1, "mani", "mani", "earla"));
		profiles.put("jaga", new Profile(2, "jaga", "jaga", "earla"));
		profiles.put("dad", new Profile(3, "dad", "subbarao", "earla"));

	}

	public List<Profile> getProfileByYear(int year) {

		List<Profile> li = new ArrayList<>();

		Calendar c = Calendar.getInstance();

		for (Profile p : profiles.values()) {

			c.setTime(p.getCreated());

			if (c.get(Calendar.YEAR) == year) {
				li.add(p);
			}
		}
		return li;
	}

	public List<Profile> filterProfiles(int start, int size) {

		List<Profile> ps = new ArrayList<>(profiles.values());

		if (start + size > profiles.size()) {
			return new ArrayList<>();
		}

		return ps.subList(start, start + size);

	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String name) {

		if (profiles.containsKey(name)) {
			return profiles.get(name);
		}
		return null;
	}

	public Profile createProfile(Profile p) {

		p.setId(profiles.size() + 1);
		profiles.put(p.getProfileName(), p);

		return p;

	}

	public Profile updateProfile(Profile p) {

		if (profiles.containsKey(p.getProfileName())) {
			profiles.put(p.getProfileName(), p);
			return p;
		}
		return null;
	}

	public Profile deleteProfiles(String name) {

		if (name == null) {
			return null;
		}
		return profiles.remove(name);
	}

}
