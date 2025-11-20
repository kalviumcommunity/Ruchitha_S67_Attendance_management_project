package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;

    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // REGISTER METHODS
    public Student registerStudent(String name, String gradeLevel) {
        Student s = new Student(name, gradeLevel);
        students.add(s);
        return s;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher t = new Teacher(name, subject);
        teachers.add(t);
        return t;
    }

    public Staff registerStaff(String name, String role) {
        Staff st = new Staff(name, role);
        staffMembers.add(st);
        return st;
    }

    public Course createCourse(String courseName, int capacity) {
        Course c = new Course(courseName, capacity);
        courses.add(c);
        return c;
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);

        if (success) {
            System.out.println("Enrolled " + student.getName() + " in " + course.getCourseName());
        } else {
            System.out.println("Failed to enroll " + student.getName() +
                            " — course full (" + course.getCapacity() + " max)");
        }

        return success;
    }

    // GETTERS
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // LOOKUPS
    public Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream().filter(c -> c.getCourseId() == id).findFirst().orElse(null);
    }

    // DIRECTORY
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    // SAVE ALL REGISTRATIONS
    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}
