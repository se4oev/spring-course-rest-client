package ru.se4oev.spring.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.se4oev.spring.rest.entity.Employee;

import java.util.List;

/**
 * Created by se4oev on 08.03.2022
 * Description:
 */
@Component
public class Communication {

    private final RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {}
        );

        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {

        Employee employee = restTemplate.getForObject(
                URL + "/" + id,
                Employee.class
                );

        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();

        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                    URL,
                    employee,
                    String.class
            );
            System.out.println("New emp was added to database");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id + " + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id " + id + " was deleted from db");
    }

}
