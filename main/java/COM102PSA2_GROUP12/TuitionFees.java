/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COM102PSA2_GROUP12;
 
/**
*
* @author laurasweeney B00879054 and hallelapham B00878031
*/
 
//Calculates tuition fees depending on your study mode, year group and how many modules you take (applies to PT only)
public class TuitionFees {
   
    public static Integer calculateTuitionFees(Student student) {
        if (student.getStudyMode().equals("FT")) {
            if (student.getYearGroup() != 3){
                return 5000;
            }
            return 2500;
        }
        if (student.getStudyMode().equals("PT")) {
            Integer numModules = student.getNumModules();
                return 750*numModules; 
        }
        return 0;
    }  
    
}