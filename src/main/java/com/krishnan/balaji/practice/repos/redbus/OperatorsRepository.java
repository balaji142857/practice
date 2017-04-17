package com.krishnan.balaji.practice.repos.redbus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krishnan.balaji.practice.model.a.BusOperator;

@Repository
public interface OperatorsRepository extends CrudRepository<BusOperator, Long>{

}
