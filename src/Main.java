import com.workintech.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1, "Sevval", "Yurtseven"));
        employeeList.add(new Employee(1, "Sevval", "Yurtseven"));
        employeeList.add(new Employee(2, "Ozge", "Dogru"));
        employeeList.add(new Employee(2, "Ozge", "Dogru"));
        employeeList.add(new Employee(3, "Ebru", "Nilufer"));
        employeeList.add(new Employee(3, "Ebru", "Nilufer"));
        employeeList.add(new Employee(4, "Elif", "Bilge"));
        employeeList.add(new Employee(5, "Sibel", "Keskin"));

        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> removedEmployees = new ArrayList<>();

        Iterator<Employee> iterator = employeeList.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(checkEmployeeIsNull(employee)) continue;
            if(employeeMap.containsKey(employee.getId())){
                removedEmployees.add(employee);
                iterator.remove();
            }else{
                employeeMap.put(employee.getId(), employee);
            }
        }
        System.out.println("Mevcut: ");
        System.out.println(employeeList);
        System.out.println("Tekiller: ");
        System.out.println(employeeMap);
        System.out.println("Silinenler: ");
        System.out.println(removedEmployees);


    }
    private static boolean checkEmployeeIsNull(Employee employee){
        if(employee == null){
            System.out.println("Null data bulundu.");
            return true;
        }
        return false;
    }
}