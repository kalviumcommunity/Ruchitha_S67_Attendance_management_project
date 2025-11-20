package com.school;

public class Main{
    public static void main(String[] args) {
        
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");
        Student s4 = new Student("David");

        Student[] students = {s1, s2, s3, s4};

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");
        Course c3 = new Course("English");

        Course[] courses = {c1, c2, c3};

        System.out.println("=== Student Details ===");
        for(Student s : students){
            s.displayDetails();
        }

        System.out.println("=== Course Details ===");
        for(Course c : courses){
            c.displayDetails();
        }
    }
}