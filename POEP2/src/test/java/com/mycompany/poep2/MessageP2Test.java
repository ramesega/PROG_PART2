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
public class MessageP2Test {
    
    public MessageP2Test() {
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
     * Test of checkRecipientCell method, of class MessageP2.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        MessageP2 instance = null;
        boolean expResult = false;
        boolean result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class MessageP2.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        MessageP2 instance = null;
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class MessageP2.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = MessageP2.returnTotalMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class MessageP2.
     */
    @Test
    public void testSentMessage() {
        System.out.println("sentMessage");
        MessageP2 instance = null;
        String expResult = "";
        String result = instance.sentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMessageDetails method, of class MessageP2.
     */
    @Test
    public void testShowMessageDetails() {
        System.out.println("showMessageDetails");
        MessageP2 instance = null;
        String expResult = "";
        String result = instance.showMessageDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessageToJson method, of class MessageP2.
     */
    @Test
    public void testStoreMessageToJson() {
        System.out.println("storeMessageToJson");
        MessageP2 instance = null;
        instance.storeMessageToJson();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
