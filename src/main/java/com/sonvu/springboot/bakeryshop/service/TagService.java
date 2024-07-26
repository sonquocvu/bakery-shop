package com.sonvu.springboot.bakeryshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sonvu.springboot.bakeryshop.entity.Tag;
import com.sonvu.springboot.bakeryshop.repository.TagRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> getTopTags(int numOfTag)
	{
		Pageable pageable = PageRequest.of(0, numOfTag);
		
		return tagRepository.findTopTags(pageable);
	}
}
