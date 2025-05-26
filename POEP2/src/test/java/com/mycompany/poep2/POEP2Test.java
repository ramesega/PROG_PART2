/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poep2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class POEP2Test {
    
    public POEP2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of landingPage method, of class POEP2.
     */
    @Test
    public void testLandingPage() {
        System.out.println("landingPage");
        POEP2 instance = new POEP2();
        instance.landingPage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUserName method, of class POEP2.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("CheckUserName");
        POEP2 instance = new POEP2();
        boolean expResult = false;
        boolean result = instance.CheckUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class POEP2.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        POEP2 instance = new POEP2();
        boolean expResult = false;
        boolean result = instance.checkPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCellphone method, of class POEP2.
     */
    @Test
    public void testValidateCellphone() {
        System.out.println("validateCellphone");
        POEP2 instance = new POEP2();
        boolean expResult = false;
        boolean result = instance.validateCellphone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterUser method, of class POEP2.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        POEP2 instance = new POEP2();
        instance.RegisterUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mainMenu method, of class POEP2.
     */
    @Test
    public void testMainMenu() {
        System.out.println("mainMenu");
        POEP2 instance = new POEP2();
        instance.mainMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class POEP2.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        POEP2.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
