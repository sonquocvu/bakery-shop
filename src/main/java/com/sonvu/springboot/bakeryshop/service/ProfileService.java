package com.sonvu.springboot.bakeryshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.Profile;
import com.sonvu.springboot.bakeryshop.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfileService {

	@Autowired 
	ProfileRepository profileRepository;
	
	public List<Profile> getTopFollowedProfiles(int numOfProfiles)
	{
		Pageable pageable = PageRequest.of(0, numOfProfiles);
		
		return profileRepository.findTopFollowedProfiles(pageable);
	}
}
