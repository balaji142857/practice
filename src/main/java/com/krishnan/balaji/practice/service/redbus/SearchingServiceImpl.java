package com.krishnan.balaji.practice.service.redbus;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("transactionManager")
public class SearchingServiceImpl implements SearchingService{

}
