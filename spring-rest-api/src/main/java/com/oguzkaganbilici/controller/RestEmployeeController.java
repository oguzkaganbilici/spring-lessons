package com.oguzkaganbilici.controller;

import com.oguzkaganbilici.model.Employee;
import com.oguzkaganbilici.model.UpdateEmpRequest;
import com.oguzkaganbilici.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee") // bütün methodların ortak kökü' gibi.. get methodunun devamı bundan sonra gelir..
public class RestEmployeeController {

    @Autowired // servive katmanina bagladık
    private EmployeeService employeeService;


    /*
    büyük projelerde tüm liste bu sekilde yazilmaz. params ile yazmak daha dogru olur

    @GetMapping(path = "/list") // get methodu oldugu için bu annotation ekledik
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList(); // service katmanındaki methoda gider.;
    }
    */


    @GetMapping(path = "/list/id/{id}") // id ile cagirma da get methodu oldugu için yine bunu ekledik
    public Employee getEmployeeByID(@PathVariable(name = "id", required = true) String ID){ // PathVariable' ile spesifik bir deger cagirabiliriz
        return employeeService.getEmployeeByID(ID);
    }

    @GetMapping(path = "/list/surname/{surname}")
    public List<Employee> getEmployeeBySurname(@PathVariable(name = "surname", required = true) String surname){
        return employeeService.getEmployeeBySurname(surname);
    }

    @GetMapping(path = "/list")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstname", required = false) String firstName,
                                                @RequestParam(name = "lastname", required = false) String lastName){
// required false yaparak hic biri yazilmazsa tüm liste döner. herhangi biri yazilirsa o döner. bu repository'de ayarlanir.

        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping(path = "/save-employee") // yeni bir veri eklemek için
    public Employee saveEmployee(@RequestBody Employee newEmp){

        return employeeService.saveEmployee(newEmp);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updatedEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmpRequest uptEmp){
    // burada tek tek first and lastname vermektense yeni bir sınıf acip requestBody'e o class'i verdik
        return employeeService.updatedEmployee(id, uptEmp);
    }
}
