package com.example.loginregister.Service;

import com.example.loginregister.Repositories.EmployeeRepository;
import com.example.loginregister.Repositories.RoleRepository;
import com.example.loginregister.model.Employee;
import com.example.loginregister.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository eRepo;
    @Autowired
    private RoleRepository roleRepo;

    public void saveEmployee(Employee employee){

     eRepo.save(employee);
    }

    public List<Role> listRoles(){

        return roleRepo.findAll();
    }
    public void saveRole(Role role){

        roleRepo.save(role);
    }



}
