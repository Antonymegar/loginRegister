package com.example.loginregister;

import com.example.loginregister.Repositories.EmployeeRepository;
import com.example.loginregister.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class testCreateEmployee {
    @Autowired
    private TestEntityManager entitymanager;
    @Autowired
    private EmployeeRepository Repo;

    @Test
    public void createEmployeetest() {
        Employee employee = new Employee();
        employee.setFullname("Deneiro");
        employee.setUsername("Ofcourse");
        employee.setEmail("Ofcourse@gmail.com");
        employee.setGender("Male");
        employee.setPhone("07986543");
        employee.setPassword("idontknowyou");

        Employee savedEmployee = Repo.save(employee);
        Employee existEmployee = entitymanager.find(Employee.class, savedEmployee.getId());
        assertThat(employee.getEmail()).isEqualTo(existEmployee.getEmail());
    }

}
