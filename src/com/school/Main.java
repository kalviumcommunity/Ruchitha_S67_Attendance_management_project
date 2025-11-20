package com.school;

public class Main{

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("=== SCHOOL DIRECTORY ===");
        for (Person p : regService.getAllPeople()) {
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
        Student s3 = regService.registerStudent("Charlie", "Grade 8");

        // Register staff & teacher
        Teacher t1 = regService.registerTeacher("Mr. Sharma", "Mathematics");
        Staff st1 = regService.registerStaff("Ravi", "Lab Assistant");

        // Create courses with capacity
        Course c1 = regService.createCourse("Maths", 2);
        Course c2 = regService.createCourse("Science", 1);

        // DISPLAY DIRECTORY
        displaySchoolDirectory(regService);

        // Enrollment attempts (with capacity check)
        regService.enrollStudentInCourse(s1, c1);   // OK
        regService.enrollStudentInCourse(s2, c1);   // OK
        regService.enrollStudentInCourse(s3, c1);   // FAIL (capacity = 2)

        regService.enrollStudentInCourse(s1, c2);   // OK
        regService.enrollStudentInCourse(s2, c2);   // FAIL (capacity = 1)

        // Display course info
        System.out.println("=== COURSE STATUS ===");
        c1.displayDetails();
        c2.displayDetails();

        // Attendance taking (optional check could be added)
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent");

        // Display attendance
        attendanceService.displayAttendanceLog();

        // Save all data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("All data saved. Project completed!");
    }
}