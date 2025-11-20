package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // 1. First overloaded method (direct objects)
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // 2. Overloaded method (IDs + lookup)
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {

        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student != null && course != null) {
            markAttendance(student, course, status); // reuse method #1
        } else {
            System.out.println("Error: Could not find Student or Course for attendance marking.");
        }
    }

    // Helper: find student
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Helper: find course
    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // Display all records
    public void displayAttendanceLog() {
        System.out.println("=== FULL ATTENDANCE LOG ===");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    // Display for a specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("=== ATTENDANCE FOR STUDENT: " + student.getName() + " ===");
        attendanceLog.stream()
            .filter(r -> r.getStudent().getId() == student.getId())
            .forEach(AttendanceRecord::displayRecord);
    }

    // Display for a specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("=== ATTENDANCE FOR COURSE: " + course.getCourseName() + " ===");
        attendanceLog.stream()
            .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
            .forEach(AttendanceRecord::displayRecord);
    }

    // Save to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
