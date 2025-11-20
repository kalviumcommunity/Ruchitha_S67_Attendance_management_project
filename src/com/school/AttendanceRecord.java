package com.school;

public class AttendanceRecord{
    private int studentId;
    private int courseId;
    private String status;

    // Constructor
    public AttendanceRecord(int studentId, int courseId, String status){
        this.studentId = studentId;
        this.courseId = courseId;

        if(status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else{
            System.out.println("Warning: Invalid status '" + status + "'. Setting status to Invalid'.");
            this.status = "Invalid";
        }
    }

    // Getters
    public int getStudentId(){
        return studentId;
    }
    public int getCourseId(){
        return courseId;
    }
    public String getStatus(){
        return status;
    }

    // Display
    public void displayRecord(){
        System.out.println("Attendance Record -> Student ID: " + studentId + ", Course ID: C" + courseId + ", Status: " + status);
    }
}