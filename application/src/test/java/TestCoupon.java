import com.miri.AdminController;
import com.miri.Company;
import com.miri.CouponApplication;
import com.miri.Customer;
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

    private StringBuilder randomStr = new StringBuilder();
    private Company newCompany = new Company();
    private Customer newCustomer = new Customer();

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

        newCompany.setCompName("company_" + generateRandomExtention(randomStr));
        newCompany.setEmail("test_" + generateRandomExtention(randomStr) + "@email.com");
        newCompany.setPassword(generateRandomExtention(randomStr));

        assertThat(this.restTemplate.postForObject(
                "http://localhost:" + port + "/rest/api/" + "createcompany",
                newCompany,
                String.class))
                .contains(newCompany.getCompName());
    }

    @Test
    public void testGetCompanyById() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/rest/api/" + "getcompany/" + newCompany.getId(),
                String.class))
                .contains(newCompany.getCompName());
    }

//    @Test
//    @Assumes("testAddNewCompany")
//    public void testGetAllCompanies() throws Exception {
//        assertThat(this.restTemplate.getForObject(
//                "http://localhost:" + port + "/rest/api/" + "getallcompanies",
//                String.class))
//                .isNotEmpty();
//    }



    @Test
    public void testAddNewCustomer() throws Exception {
        newCustomer.setCustName("customer_" + generateRandomExtention(randomStr));
        newCustomer.setPassword("testPass111");

        assertThat(this.restTemplate.postForObject(
                "http://localhost:" + port + "/rest/api/" + "createcustomer",
                newCustomer,
                String.class))
                .contains(newCustomer.getCustName());
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/rest/api/" + "getallcustomers",
                String.class))
                .isNotEmpty();
    }

    @Test
    public void testGetCustomerById() throws Exception {

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/rest/api/" + "getcustomer/" + newCustomer.getId(),
                String.class))
                .isNotEmpty();
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        newCustomer.setPassword("updatedPass");

        assertThat(this.restTemplate.postForObject(
                "http://localhost:" + port + "/rest/api/" + "updatecustomer",
                newCustomer,
                String.class))
                .contains(newCustomer.getPassword());
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