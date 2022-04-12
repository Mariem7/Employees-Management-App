package cimf.BackendEmployeeManagement.Repository;

import cimf.BackendEmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //we pass optional because we don't know if we actually will find the employee or not
    Optional<Employee> findEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
