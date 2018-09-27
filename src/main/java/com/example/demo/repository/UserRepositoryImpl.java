package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom{

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<User> findByAVeryComplicatedCriteria(String firstnamePattern) {
		Criteria criteria = Criteria.where("firstName")
				.regex(firstnamePattern);

		return mongoTemplate.find(new Query(criteria), User.class);
	}
}
