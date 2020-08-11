package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.repository.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    @Override
    public void save( T entity ){
        entityManager.persist( entity );
     }

    public void delete( T entity ){
        entityManager.remove( entity );
     }

	@Override
	public void deleteById(Long id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( Long id ){
	    return (T) entityManager.find( daoType, id );
	 }
	

	@Override
	public List<T> findAll(){
		      return entityManager.createQuery( "from " + daoType.getName() )
		       .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager.merge( entity );
	   }


	

 }