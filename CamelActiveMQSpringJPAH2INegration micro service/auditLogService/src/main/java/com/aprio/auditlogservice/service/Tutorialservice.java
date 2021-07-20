package com.aprio.auditlogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprio.auditlogservice.model.Tutorial;
import com.aprio.auditlogservice.repo.TutorialRepository;

@Service
public class Tutorialservice {

	@Autowired
	TutorialRepository tutorialRepository;
	
	public Tutorial saveTutorial(Tutorial tutorial) {
		Tutorial _tutorial = tutorialRepository
				.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
		return _tutorial;
	}
	
	public Tutorial getTutorial() {
		Tutorial tutorial = new Tutorial();
		tutorial.setDescription("d2==");
		tutorial.setPublished(false);
		return tutorial;
	}
	
	
}
