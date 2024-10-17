package com.springbootsql.dao;

import com.springbootsql.model.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao extends JpaRepository<Employee, Long> {


}
