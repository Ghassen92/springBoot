package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        Employee e = new Employee(null, "alex");
        Mockito.when(employeeRepository.findByName(e.getName()))
                .thenReturn(e);
    }


    @Test
    void getEmployeeByName() {
        String name = "alex";
        //When
        Employee found = employeeService.getEmployeeByName("alex");
        //Then
        assertNotNull(found);
        assertEquals(found.getName(), name);
    }
}