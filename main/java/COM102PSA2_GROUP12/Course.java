/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM102PSA2_GROUP12;

//Import used to allow an array list to be created.
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
 
/**
*
* @author laurasweeney B00879054 and hallelapham B00878031
*/
 
//declares the instance variables "Course name" and array list "Student Details".
public class Course {
    String courseName;
    ArrayList<Student> studentDetails;
 
    //
    public Course(String courseName){
        //"this." allows us to reference the objects within the class. eg "This.coursename" and "this.studentDetails".
        this.courseName=courseName;
        this.studentDetails= new ArrayList<>(20);
    }
   
    //This method adds student to array list "StudentDetails".
    public void addStudent(Student studentDetails){
        if(this.studentDetails.size()==20){
            System.out.println("Error: Max amount of students have been entered");
            return;
        }
        this.studentDetails.add(studentDetails);
    }
 
    //This method removes student from array list "studentDetails".
    public void removeStudent(String studentName){
        for(int index = 0; index < this.studentDetails.size(); index++) {
            Student student = this.studentDetails.get(index);
            if(student.getName().equals(studentName)){
              this.studentDetails.remove(index); 
              System.out.println("Student removed successfully");
              return;
            }
       
                }
        System.out.println("No student exists with the student name entered.");
    }
   
    //This method searches for students within the array list
    //If student within array list, program displays student details including tuition fees.
    public void searchStudent(String name){
        for(int index = 0; index < this.studentDetails.size(); index++) {
            Student student = this.studentDetails.get(index);
            if(student.getName().equals(name)){
                System.out.println(student.displayStudentDetails());
 
                Integer fees = TuitionFees.calculateTuitionFees(student);
                System.out.println("Tuition fees: £" + fees);
           
            }
        }
    }
   
    //This method prints courseReport including Number of FT and PT students, and percentage of Male and Female students.
    public void printCourseReport(){
    Integer numFullTime = 0;
    Integer numPartTime = 0;
    Integer numMale = 0;
    Integer numFemale = 0;
    Integer totalStudents = this.studentDetails.size();
 
   // this loops through array and works out how many FT and PT students there are aswell as how many Male and Female students there are.
for (int index = 0; index < this.studentDetails.size(); index++) {
    Student student = this.studentDetails.get(index);
if (student.getStudyMode().equals("FT")){
    //+=1 if doesnt work
    numFullTime++;
}
if (student.getStudyMode().equals("PT")){
    numPartTime++;
}
if (student.getGender().equals("Female")){
    numFemale++;
}
if (student.getGender().equals("Male")){
    numMale++;
}
}
 
            //Calculations used to work out male and female perentages.
            Integer percentageFemale = 0;
            Integer percentageMale = 0;
            if(totalStudents != 0){
             percentageFemale = (numFemale/totalStudents*100);
             percentageMale = (numMale/totalStudents*100);
            }
            //this displays the final calculations to be displayed at the end of all students being added.
            System.out.println("Number of Full Time students: " + numFullTime);
            System.out.println("Number of Part Time students: " + numPartTime);
            System.out.println("Percentage of Male students: " + percentageMale + "%");
            System.out.println("Percentage of Female students: " + percentageFemale + "%");
        }
            public void saveCourseDetails() {
 
                // Save students
                try {
                    FileWriter fw = new FileWriter("students.txt");
                    // Write our header line first
                    fw.write("name,dob,gender,studyMode,numModules,year\n");
 
                    for (Student student:this.studentDetails) {
                        fw.write(student.toCSVRow());
                    }
                    fw.close();
 
                } catch (IOException e) {
                    System.out.println(e);
                }
 
 
                // Save Course
               
            Integer numFullTime = 0;
            Integer numPartTime = 0;
            Integer numMale = 0;
            Integer numFemale = 0;
            Integer totalStudents = this.studentDetails.size();
           
            
            
 
           // this loops through array and works out how many FT and PT students there are aswell as how many Male and Female students there are.
        for (int index = 0; index < this.studentDetails.size(); index++) {
            Student student = this.studentDetails.get(index);
        if (student.getStudyMode().equals("FT")){
            //+=1 if doesnt work
            numFullTime++;
        }
        if (student.getStudyMode().equals("PT")){
            numPartTime++;
        }
        if (student.getGender().equals("Female")){
            numFemale++;
        }
        if (student.getGender().equals("Male")){
            numMale++;
        }
    
        }
        Integer percentageFemale = 0;
            Integer percentageMale = 0;
            if(totalStudents != 0){
             percentageFemale = (numFemale/totalStudents*100);
             percentageMale = (numMale/totalStudents*100);
            }
            try{
            FileWriter fw = new FileWriter("course.txt");
            // Write our header line first
            fw.write("courseName,numberPT,numberFT,percentageMale,percentageFemale\n");
            fw.write(String.format("%s,%d,%d,%d,%d,%d\n", this.courseName, this.studentDetails.size(), numPartTime, numFullTime, percentageMale, percentageFemale));
 
            for (Student student:this.studentDetails) {
                fw.write(student.toCSVRow());
            }
            fw.close();
 
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}