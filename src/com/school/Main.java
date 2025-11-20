package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 9");

        Teacher t1 = new Teacher("Mr. Sharma", "Mathematics");
        Staff st1 = new Staff("Ravi", "Lab Assistant");

        // Display details
        System.out.println("=== Person Hierarchy Details ===");
        s1.displayDetails();
        s2.displayDetails();
        t1.displayDetails();
        st1.displayDetails();

        // Attendance Logging
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid attendance
        AttendanceRecord a1 = new AttendanceRecord(s1.getId(), 101, "Present");
        AttendanceRecord a2 = new AttendanceRecord(s2.getId(), 102, "Absent");
        AttendanceRecord a3 = new AttendanceRecord(s1.getId(), 102, "Late");  //invalid

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