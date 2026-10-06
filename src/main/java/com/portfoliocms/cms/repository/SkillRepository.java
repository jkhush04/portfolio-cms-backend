package com.portfoliocms.cms.repository;

import com.portfoliocms.cms.model.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepository extends MongoRepository<Skill,String>{
}
