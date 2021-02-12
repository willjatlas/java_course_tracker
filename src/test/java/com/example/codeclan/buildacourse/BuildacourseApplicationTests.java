package com.example.codeclan.buildacourse;

import com.example.codeclan.buildacourse.models.Booking;
import com.example.codeclan.buildacourse.models.Course;
import com.example.codeclan.buildacourse.models.Customer;
import com.example.codeclan.buildacourse.models.RatingType;
import com.example.codeclan.buildacourse.repositories.BookingRepository;
import com.example.codeclan.buildacourse.repositories.CourseRepository;
import com.example.codeclan.buildacourse.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BuildacourseApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddThroughRepository(){
		Customer customer = new Customer("Cameron", "Edinburgh", 25);
		customerRepository.save(customer);

		Course course = new Course("PSD", "Edinburgh", RatingType.FIVE);
		courseRepository.save(course);

		Booking booking = new Booking("28-02-21", customer, course);
		bookingRepository.save(booking);
	}

	@Test
	public void canFindCustomerByTownAndCourseName(){
		Customer customer = new Customer("Cameron", "Edinburgh", 25);
		customerRepository.save(customer);

		Course course = new Course("PSD", "Edinburgh", RatingType.FIVE);
		courseRepository.save(course);

		Booking booking = new Booking("28-02-21", customer, course);
		bookingRepository.save(booking);

		List<Customer> result = customerRepository.findCustomersByTownAndBookingsCourseName("Edinburgh", "PSD");
		System.out.println(result);
		assertEquals("Cameron", result.get(0).getName());
	}

}
