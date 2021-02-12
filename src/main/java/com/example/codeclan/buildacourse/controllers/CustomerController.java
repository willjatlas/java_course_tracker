package com.example.codeclan.buildacourse.controllers;

import com.example.codeclan.buildacourse.models.Customer;
import com.example.codeclan.buildacourse.repositories.BookingRepository;
import com.example.codeclan.buildacourse.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomerIndex(
            @RequestParam(name = "course", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ){
        if ( age != null && town != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findCustomersByAgeGreaterThanAndTownAndBookingsCourseName(age,
                    town, courseName), HttpStatus.OK);
        }
        if ( courseName != null && town != null){
            return new ResponseEntity<>(customerRepository.findCustomersByTownAndBookingsCourseName(town,
                    courseName), HttpStatus.OK);

        } if ( courseName != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
