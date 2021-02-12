package com.example.codeclan.buildacourse.repositories;

import com.example.codeclan.buildacourse.models.Booking;
import com.example.codeclan.buildacourse.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);

}
