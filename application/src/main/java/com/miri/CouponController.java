package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class CouponController {

//    @Autowired
//    private CustomerFacade customerServices;

//    @Autowired
//    private CompanyFacade companyService;

    @Autowired
    private AdminFacade adminService;

    //==  Customer endpoints  ==//

//    @GetMapping("/getcustomer/{id}")
//    public Customer getCustomer(@PathVariable("id") Long id) {
//        return customerServices.getCustomer(id);
//    }
//
//    @GetMapping("/getallcustomers")
//    public Collection<Customer> getCustomer() {
//        return customerServices.getAllCustomers();
//    }

    //==  Company endpoints  ==//

//    @PutMapping("/createcompany")
//    public void createCompany(@RequestBody Company company) {
//        companyService.createCompany(company);
//    }
//
//    @DeleteMapping("/deletecompany")
//    public void removeCompany(@RequestBody Company company) {
//        companyService.removeCompany(company);
//    }
//
//    @PostMapping("/updatecompany")
//    public void updateCompany(@RequestBody Company company) {
//        companyService.updateCompany(company);
//    }
//
//    @GetMapping("/getcompany/{id}")
//    public Company getCompany(@PathVariable("id") Long id) {
//        return companyService.getCompany(id);
//    }

    @GetMapping("/getallcompanies")
    public Collection<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }


    //==  Coupon endpoints  ==//

}
