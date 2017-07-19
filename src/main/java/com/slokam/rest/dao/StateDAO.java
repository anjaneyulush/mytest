package com.slokam.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.slokam.rest.pojo.State_M;
@Repository
public interface StateDAO extends JpaRepository<State_M, Integer> , QueryDslPredicateExecutor<State_M>{
	
	public List<State_M> findByName(String name);
	
	@Query(" select s.name,s.id from State_M  s where s.name=?1")
	public List<Object[]> getStates(String name);
	
	@Query(" select s.name,s.id from State_M  s")
	public List<Object[]> getStates();
	
	@Query(" select s.name,s.id from State_M  s where s.id=?1")
	public List<Object[]> getStatesById(Integer id);
	
	@Query(" select c.name from State_M s join s.country c where s.name=?1 ")
	public List<String> getCountryNameByStateName(String stateName);
	
}
