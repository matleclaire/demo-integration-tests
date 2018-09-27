package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UerServiceTest {

	@Mock
	private UserRepository userRepository;
	private UserService service;

	@Before
	public void setUp() {
		service = new UserService(userRepository);
	}

	@Test
	public void test_getAllUsers() {
		//TODO implement
		//		assertThat(service.getAllUsers());
	}
}
