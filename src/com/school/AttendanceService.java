package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // 1. First overloaded method (direct objects)
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // 2. Overloaded method (IDs + lookup)
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student != null && course != null) {
            markAttendance(student, course, status); // reuse method #1
        } else {
            System.out.println("Error: Invalid student/course ID");
        }
    }

    // Helper: find student
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("=== ATTENDANCE LOG ===");
        attendanceLog.forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
