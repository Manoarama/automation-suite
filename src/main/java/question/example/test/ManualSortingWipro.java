package question.example.test;

class Student {
    String name;
    int marks;
    int age;

    Student(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + marks + " " + age);
    }
}

public class ManualSortingWipro {

    // 1️⃣ Sort by Age (Ascending)
    static void sortByAge(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].age > students[j].age) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // 2️⃣ Sort by Marks (Descending)
    static void sortByMarks(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].marks < students[j].marks) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // 3️⃣ Marks Between 80 and 95
    static void printMarksBetween(Student[] students) {
        for (Student s : students) {
            if (s.marks >= 80 && s.marks <= 95) {
                s.display();
            }
        }
    }

    // 4️⃣ Sort Names Lexicographically
    static void sortNamesLexicographically(Student[] students) {
        String[] names = new String[students.length];

        for (int i = 0; i < students.length; i++) {
            names[i] = students[i].name;
        }

        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.println("\nNames in Lexicographical Order:");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

        Student[] students = {
                new Student("Ram", 98, 21),
                new Student("Shyam", 91, 18),
                new Student("Kabir", 99, 23)
        };

        // Sort by Age
        sortByAge(students);
        System.out.println("Sorted by Age (Ascending):");
        for (Student s : students)
            s.display();

        // Sort by Marks
        sortByMarks(students);
        System.out.println("\nSorted by Marks (Descending):");
        for (Student s : students)
            s.display();

        // Marks between 80 and 95
        System.out.println("\nStudents with Marks between 80 and 95:");
        printMarksBetween(students);

        // Lexicographical order of names
        sortNamesLexicographically(students);
    }
}
