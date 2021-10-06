package com.example.loginregister;

import com.example.loginregister.Repositories.EmployeeRepository;
import com.example.loginregister.Repositories.RoleRepository;
import com.example.loginregister.model.Employee;
import com.example.loginregister.model.Role;
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
    @Autowired
    private RoleRepository RoleRepo;

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
    @Test
    public void addRoleToEmployee(){
        Role roleAdmin = RoleRepo.findByName("Admin");

        Employee employee = new Employee();
        employee.setFullname("MayBach");
        employee.setUsername("MayBachsic");
        employee.setEmail("maybache@gmail.com");
        employee.setGender("Male");
        employee.setPhone("0765432156");
        employee.setPassword("welcome");
        employee.addRole(roleAdmin);

        Employee savedEmployee= Repo.save(employee);
        assertThat(savedEmployee.getRoles().size()).isEqualTo(1);

    }

}
