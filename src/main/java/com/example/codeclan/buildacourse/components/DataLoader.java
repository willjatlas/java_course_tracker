package com.example.codeclan.buildacourse.components;

import com.example.codeclan.buildacourse.models.Booking;
import com.example.codeclan.buildacourse.models.Course;
import com.example.codeclan.buildacourse.models.Customer;
import com.example.codeclan.buildacourse.models.RatingType;
import com.example.codeclan.buildacourse.repositories.BookingRepository;
import com.example.codeclan.buildacourse.repositories.CourseRepository;
import com.example.codeclan.buildacourse.repositories.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Course course1 = new Course("Java Basics", "Stirling", RatingType.FOUR);
        courseRepository.save(course1);

        Course course2 = new Course("How To React", "Edinburgh", RatingType.ONE);
        courseRepository.save(course2);

        Course course3 = new Course("What Is CSS?!", "Glasgow", RatingType.THREE);
        courseRepository.save(course3);

        Course course4 = new Course("How To Backflip", "Drem", RatingType.FIVE);
        courseRepository.save(course4);

        Customer customer = new Customer("Cameron", "Edinburgh", 27);
        customerRepository.save(customer);

        Customer customer2 = new Customer("Bill", "Edinburgh", 28);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Osh", "Kirkcaldy", 27);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Wee Dave", "Stirling", 20);
        customerRepository.save(customer4);

        Booking booking = new Booking("01-03-2021", customer, course1);
        bookingRepository.save(booking);

        Booking booking2 = new Booking("01-03-2021", customer2, course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-03-2021", customer3, course1);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("05-03-2021", customer4, course4);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("03-03-2021", customer, course2);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("03-03-2021", customer3, course2);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("06-03-2021", customer3, course3);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("05-03-2021", customer3, course4);
        bookingRepository.save(booking);

        Booking booking9 = new Booking("01-03-2021", customer2, course3);
        bookingRepository.save(booking9);
    }
}