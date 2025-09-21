package com.oguzkaganbilici.services;

import com.oguzkaganbilici.model.Employee;
import com.oguzkaganbilici.model.UpdateEmpRequest;
import com.oguzkaganbilici.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired // repo'ya baglandik
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeByID(String ID){
        return employeeRepository.getEmployeeByID(ID);
    }

    public List<Employee> getEmployeeBySurname(String surname){
        return employeeRepository.getEmployeeBySurname(surname);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee emp){
        return employeeRepository.saveEmployee(emp);
    }

    public boolean deleteEmployee(String id){
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updatedEmployee(String id, UpdateEmpRequest uptEmp){
        return employeeRepository.updatedEmployee(id, uptEmp);
    }
}
