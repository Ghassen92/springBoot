package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findByName() {
        //given
        Employee e=new Employee(null,"alex");
        entityManager.persist(e);
        entityManager.flush();

        //when
        Employee found= employeeRepository.findByName("alex");

        //then
        assertEquals(e,found);
    }
}