/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.baseclass;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author kate
 */
public class UserTypeTest {
    
    public UserTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class UserType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        UserType[] expResult = null;
        UserType[] result = UserType.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class UserType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        UserType expResult = null;
        UserType result = UserType.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
