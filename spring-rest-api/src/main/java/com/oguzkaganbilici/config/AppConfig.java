package com.oguzkaganbilici.config;


import com.oguzkaganbilici.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration // dummy veri için
public class AppConfig {

    @Bean // bir bean'dir. veriler kaybolmasin diye.
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Oğuz Kağan", "Bilici"));
        employeeList.add(new Employee("2", "Adnan", "Bilici"));
        employeeList.add(new Employee("3", "Selda", "Bilici"));
        employeeList.add(new Employee("4", "Sila", "Bilici"));
        employeeList.add(new Employee("5", "NewPerson", "Bilici"));
        return employeeList;
    }
}
