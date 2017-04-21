package com.krishnan.balaji.practice.repos.redbus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.a.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

}
