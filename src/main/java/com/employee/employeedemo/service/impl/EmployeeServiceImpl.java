package com.employee.employeedemo.service.impl;

import com.employee.employeedemo.model.Employee;
import com.employee.employeedemo.repository.EmployeeRepository;
import com.employee.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Employee updateEmployee(Employee employee,long id){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(RuntimeException::new);
        existingEmployee.setUserName(employee.getUserName());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id){
        employeeRepository.findById(id).orElseThrow(RuntimeException::new);
        employeeRepository.deleteById(id);
    }

}
