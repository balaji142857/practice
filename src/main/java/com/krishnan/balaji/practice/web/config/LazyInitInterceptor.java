package com.krishnan.balaji.practice.web.config;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//@Component
public class LazyInitInterceptor extends HandlerInterceptorAdapter {

	public LazyInitInterceptor() {
		System.out.println("LazyInitInterceptor constructed");
	}
	@Autowired
	SessionFactory factory;
	@Autowired
	EntityManagerFactory emfFactory;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("lazyInitInterceptor:afterCompletion: Closing after completion");
		Session session = factory.getCurrentSession();
		if(null != session && session.isOpen()){
			Transaction tx = session.getTransaction();
			if(tx.isActive()){
				tx.commit();
				session.close();
				throw new RuntimeException("Transaction shoule have been commited earlier");
			}
		}
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("prehandle");
		System.out.println("sessionFactory is "+factory +",emfFactory is "+emfFactory);
		/*ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();
		/* EntityManager em = threadLocal.get();
	        if (em == null) {
	            em = emfFactory.createEntityManager();
	            threadLocal.set(em);
	            System.out.println("em set in threadLocal");
	        }
	        */
		ThreadLocal<Session> threadLocal = new ThreadLocal<>();
		 Session session = threadLocal.get();
	        if (session == null) {
	        	session = factory.openSession();
	            threadLocal.set(session);
	            System.out.println("session set in threadLocal");
	        }
	        
		//ThreadLocal<EntityManager> tl =ThreadLocal.withInitial(emfFactory::createEntityManager);
		System.out.println("ThreadLocal created" + threadLocal);
		Session session1 = threadLocal.get();
		System.out.println("from threadLocal (session2Emgr)  : "+session1);
		return true	;
	}
}