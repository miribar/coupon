package com.miri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController                               //For serving REST requests, all responses default format is JSON
@RequestMapping("/rest/api/")  		          //this creates the services main API endpoint
public class AdminController {

    @Autowired
    private CustomerFacade customerServices;

    @Autowired
    private CompanyFacade companyService;

    @Autowired
    private AdminFacade adminService;

    @Autowired
    private CouponTypeConverter couponTypeConverter;


//    @GetMapping("/getcustomer/{id}")
//    public Customer getCustomer(@PathVariable("id") Long id) {
//        return customerServices.getCustomer(id);
//    }

    @GetMapping("/getallcustomers")
    public Collection<Customer> getCustomer() {
        return adminService.getAllCustomers();
    }


    @PutMapping("/createcompany")
    public GeneralResponse createCompany(@RequestBody Company company) {
        //TODO: add company name input validation
        try {
            adminService.createCompany(company);
            return new GeneralResponse("Company added successfully!");
        } catch (Exception e) {
            return new GeneralResponse(e);
        }
    }

//    @DeleteMapping("/deletecompany/{id}")
//    public void removeCompany(@PathVariable("id") Long id) {
//        adminService.removeCompany(adminService.getCompany(id));
//    }

    @PostMapping("/updatecompany")
    public void updateCompany(@RequestBody Company company) {
        adminService.updateCompany(company);
    }

    @GetMapping("/getcompany/{id}")
    public Company getCompany(@PathVariable("id") Long id) {
        return adminService.getCompany(id);
    }

    @GetMapping("/getallcompanies")
    public Collection<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @PostMapping("/createcustomer")
    public void createCustomer(@RequestBody Customer customer) {
        adminService.createCustomer(customer);
    }

}
