/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM102PSA2_GROUP12;

import java.time.format.DateTimeFormatter;
 
/**
*
* @author laurasweeney B00879054 and hallelapham B00878031
*/
 
//Declares instance variables to be held in array.
public class Student {
    private String name;
    private String DOB;
    private String gender;
    private String studyMode;
    private Integer yearGroup;
    private Integer numModules;
   
    ////"this." allows us to reference the objects within the class.
    public Student(String name, String DOB, String gender, String studyMode, Integer yearGroup, Integer numModules) {
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.studyMode = studyMode;
        this.yearGroup = yearGroup;
        this.numModules = numModules;
    }
        //Getters and setters are methods used in Java to access and modify the values of private variables in a class.
    //Getters return value of  private variables. setters set the value of a private variable.
        public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDOB() {
        return DOB;
    }
 
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    public String getStudyMode() {
        return studyMode;
    }
 
    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }
 
    public Integer getYearGroup() {
        return yearGroup;
    }
 
    public void setYearGroup(Integer yearGroup) {
        this.yearGroup = yearGroup;
    }
 
    public Integer getNumModules() {
        return numModules;
    }
 
    public void setNumModules(Integer numModules) {
        this.numModules = numModules;
    }
 
   
   // this code returns the inputted details from the user that is now stored within the array.
    public String displayStudentDetails() {
        DateTimeFormatter Formatter =DateTimeFormatter.ofPattern("dd/MM/yy");
        return "Student{" +
                "name: '" + name +
                ", DOB: " + DOB +
                ", gender: " + gender +
                ", studyMode: " + studyMode +
                ", yearGroup: " + yearGroup +
                ", numModules: " + numModules +
                '}';
    }
   
    public String toCSVRow() {
        return String.format("%s,%s,%s,%s,%d,%d\n", this.name, this.DOB, this.gender, this.studyMode, this.numModules, this.yearGroup);
    }
   
}