package question.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int age;
    public Student( int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString () {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Comparator<Student> comparator=new Comparator<Student>() {
            @Override
            public int compare(Student i, Student j) {
                if(i.age>j.age)
                return 1;
                else
                    return -1;
            }
        };
        List<Student> student=new ArrayList<Student>();
        student.add(new Student(24,"Amit"));
        student.add(new Student(42,"Akash"));
        student.add(new Student(14,"Mintu"));
        student.add(new Student(43,"Kabir"));
        Collections.sort(student,comparator);
        for(Student s:student){
            System.out.println(s);
        }

    }


}
