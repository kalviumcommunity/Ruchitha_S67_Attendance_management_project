package com.school;

public class Student{
    private static int nextStudentIdCounter = 1;
    int studentId;
    String name;

    // Constructor
    public Student(String name){
        this.studentId = nextStudentIdCounter++; 
        this.name = name;
    }

    // Getters
    public int getStudentId(){
        return studentId;
    }
    public String getName(){
        return name;
    }

    // Method to display details
    public void displayDetails(){
        System.out.println("Student ID: "+studentId);
        System.out.println("Student Name: "+name);
        System.out.println("----------------------");
    }
}