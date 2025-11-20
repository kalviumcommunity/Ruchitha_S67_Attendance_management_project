package com.school;

public class Student extends Person{
    private String gradeLevel;

    // Constructor
    public Student(String name, String gradeLevel){
        super(name);
        this.gradeLevel = gradeLevel;
    }

    // Method to display details
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Student");
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("----------------------");
    }
}