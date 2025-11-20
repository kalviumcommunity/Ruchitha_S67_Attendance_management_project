package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main{
    // POLYMORPHISM DEMO
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("=== School Directory ===");
        for (Person p : people) {
            p.displayDetails();    // runtime polymorphism
        }
    }
    public static void main(String[] args) {
        
        // Create Student, Teacher, Staff
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 9");

        Teacher t1 = new Teacher("Mr. Sharma", "Mathematics");
        Staff st1 = new Staff("Ravi", "Lab Assistant");

        // Polymorphic list
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(t1);
        schoolPeople.add(st1);

        // Display polymorphism
        displaySchoolDirectory(schoolPeople);

        // Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        // Attendance Records
        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1, c1, "Present"));
        records.add(new AttendanceRecord(s2, c2, "Absent"));
        records.add(new AttendanceRecord(s1, c2, "Late"));   // invalid → becomes "Invalid"

        System.out.println("=== Attendance Log ===");
        for (AttendanceRecord rec : records) {
            rec.displayRecord();
        }

        // STORAGE SERVICE
        FileStorageService storage = new FileStorageService();

        // Filter students from schoolPeople using instanceof
        List<Student> studentsToSave = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentsToSave.add((Student) p);
            }
        }

        // Save to files
        storage.saveData(studentsToSave, "students.txt");

        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);
        storage.saveData(courseList, "courses.txt");

        storage.saveData(records, "attendance_log.txt");
    }
}