package com.krishnan.balaji.practice.repos.redbus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.a.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{

}
