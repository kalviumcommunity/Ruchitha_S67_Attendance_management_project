package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        // Student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Grade 10"));
        students.add(new Student("Bob", "Grade 9"));

        // Courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Science"));

        // Attendance
        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(1).getCourseId(), "Late")); // invalid

        // Save to files
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");
    }
}