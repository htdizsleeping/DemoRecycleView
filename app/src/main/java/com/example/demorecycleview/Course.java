package com.example.demorecycleview;

public class Course {
    private String courseCode;
    private String courseName;
    private String lecturerCode;
    private int courseImage;

    public Course(String courseCode, String courseName, String lecturerCode, int courseImage) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.lecturerCode = lecturerCode;
        this.courseImage = courseImage;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
