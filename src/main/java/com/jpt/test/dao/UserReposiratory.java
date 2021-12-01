package com.jpt.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpt.test.entities.User;

public interface UserReposiratory extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);
}
