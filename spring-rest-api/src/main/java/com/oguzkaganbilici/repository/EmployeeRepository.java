package com.oguzkaganbilici.repository;

import com.oguzkaganbilici.model.Employee;
import com.oguzkaganbilici.model.UpdateEmpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired // olusturdugumuz dummy verilere enjecte etti. veri tabani olsa ona edecekti. @Configuration  sayesinde
    private List<Employee> employeeList;



    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeByID(String ID){
        Employee thePerson = null;
        for(Employee emp: employeeList){
            if(ID.equals(emp.getID())){
                thePerson = emp;
                break;
            }
        }
        return thePerson;
    }

    public List<Employee> getEmployeeBySurname(String surname){
        List<Employee> thePersons = new ArrayList<>();
        for(Employee emp: employeeList){
            if(emp.getLastName().contains(surname)){
                thePersons.add(emp);
            }
        }
        if(thePersons.isEmpty())
        {
            System.out.println("There is not any person with " + surname);
            return null;
        }
        else{
            return thePersons;
        }
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        if(firstName == null && lastName == null) return employeeList;

        List<Employee> employees = new ArrayList<>();
        if(firstName != null && lastName != null){

            for(Employee emp: employeeList){
                if(emp.getFirstName().equalsIgnoreCase(firstName) && emp.getLastName().equalsIgnoreCase(lastName)){
                    employees.add(emp);
                }
            }
            return employees;
        }

        else if(firstName != null){
            for(Employee emp: employeeList){
                if(emp.getFirstName().equalsIgnoreCase(firstName)){
                    employees.add(emp);
                }
            }
        }

        else{
            for(Employee emp: employeeList){
                if(emp.getLastName().equalsIgnoreCase(lastName)){
                    employees.add(emp);
                }
            }
        }

        return employees;
    }

    public Employee saveEmployee(Employee newEmp){
        employeeList.add(newEmp);
        return newEmp;
    }

    public boolean deleteEmployee(String id){
        Employee thePerson = null;
        for(Employee emp: employeeList){
            if(emp.getID().equals(id)){
                thePerson = emp;
                break;
            }
        }
        if(thePerson != null){
            employeeList.remove(thePerson);
            return true;
        }
        return false;
    }


    public Employee updatedEmployee(String id, UpdateEmpRequest uptEmp){

        Employee findEmp = getEmployeeByID(id);
        // once güncellemek istedigimizi bulup siliyoruz.
        if(findEmp != null){
            deleteEmployee(id);
            Employee updatedEmp = new Employee(id, uptEmp.getFirstName(), uptEmp.getLastName()); // sonra yeniden ekliyoruz.
            employeeList.add(updatedEmp);
            return updatedEmp;
        }
        return null;
    }
}
