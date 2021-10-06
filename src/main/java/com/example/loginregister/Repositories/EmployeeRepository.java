package com.example.loginregister.Repositories;

import com.example.loginregister.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    public  Employee findByEmail(String email);

}
