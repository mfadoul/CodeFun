package gmu.masters.swe619.hw3;

/**
 * @author mfadoul
 * Class: SWE 619
 * Date: 2/21/2010
 *
 * File: EmptyException.java
 * 
 * This Exception class is used by the IntSet class to indicate that the IntSet
 * is empty.  IntSet's choose() method is able to throw this exception.
 *
 */

class EmptyException extends RuntimeException {
    /**
     *
     * @param string A meaningful string for debugging.
     */
    EmptyException(String string) {
        super(string);
    }
}
