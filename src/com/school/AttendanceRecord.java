package com.school;

public class AttendanceRecord implements Storable {
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

    // Display
    public void displayRecord(){
        System.out.println("Attendance Record -> Student ID: " + studentId + ", Course ID: C" + courseId + ", Status: " + status);
    }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}