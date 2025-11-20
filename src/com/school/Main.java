package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        // Students
        List<Student> allStudents = new ArrayList<>();
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 9");
        allStudents.add(s1);
        allStudents.add(s2);

        // Courses
        List<Course> allCourses = new ArrayList<>();
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");
        allCourses.add(c1);
        allCourses.add(c2);

        // Services
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // MARK ATTENDANCE (different overloaded methods)
        attendanceService.markAttendance(s1, c1, "Present");        // method #1
        attendanceService.markAttendance(s2, c2, "Absent");         // method #1
        attendanceService.markAttendance(s1, c2, "Late");           // invalid
        attendanceService.markAttendance(
                s1.getId(), c1.getCourseId(), "Present",
                allStudents, allCourses
        ); // method #2 (IDs + lookup)

        // DISPLAY LOGS
        attendanceService.displayAttendanceLog();        // ALL records
        attendanceService.displayAttendanceLog(s1);      // For student
        attendanceService.displayAttendanceLog(c2);      // For course

        // SAVE attendance
        attendanceService.saveAttendanceData();

        System.out.println("Attendance data saved to attendance_log.txt");
    }
}