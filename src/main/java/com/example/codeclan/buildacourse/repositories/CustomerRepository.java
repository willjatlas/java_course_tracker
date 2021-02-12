package com.example.codeclan.buildacourse.repositories;

import com.example.codeclan.buildacourse.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String string);
    List<Customer> findCustomersByTownAndBookingsCourseName(String town, String courseName);
    List<Customer> findCustomersByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String courseName);
}
