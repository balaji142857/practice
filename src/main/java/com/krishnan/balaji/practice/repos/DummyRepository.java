package com.krishnan.balaji.practice.repos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.Dummy;

@Repository
public interface DummyRepository extends CrudRepository<Dummy, Serializable>{

}
