package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;

public interface UserRepositoryCustom {


	/**
	 * Find all users with a pattern that match a pattern for the firstname.
	 * <p>
	 * This query is so complicated that we need to implement it
	 * by ourselves. This is for test purpose only ;-)
	 *
	 * @param firstnamePattern the regexPattern used for firstname
	 * @return a list of {@link User}
	 */
	List<User> findByAVeryComplicatedCriteria(String firstnamePattern);
}
