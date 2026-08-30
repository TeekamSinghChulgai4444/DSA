package comparable;

import java.util.*;

public class customComparable {

    static class Student implements Comparable<Student> {

        String name;
        int roll;
        int cgpa;

        public Student(String name, int roll, int cgpa) {
            this.name = name;
            this.cgpa = cgpa;
            this.roll = roll;
        }

        @Override
        public int compareTo(Student s) {

            int nameCompare = this.name.compareTo(s.name);
            if (nameCompare != 0) return nameCompare;

            int cgpaCompare = Integer.compare(s.cgpa, this.cgpa);
            if (cgpaCompare != 0) return cgpaCompare;

            return Integer.compare(this.roll, s.roll);
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Aman", 3, 85));
        list.add(new Student("Ravi", 1, 91));
        list.add(new Student("Aman", 2, 90));
        list.add(new Student("Ravi", 5, 91));
        list.add(new Student("Bunty", 4, 80));

        // Sort using Comparable
        Collections.sort(list);

        // Print result
        for (Student s : list) {
            System.out.println(s.name + " " + s.cgpa + " " + s.roll);
        }
    }
}