import com.workintech.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Sevval", "Yurtseven"));
        employees.add(new Employee(1, "Sevval", "Yurtseven"));
        employees.add(new Employee(2, "Ozge", "Dogru"));
        employees.add(new Employee(2, "Ozge", "Dogru"));
        employees.add(new Employee(3, "Ebru", "Nilufer"));
        employees.add(new Employee(3, "Ebru", "Nilufer"));
        employees.add(new Employee(4, "Elif", "Bilge"));
        employees.add(new Employee(5, "Sibel", "Keskin"));

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Without Duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();

        for (Employee employee : employees) {
            if (checkEmployeeIsNull(employee)) continue;
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (checkEmployeeIsNull(employee)) continue;
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
       List<Employee> duplicates = findDuplicates(employees);
       Map<Integer, Employee> uniques = findUniques(employees);
       List<Employee> onlyUnique = new LinkedList<>(uniques.values());
       onlyUnique.removeAll(duplicates);
       return onlyUnique;
    }

    private static boolean checkEmployeeIsNull(Employee employee){
        if(employee == null){
            System.out.println("Null data bulundu.");
            return true;
        }
        return false;
    }

}