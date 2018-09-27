package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Here we're doing integration tests against the entire application started on a random port.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void test_root_should_return_helloworld() {
        //GIVEN
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        //WHEN
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/"),
                HttpMethod.GET, entity, String.class);

        //THEN
        String expected = "Hello World";
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expected);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


}
