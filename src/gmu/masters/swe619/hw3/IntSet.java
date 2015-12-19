package gmu.masters.swe619.hw3;

/**
 * @author mfadoul
 * Class: SWE 619
 * Date: 2/21/2010
 *
 * File: IntSet.java
 *
 * This class is a modification of the IntSet class from the textbook.  In this
 * implementation, the Integer elements are kept sorted, from small to large
 * values.
 */

import java.util.Vector;

public class IntSet {
    // OVERVIEW: IntSets are unbounded, mutable sets of Integers
    private Vector<Integer> els; // the rep

    // Constructors

    /**
     * This constructor creates an empty set of Integers.
     */
    public IntSet () {
        // EFFECTS: Initializes this to be empty
        els = new Vector<Integer>();
    }

    /**
     *
     * @param x Add this value to the set if it isn't already an element.
     */
    public void insert (int x) {
        // MODIFIES: this
        // EFFECTS: Adds x to the elements of this.  The method now keeps the
        // values sorted.
        Integer y = new Integer(x);
        if (getIndex(y) < 0) {
            // Insert in the correct order.
            for (int i = 0; i < els.size(); ++i) {
                Integer currentValue = (Integer) els.elementAt(i);
                if (x < currentValue.intValue()) {
                    els.insertElementAt(y, i);
                    return;
                }
            }
            // At this point, the int to be inserted is larger than all values
            // in the vector.
            els.add(y);
        }
        return;
    }

    /**
     *
     * @param x Remove this value to the set if it is an element.
     */
    public void remove (int x) {
        // MODIFIES: this
        // EFFECTS: Removes x from this

        int i = getIndex(new Integer(x));
        if (i < 0)
            return;

        // System.out.println ("-- Removing value " + x + " from index " + i);
        // els.set(i, els.lastElement());
        els.remove(i);
    }

    /**
     *
     * @param x The int value that will be checked.
     * @return True if x is in the set, otherwise return false.
     */
    public boolean isIn (int x) {
        // EFFECTS: Returns true if x is in this else returns false.
        return (getIndex(new Integer(x)) >=0);
    }

    /**
     *
     * @param x The value to be searched for.
     * @return The index in the set that contains the value x (-1 if it is not found)
     */
    private int getIndex(Integer x) {
        // EFFECTS: If x is in this returns index where x appears else returns -1.
        for (int i = 0; i < els.size(); i++) {
            if (x.equals((els.get(i))))
                return i;
        }
        return -1;  // Not found
    }

    /**
     *
     * @return the number of elements in the Integer set.
     */
    public int size() {
        // EFFECTS: Returns the cardinality of this.
        return els.size();
    }

    /**
     *
     * @return the int value of an arbitrary element in the set.
     * @throws EmptyException if the set is empty.
     */
    public int choose() throws EmptyException {
        // EFFECTS: If this is empty throws EmptyException else
        // returns an arbitrary element of this.
        if (els.size() == 0) {
            throw new EmptyException("IntSet.choose");
        }
        
        Integer element = (Integer) els.lastElement();
        return element.intValue();
    }

    @Override
    public String toString() {
        // EFFECTS: Returns a human-readable string that describes the IntSet's
        // state.
        if (els.size() == 0) {
            return "IntSet: {}";
        }
        String s = "IntSet: {" + els.elementAt(0).toString();

        for (int i = 1; i < els.size(); ++i) {
            s = s + ", " + els.elementAt(i).toString();
        }
        return s + "}";
    }
}
