package com.school;

import java.util.List;

public class Main{
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("=== SCHOOL DIRECTORY ===");
        List<Person> people = regService.getAllPeople();
        for (Person p : people) {
            p.displayDetails();
        }
    }
    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // REGISTER PEOPLE
        Student s1 = regService.registerStudent("Alice", "Grade 10");
        Student s2 = regService.registerStudent("Bob", "Grade 9");

        Teacher t1 = regService.registerTeacher("Mr. Sharma", "Mathematics");
        Staff st1 = regService.registerStaff("Ravi", "Lab Assistant");

        // COURSES
        Course c1 = regService.createCourse("Mathematics");
        Course c2 = regService.createCourse("Science");

        // DISPLAY DIRECTORY
        displaySchoolDirectory(regService);

        // MARK ATTENDANCE (IDs only)
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Absent");
        attendanceService.markAttendance(s1.getId(), c2.getCourseId(), "Late");

        // DISPLAY ATTENDANCE
        attendanceService.displayAttendanceLog();

        // SAVE EVERYTHING
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("Data saved successfully.");
    }
}