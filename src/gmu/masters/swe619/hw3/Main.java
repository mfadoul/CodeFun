package gmu.masters.swe619.hw3;

/**
 * @author mfadoul
 * Class: SWE 619
 * Date: 2/21/2010
 *
 * File: Main.java
 * 
 * This application contains a number of test cases to verify that the IntSet
 * class behaves as designed.
 */

public class Main {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("Running test cases for IntSet:");
        System.out.println("-----------------------------------");
        
        System.out.println ();
        // Test Cases
        testNoDuplicates();
        testSetMembership();
        testSetCardinality();
        testSetElementSelection();
        testSetOrder();
        testSetConstructors();
        testSetElementRemoval();
    }

    /**
     * Test 1: Sets contain no duplicates. Need test cases to validate and
     * verify this specification. (Hint: insert method)
     *
     */
    public static void testNoDuplicates() {

        IntSet intSet = new IntSet();

        System.out.println("Test 1: No Duplicates");
        System.out.println("  Description: This test validates that the set");
        System.out.println("  cannot contain duplicate elements, using the");
        System.out.println("  insert() method.");
        System.out.println();
        intSet.insert(1);
        System.out.println("Add 1. Current Set = " + intSet);
        intSet.insert(2);
        System.out.println("Add 2. Current Set = " + intSet);
        intSet.insert(3);
        System.out.println("Add 3. Current Set = " + intSet);
        intSet.insert(1);
        System.out.println("Add 1. Current Set = " + intSet);
        intSet.insert(2);
        System.out.println("Add 2. Current Set = " + intSet);
        intSet.insert(3);
        System.out.println("Add 3. Current Set = " + intSet);
        System.out.println("-----------------------------------");
    }

    /**
     * Test 2: Set membership. What is the set membership? Mutable? Unbounded sets of
     * integers? You need to provide tests that address set membership and show
     * your understanding of the modified specification for IntSet.
     */
    public static void testSetMembership() {
        IntSet intSet1 = new IntSet();

        System.out.println("Test 2: Set Membership");

        System.out.println("Test 2a: Set Membership with isIn()");
        System.out.println("  Description: This test validates that the method");
        System.out.println("  isIn() functions properly.");
        System.out.println();

        intSet1.insert(1);
        intSet1.insert(3);
        intSet1.insert(5);
        System.out.println("Initial Set = " + intSet1);

        System.out.println("Testing membership for values 0 to 5...");
        for (int i = 0; i < 6; ++i) {
            if (intSet1.isIn(i)) {
                System.out.println(i + " is an element of the Set.");
            } else {
                System.out.println(i + " is not an element of the Set.");
            }
        }
        System.out.println();

        // Check to see if intSets are mutable
        System.out.println("Test 2b: Checking mutability with equals().");
        System.out.println("  Description: This test validates that the IntSet");
        System.out.println("  objects are mutable, using the equals() method.");
        System.out.println();

        IntSet intSet2 = new IntSet();
        IntSet intSet3 = new IntSet();

        intSet2.insert(1);
        intSet2.insert(2);
        intSet3.insert(1);
        intSet3.insert(2);

        System.out.println("Question: Are intSet2 (" + intSet2 + ") and intSet3 ("
                + intSet3 + ") equal?");
        System.out.println("Answer:   Equal evaluates to " + intSet2.equals(intSet3));
        if (intSet2.equals(intSet3)) {
            System.out.println("IntSet objects are immutable.");
        } else {
            System.out.println("IntSet objects are mutable.");
        }

        System.out.println();

        // Check to see if set is unbounded.
        System.out.println("Test 2c: Checking to see if IntSet is unbounded");
        System.out.println("  Description: This test attempts to create an");
        System.out.println("  IntSet object with a large number of elements.");
        System.out.println("  Note: we will run out of memory with");
        System.out.println("  very large vectors; but the real point is to show");
        System.out.println("  that the implementation isn't using a fixed array.");
        System.out.println();

        // Large size
        final int maxTestSetSize = 5000;
        IntSet intSet4 = new IntSet();

        System.out.println("Checking to see if the set is unbounded.");
        System.out.println("Attempting to create an IntSet with size "
                + maxTestSetSize + ".");

        for (int i = 0; i < maxTestSetSize; ++i) {
            intSet4.insert(i * 2); // Let's add even numbers
        }
        
        if (maxTestSetSize == intSet4.size()) {
            System.out.println("Resultant set was successfully created.");
        } else {
            System.out.println("Unable to create set.  Size of IntSet object = "
                    + intSet4.size());
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Test 3: (3) Set cardinality.
     */
    public static void testSetCardinality() {
        IntSet intSet = new IntSet();
        System.out.println("Test 3: Set Cardinality");
        System.out.println("  Description: This test validates the size() method");
        System.out.println();
        System.out.println("Set size = " + intSet.size() + " (" + intSet + ")");

        for (int i = 0; i < 5; ++i) {
            intSet.insert(i);
            System.out.println("Set size = " + intSet.size() + " (" + intSet + ")");
        }

        for (int j = 0; j < 5; ++j) {
            intSet.remove(j);
            System.out.println("Set size = " + intSet.size() + " (" + intSet + ")");
        }

        System.out.println("-----------------------------------");
    }

    /**
     * Test 4: Set element selection. For our implementation focus on choose method.
     */
    public static void testSetElementSelection() {
        int elementValue;

        System.out.println("Test 4: Set Element Selection");
        System.out.println("  Description: This test validates element");
        System.out.println("  selection.  The test focuses on the choose() method.");
        System.out.println();

        IntSet intSet = new IntSet();

        // Choosing from an empty set will throw the EmptyException
        try {
            System.out.println("Attempting choose() on " + intSet);
            elementValue = intSet.choose();
            System.out.println("Arbitrary value = " + elementValue + " in set "
                    + intSet);
        } catch (EmptyException e) {
            System.out.println("Caught exception: " + e);
        }
        System.out.println();

        // Populate the set
        intSet.insert(10);
        intSet.insert(11);
        intSet.insert(12);

        // Choosing from an empty set will throw the EmptyException
        try {
            System.out.println("Attempting choose() on " + intSet);
            elementValue = intSet.choose();
            System.out.println("Arbitrary value = " + elementValue + " in set "
                    + intSet);
        } catch (EmptyException e) {
            System.out.println("Caught exception: " + e);
        }

        System.out.println("-----------------------------------");
    }

    /**
     * Test 5: Set order. N.B., our set is ordered. Need test cases to validate
     * and verify this specification.
     */
    public static void testSetOrder() {
        IntSet intSet = new IntSet();

        System.out.println("Test 5: Set Order");
        System.out.println("  Description: This test validates that the");
        System.out.println("  order of the IntSet is preserved, using insert().");
        System.out.println();
        intSet.insert(5);
        System.out.println("Add 5. Current Set = " + intSet);
        intSet.insert(3);
        System.out.println("Add 3. Current Set = " + intSet);
        intSet.insert(1);
        System.out.println("Add 1. Current Set = " + intSet);
        intSet.insert(4);
        System.out.println("Add 4. Current Set = " + intSet);
        intSet.insert(2);
        System.out.println("Add 2. Current Set = " + intSet);

        System.out.println("-----------------------------------");
    }

    /**
     * Test 6: Set constructors. Instantiation should create an empty test.
     */
    public static void testSetConstructors() {
        IntSet intSet = new IntSet();
        System.out.println("Test 6: Set Constructors");
        System.out.println("  Description: This test validates that the");
        System.out.println("  Constructor for IntSet produces an empty set.");
        System.out.println();
        System.out.println("Size of a newly-created IntSet is " + intSet.size());
        System.out.println("-----------------------------------");
    }

    /**
     * Test 7: Set element removal. Need test cases to validate and verify item
     * removal and preservation of set order.
     */
    public static void testSetElementRemoval() {
        int i; // For loop variable.
        IntSet intSet = new IntSet();
        System.out.println("Test 7: Set ElementRemoval");
        System.out.println("  Description: This test validates the remove()");
        System.out.println("  method and verifies that order is preserved.");
        System.out.println();

        // Populate set
        for (i = 5; i < 10; ++i) {
            intSet.insert(i);
        }

        System.out.println("Initial Set before removal = " + intSet);
        intSet.remove(10);
        System.out.println("Remove 10. Set = " + intSet);
        intSet.remove(8);
        System.out.println("Remove 8.  Set = " + intSet);
        intSet.remove(6);
        System.out.println("Remove 6.  Set = " + intSet);
        intSet.remove(4);
        System.out.println("Remove 4.  Set = " + intSet);
        System.out.println("-----------------------------------");
    }
}
