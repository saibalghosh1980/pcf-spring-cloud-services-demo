package io.pivotalservices.coversservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
public class CoversServiceApplicationTests {

    private static final String EXPECTED = "Test Cover";

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

    @Test
    public void testGetCovers(){
        String answer = restTemplate.getForObject("/covers", String.class);
        Assert.assertEquals(answer, EXPECTED);
    }

}