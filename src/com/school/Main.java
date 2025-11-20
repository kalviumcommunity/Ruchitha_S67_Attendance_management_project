package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        // Attendance Log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid attendance
        AttendanceRecord a1 = new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present");
        AttendanceRecord a2 = new AttendanceRecord(s2.getStudentId(), c2.getCourseId(), "Absent");

        // Invalid attendance status
        AttendanceRecord a3 = new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late"); // triggers warning

        attendanceLog.add(a1);
        attendanceLog.add(a2);
        attendanceLog.add(a3);

        // Display all attendance
        System.out.println("=== Attendance Log ===");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }
}