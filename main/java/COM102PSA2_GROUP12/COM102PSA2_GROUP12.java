/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package COM102PSA2_GROUP12;

//used for the display of "DOB".
import java.time.LocalDate;
 
//import java.util.ArrayList;
 
//used to read any input.
import java.util.Scanner;
 
//used to import a date time format.Used to ensure any dates or times are inputted with the correct format.
import java.time.format.DateTimeFormatter;
//This import is used for detecting errors when a date is parsed in the incorrect format.
import java.time.format.DateTimeParseException;
 
/**
*
* @author laurasweeney B00879054 and hallelapham B00878031
*/
public class COM102PSA2_GROUP12 {
    //Main function that calls other functions.
    public static void main(String[] args) {
       
        //used to read input from the user.
        Scanner scanner = new Scanner(System.in) ;
        Course newCourse = new Course("Software Engineering");
       
        while(true){
                    //main menu for user to decide option.
            System.out.println("warning: if details entered incorrectly student's full details will not be saved." );
            System.out.println("1: add student" );
            System.out.println("2: remove student" );
            System.out.println("3: search student" );
            System.out.println("4: course report" );
            System.out.println("5: quit" );
 
             System.out.println("please enter your choice: " );
             String choice = scanner.nextLine();
             //Integer choice = 1;
            //used to state the format that the date of birth needs to be in. the "ofPattern" states what pattern
            //it should be. we have set our format to "dd/MM/yy" which means a DOB should be inputted as 29/04/02
 
           //if choice = 1, user is prompted to fill in student details and add student method is called
                if (choice.equals("1")){
              Student newStudent = studentPrompt(scanner);
            //Creates the variable "New course" to be stored within the array list.
 
 
            //adds new student to array list.
            newCourse.addStudent(newStudent);}
 
            // if choice = 2 user is asked what student they would like to remove .
    // program then checks if name entered is witihin studentDetails array.
    // if so the removeStudent method is called
            else if(choice.equals("2")){
            System.out.println("Please enter full name of student you want to delete: ");
            String nameRemoved = scanner.nextLine();
            newCourse.removeStudent(nameRemoved);
            }
 
            //searches for student within the array list.
            // if choice = 3 user is asked what student they wish to find.
            // program then checks if name entered is within studentDetails array.
            // if so the searchStudent method is called and the students details are then displayed.
            else if(choice.equals("3")){
            System.out.println("Enter student you wish to find: ");
            String studentSearch = scanner.nextLine();
            newCourse.searchStudent(studentSearch);
            }
 
           // if choice = 4 printCourseReport method is called.
 
            else if(choice.equals("4")){
                newCourse.printCourseReport();
            }
 
            // if choice = 5 program terminates.
            else if(choice.equals("5")){
            System.out.println("Program Terminating.");
            newCourse.saveCourseDetails();
            return;
            }
        }
    }
      
    private static Student studentPrompt(Scanner scanner){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
          //Prompts user to enter the students full name.
           
            System.out.println("Please enter your full name: ");
            String name = scanner.nextLine();
           
            System.out.println("Please enter your Gender (Male/Female/Other): ");
            String gender = scanner.nextLine();
 
        //Prompts the user to enter the students gender.
       
 
        /*A while loop is used here to ensure that a valid gender is entered. If the input is invalid,
        * the while loop repeats the prompt to the user until a valid input is enetered. Only then will the program
        * move onto the next question. Within the prompt, we have informed the user that if the gender is entered
        * incorrectly, "full details will not be saved".
        */
        while (!(gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Other"))) {
            System.out.println("Gender format is invalid! Please enter 'Female' , 'Male' or 'Other' Or else full details will not be saved");
            gender = scanner.nextLine();
        }
 
        //Prompts the user to enter the students Date Of Birth.
        System.out.println("Please enter your DOB (DD/MM/YY): ");
        String DOBString = scanner.nextLine();
       
        /*A while(true) loop is used here to ensure that the students DOB is entered in the correct format using
        * the .parse. if the parsing doesnt work, the error prompt is displayed and the loop repeats until the
        * DOB is entered in the correct format. when entered correctly, the "break" breaks the program out of
        * the loop and the program will move onto the next question. like previously, the user is informed that
        * if the DOB is enered incorrectly, "full details will not be saved".
        */
        while(true) {
        try {
            LocalDate DOB = LocalDate.parse(DOBString, formatter);
           
            break;
        } catch (DateTimeParseException e) {
            System.out.println("Date of birth Format is incorrect! please re enter with the format DD/MM/YY or else full details will not be saved");
            DOBString = scanner.nextLine();
 
        }
    }
        //Prompts the user to enter the students study mode, either Full Time or Part Time.   
        System.out.println("Please enter your Study Mode (FT/PT): ");
        String studyMode = scanner.nextLine();
 
        //Prompts the user to enter the students year that they are currently studying in University
        System.out.println("Please enter your year of study (1,2,3 or 4): ");
        Integer yearGroup = scanner.nextInt();
 
        //Prompts the user to enter how may modules the student is taking this semester out of 6.
        System.out.println("Please enter how many modules you are currently taking (1-6): ");
        Integer numModules = scanner.nextInt();
 
        //Creates variable "New student" to be stored in the array list.
        Student newStudent = new Student(name, DOBString, gender, studyMode, yearGroup, numModules);
        return newStudent;
    }
}
