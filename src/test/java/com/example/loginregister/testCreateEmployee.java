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
        Role roleAdmin = RoleRepo.findByName("Employee");

        Employee employee = new Employee();
        employee.setFullname("Andrew ");
        employee.setUsername("Andrew kibe");
        employee.setEmail("Andrew@gmail.com");
        employee.setGender("Male");
        employee.setPhone("07567987");
        employee.setPassword("heretodevelop");
        employee.addRole(roleAdmin);

        Employee savedEmployee= Repo.save(employee);
        assertThat(savedEmployee.getRoles().size()).isEqualTo(1);

    }
    @Test
    public void testAddRoleToExistingUser() {
        Employee employee= Repo.findById(1).get();
        Role roleEmployee= RoleRepo.findByName("Officer");
        Role roleStaff= RoleRepo.findByName("Employee");
        employee.addRole(roleStaff);
        employee.addRole(roleEmployee);

        Employee savedEmployee = Repo.save(employee);
        assertThat(((Employee) savedEmployee).getRoles().size()).isEqualTo(2);
    }

}
