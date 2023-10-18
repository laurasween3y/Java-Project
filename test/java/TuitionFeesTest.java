/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
*/
package COM102PSA2_GROUP12;
 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
/**
*
* @author User
*/
public class TuitionFeesTest {
   
    public TuitionFeesTest() {
    }
 
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }
 
    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }
 
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }
 
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
   
  //  @BeforeAll
    //public static void setUpClass() {
    //}
   
  //  @AfterAll
//   public static void tearDownClass() {
   // }
   
    //@BeforeEach
    //public void setUp() {
   // }
   
  //  @AfterEach
    //public void tearDown() {
  //  }
 
    /**
     * Test of calculateTuitionFees method, of class TuitionFees.
     */
    @org.junit.jupiter.api.Test
    public void testCalculateTuitionFees() {
        System.out.println("calculateTuitionFeesFT");
        Student student = new Student("Laura","Female","28/04/04","FT",1,3);
        Integer expResult = 5000;
        Integer result = TuitionFees.calculateTuitionFees(student);
        assertEquals(expResult, result);
       
        System.out.println("calculateTuitionFeesPT");
        Student student2 = new Student("Laura","Female","28/04/04","PT",1,5);
        Integer expResult2 = 3750;
        Integer result2 = TuitionFees.calculateTuitionFees(student2);
        assertEquals(expResult2, result2);
    }
   
}