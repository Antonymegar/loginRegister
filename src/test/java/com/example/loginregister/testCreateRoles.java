package com.example.loginregister;

import com.example.loginregister.model.Role;
import com.example.loginregister.Repositories.RoleRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class testCreateRoles {

    @Autowired
    private RoleRepository repo;


    @Test
    public void testCreateRoles() {
        Role employee = new Role("Employee");
        Role admin = new Role("Admin");
        Role officer = new Role("Officer");

        repo.saveAll(List.of(employee, admin, officer));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }
}
