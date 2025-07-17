package org.src.challenges;

import org.src.dto.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagement {

    public static Employee findMaxSalariedEmployee(List<Employee> employees) {
        return employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    public static Set<String> findAllDepartments(List<Employee> employees) {
        return employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
    }

    public static Map<String, Long> findEmployeeCountsByDept(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public static Map<String, Optional<Employee>> findEmployeeWithMaxSalaryByDept(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
    }

    public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
    }

    public static List<Employee> sortEmployeesBySalaryDescending(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

    public static Long sumOfAllSalaries(List<Employee> employees) {
        return employees.stream().collect(Collectors.summingLong(Employee::getSalary));
    }

    public static Map<String, Long> sumOfAllSalariesPerDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)));
    }


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1, "John", "IT", 785135),
                new Employee(2, "Doe", "IT", 4457245),
                new Employee(3, "Max", "DevOps", 66434),
                new Employee(4, "Kimi", "DevOps", 674425),
                new Employee(5, "Yuki", "Dev", 9273532),
                new Employee(6, "George", "IT", 5743543),
                new Employee(7, "Zhou", "Dev", 45754624),
                new Employee(8, "Bottas", "DevOps", 34564564),
                new Employee(9, "Vettel", "Sales", 95626),
                new Employee(10, "Senna", "Sales", 45645245),
                new Employee(11, "Lando", "Dev", 272576),
                new Employee(12, "Hulkenberg", "IT", 45856746)
        ));

        System.out.println(findMaxSalariedEmployee(employees));
        System.out.println(findEmployeeWithMaxSalaryByDept(employees));
        System.out.println(findAllDepartments(employees));
        System.out.println(findEmployeeCountsByDept(employees));
        System.out.println(sortEmployeesBySalary(employees));
        System.out.println(sortEmployeesBySalaryDescending(employees));
        System.out.println(sumOfAllSalaries(employees));
        System.out.println(sumOfAllSalariesPerDepartment(employees));
    }
}
