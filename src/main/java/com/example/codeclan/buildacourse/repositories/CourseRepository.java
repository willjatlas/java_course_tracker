package com.example.codeclan.buildacourse.repositories;

import com.example.codeclan.buildacourse.models.Course;
import com.example.codeclan.buildacourse.models.RatingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(RatingType rating);
    List<Course> findByBookingsCustomerNameIgnoreCase(String customerName);

}
