package ru.se4oev.spring.rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.se4oev.spring.rest.configuration.MyConfig;
import ru.se4oev.spring.rest.entity.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> employees = communication.getAllEmployees();
//        employees.forEach(System.out::println);

//        Employee employee = communication.getEmployee(100);
//        System.out.println(employee);

//        Employee employee = new Employee("Sveta", "Sokolova", "IT", 1200);
//        employee.setId(17);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(18);

    }

}
