package question.example.comparable;

import java.util.ArrayList;
import java.util.List;

class Employee implements Comparable {
    String name;
    int age;
    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        List<Employee> employee=new ArrayList<Employee>();
        employee.add(new Employee(24,"Amit"));
        employee.add(new Employee(42,"Akash"));
        employee.add(new Employee(14,"Mintu"));
        employee.add(new Employee(43,"Kabir"));
        //Collections.sort(employee,comparator);
    }

}
