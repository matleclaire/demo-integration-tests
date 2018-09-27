package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HomeServiceTest {

	@Mock
	private UserRepository userRepository;
	private HomeService service;

	@Before
	public void setUp() {
		service = new HomeService();
	}

	@Test
	public void test_sayHello_should_return_helloWorld() {
		assertThat(service.sayHello()).isEqualTo("Hello World");
	}
}
