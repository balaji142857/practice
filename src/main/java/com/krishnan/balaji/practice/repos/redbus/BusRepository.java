package com.krishnan.balaji.practice.repos.redbus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.a.Bus;
import com.krishnan.balaji.practice.model.a.BusOperator;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long>{
	
	public Bus findByRegNumberAndOwningEntity(String regNumber,BusOperator owningEntity);

}
