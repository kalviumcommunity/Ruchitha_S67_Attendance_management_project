package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    int courseId;
    String courseName;

    // Constructor
    public Course(String courseNmae){
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseNmae;
    }

    // Getters
    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }

    // Method to display details
    public void displayDetails(){
        System.out.println("Course ID: C"+courseId);
        System.out.println("Course Name: "+courseName);
        System.out.println("------------------------");
    }

    @Override
    public String toDataString(){
        return courseId + "," + courseName;
    }
}