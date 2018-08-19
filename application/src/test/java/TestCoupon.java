import com.miri.AdminController;
import com.miri.Company;
import com.miri.CouponApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertNotNull;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CouponApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCoupon {

    StringBuilder compName = new StringBuilder();

    @LocalServerPort
    private int port;

    @Autowired
    private AdminController adminController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testContextLoads() throws Exception {
        assertNotNull(adminController);
    }

    @Test
    public void testAddNewCompany() throws Exception {

        Company newCompany = new Company();
        newCompany.setCompName("company_" + generateRandomExtention(compName));
        newCompany.setEmail("test@email.com");
        newCompany.setPassword("testPass111");

        assertThat(this.restTemplate.postForObject(
                "http://localhost:" + port + "/rest/api/" + "createcompany",
                newCompany,
                String.class))
                .contains(newCompany.getCompName());
    }

    @Test
    public void testGetAllCompanies() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/rest/api/" + "getallcompanies",
                String.class))
                .isNotEmpty();
    }

    private String generateRandomExtention(StringBuilder compName) {
        String NUMBERS = "1234567890";
        Random rnd = new Random();
        while (compName.length() < 4) {                                // length of the random string
            int index = (int)(rnd.nextFloat() * NUMBERS.length());
            char nextDigit = NUMBERS.charAt(index);                     // select char at random index in NUMBERS
            if (compName.indexOf(String.valueOf(nextDigit)) == -1)     // if digit not used yet
                compName.append(nextDigit);
        }
        return compName.toString();
    }

}
