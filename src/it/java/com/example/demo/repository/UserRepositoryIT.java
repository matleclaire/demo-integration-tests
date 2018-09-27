package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    /**
     * We reset User Collection after each test
     */
    @After
    public void resetCollection() {
        userRepository.deleteAll();
    }

    /**
     * This test execute the method findByAVeryComplicatedCriteria against
     * a User Collection pre-filled with 2 users :
     * - John Doe
     * - Bill Clinton
     */
    @Test
    public void test_findByAVeryComplicatedCriteria() {
        //GIVEN
        insertUser("John", "Doe");
        insertUser("Bill", "Clinton");
        
        //WHEN
        List<User> users = userRepository.findByAVeryComplicatedCriteria("J.*");

        //THEN
        assertThat(users).hasSize(1)
        .extracting("firstName").contains("John");
    }

    private void insertUser(String firstName, String lastName) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        userRepository.save(user);
    }


}
