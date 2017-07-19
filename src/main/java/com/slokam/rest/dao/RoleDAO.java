package com.slokam.rest.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.slokam.rest.pojo.Role_M;

public interface RoleDAO  extends CrudRepository<Role_M, Integer>,JpaSpecificationExecutor<Role_M>{
  
}
