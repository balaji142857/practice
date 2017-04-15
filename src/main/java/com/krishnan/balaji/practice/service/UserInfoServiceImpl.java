package com.krishnan.balaji.practice.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krishnan.balaji.practice.model.User;
import com.krishnan.balaji.practice.repos.UserRepository;

@Service
@Transactional("transactionManager")
public class UserInfoServiceImpl implements UserInfoService {

	 @PersistenceContext
	 EntityManager entityManager;
	
	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	public UserInfoServiceImpl(){
		log.debug("constructing custom userdetailsService");
	}
	
	@Autowired
	UserRepository repo;

	@Override
	public User create(User user) {
		return repo.save(user);
	}

	@Override
	public User getById(long id) {
		return repo.findOne(id);
	}

	@Override
	public User getByName(String username) {
		return repo.getByUsername(username);
	}

	@Override
	public User getByEmail(String email) {
		return repo.getByEmail(email);
	}

	@Override
	public Set<User> get() {
		Iterable<User> temp = repo.findAll();
		Set<User> user = new LinkedHashSet<User>();
		if (temp != null)
			temp.forEach(user::add);
		return user;
	}

	@Override
	public User update(User user) {
		repo.save(user);
		return user;
	}

	@Override
	public void delete(long id) {
		repo.delete(id);
	}

	@Override
	public void deleteByName(String name) {
	}

	@Override
	public void deleteByEmail(String email) {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("loadUserByUsername is called");
		UserDetails ud = repo.getByUsername(username);
		log.debug("Userdetails obtained from repository: "+ud);
		if (null == ud)
			throw new UsernameNotFoundException(username + " not found.");
		if(null!= ud.getAuthorities()){
			for(GrantedAuthority auth: ud.getAuthorities()){
				log.debug(auth.getAuthority()+" is in authority");
				}
		}
		else
			log.debug("authorities for user "+ud +"is null");
				
			
		return ud;
	}

	private void printUserProperties(User editedUser) {
		if(editedUser !=null){
			log.debug("editedUser.getCreatedBy() " + editedUser.getCreatedBy());
			log.debug("editedUser.getEmail() " + editedUser.getEmail());
			log.debug("editedUser.getFirstName( )" + editedUser.getFirstName());
			log.debug("editedUser.getLastName() " + editedUser.getLastName());
			log.debug("editedUser.getPassword() " + editedUser.getPassword());
			log.debug("editedUser.getUpdatedBy() " + editedUser.getUpdatedBy());
			log.debug("editedUser.getUsername() " + editedUser.getUsername());
			log.debug("editedUser.getId() " + editedUser.getId());
			log.debug("editedUser.getVersion() " + editedUser.getVersion());
			log.debug("editedUser.getCreatedOn " + editedUser.getCreatedOn());
			log.debug("editedUser.getUpdatedOn() " + editedUser.getUpdatedOn());
			if(editedUser.getAuthorities()== null)
				log.debug("use has no authorities");
			else{
				for(GrantedAuthority auth: editedUser.getAuthorities())
					log.debug(auth.getAuthority()+" is in authority");
			}
		}
		else log.debug("editedUser is null");
	}
	
}
