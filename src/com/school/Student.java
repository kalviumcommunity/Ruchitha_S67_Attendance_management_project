package com.school;

public class Student{
    int studentId;
    String name;

    // Method to set details
    public void setDetails(int studentId, String name){
        this.studentId = studentId;
        this.name = name;
    }

    // Method to display details
    public void displayDetails(){
        System.out.println("Student ID: "+studentId);
        System.out.println("Student Name: "+name);
        System.out.println("----------------------");
    }
}