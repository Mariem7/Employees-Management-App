package cimf.BackendEmployeeManagement.service;

import cimf.BackendEmployeeManagement.Repository.EmployeeRepository;
import cimf.BackendEmployeeManagement.exception.UserNotFoundException;
import cimf.BackendEmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //add employee method
    public Employee addEmployee(Employee employee){
        //we are going to generate the employee's code
        employee.setEmployeeCOde(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    //return list of employee
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    //update the employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    //delete employee
    public void deleteEmployee(Long id){

        employeeRepository.deleteEmployeeById(id);
    }
}
