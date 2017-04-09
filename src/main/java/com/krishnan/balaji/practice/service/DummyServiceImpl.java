package com.krishnan.balaji.practice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.Dummy;
import com.krishnan.balaji.practice.repos.DummyRepository;

@Service
@Transactional("transactionManager")
public class DummyServiceImpl implements DummyService {

	@Autowired
	DummyRepository repo;

	@Override
	public Dummy create(Dummy dummy) {
		return repo.save(dummy);
	}

	@Override
	public Iterable<Dummy> get() {
		return repo.findAll();
	}

	@Override
	public Dummy get(long id) {
		return repo.findOne(id);
	}

	@Override
	public Dummy update(Dummy dummy) {
		return repo.save(dummy);
	}

	@Override
	public void delete(long id) {
		repo.delete(id);
	}
}