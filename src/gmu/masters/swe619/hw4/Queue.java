/**
 * @author mfadoul
 * Class: SWE 619
 * Date: 2/28/2010
 *
 *
 * File: Queue.java
 *
 * This application contains an immutable, generic queue class, along with
 * some tests to validate that it works.
 */

package gmu.masters.swe619.hw4;

import java.util.*;

public class Queue<E> {
    // OVERVIEW: This class is an immutable version of a queue of objects of
    // type E.  The enQueue() and deQueue() are producer methods, and peek()
    // is an observer method that returns the first element, just like the 
    // the mutable version of Queue.deQueue().

    // The rep
    private List<E> elements;
    private int size;

    // Constructor
    public Queue() {
        // EFFECTS: Initializes this to be an empty queue.
        this.elements = new ArrayList<E>();
        this.size = 0;
    }

    // Producers

    public Queue<E> enQueue(E e) {
        // EFFECTS: Returns a new Queue object that contains all elements plus
        // the parameter e.  This method does not modify the queue.
        Queue<E> result = new Queue<E> ();

        for (int i = 0; i < elements.size(); ++i) {
            result.elements.add(elements.get(i));
            result.size++;
        }

        // Add the extra element "e"
        result.elements.add(e);
        result.size++;
        return result;
    }

    public Queue<E> deQueue() {
        // EFFECTS: If the queue is empty, throws IllegalStateException,
        // returns a new Queue object that contains all elements of
        // this except the first.  This method does not modify the queue.

        if (isEmpty()) {
            throw new IllegalStateException("Queue.deQueue");
        }

        Queue<E> result = new Queue<E> ();
        for (int i = 1; i < elements.size(); ++i) {
            result.elements.add(elements.get(i));
            result.size++;
        }
        return result;
    }

    // Observers
    
    public E peek () {
        // EFFECTS: If the queue is empty, throws IllegalStateException, else
        // return the element at the front of the Queue.  This method does not
        // modify the queue.
        if (isEmpty()) {
            throw new IllegalStateException("Queue.peek");
        }
        E result = elements.get(0);
        return result;
    }

    public boolean isEmpty() {
        // EFFECTS: If size is zero, return true, else return false.
        return size == 0;
    }

    @Override
    public String toString() {
        // EFFECTS: Display the contents of the Queue in a String.

        if (size == 0) {
            return "Queue { }";
        }

        String s = "Queue {" + elements.get(0);
        for (int i = 1; i < size; ++i) {
            s += ", " + elements.get(i);
        }

        s += "}";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        // EFFECTS: returns false if:
        //   1) obj is null
        //   2) obj isn't an instance of the Queue class.
        //   3) this.elements differs from elements in obj.
        //   4) this.size differs from size in obj.
        // else returns true.
        
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final gmu.masters.swe619.hw4.Queue<E> other = (gmu.masters.swe619.hw4.Queue<E>) obj;
        if (this.elements != other.elements && (this.elements == null ||
                !this.elements.equals(other.elements))) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

    // Static methods
    
    public static void main(String[] args) {
        // Simple exercise to enQueue/deQueue cmd line args
        // Usage:  java Queue

        testQueue();
    }

    public static void testQueue () {
        // EFFECTS: This static method exercises the methods of the immutable
        // Queue class, and prints out its results.

        Queue<String> q0 = new Queue(); // Start with an empty queue.
        Queue<String> q1;
        Queue<String> q2;
        Queue<String> q3;
        Queue<String> q4;
        Queue<String> q3_d;
        Queue<String> q2_d;
        Queue<String> q2_dd;
        Queue<String> q1_d;
        Queue<String> q1_copy;

        // Exercise the enQueue method
        
        // Note that these are the same.
        q1      = q0.enQueue("One");
        q1_copy = q0.enQueue("One");

        q2    = q1.enQueue("Two");
        q3    = q2.enQueue("Three");
        q4    = q3.enQueue("Four");

        // Exercise the deQueue method
        q3_d  = q4.deQueue();
        q2_dd = q3_d.deQueue();
        q2_d  = q3.deQueue();
        q1_d  = q2.deQueue();

        // Print out the Queues that have been created.
        System.out.println ("Author : mfadoul");
        System.out.println ("HW #4  : Immutable Queue");
        System.out.println ("Class  : SWE 619");
        System.out.println ("Date   : 2/28/2010");
        System.out.println ();

        System.out.println ("------------------------------------");
        System.out.println ("Exercising the immutable Queue class");
        System.out.println ("------------------------------------");
        System.out.println ();
        System.out.println ("Some basic queues built with the enQueue producer");
        System.out.println ("-------------------------------------------------");
        System.out.println ("q0 = " + q0);
        System.out.println ("q1 = " + q1);
        System.out.println ("q2 = " + q2);
        System.out.println ("q3 = " + q3);
        System.out.println ("q4 = " + q4);
        System.out.println ();
        
        System.out.println ("Creating queues with the deQueue producer");
        System.out.println ("------------------------------------------");
        System.out.print ("A single dequeue from q4:");
        System.out.println ("  q3_d  = " + q3_d);
        System.out.print ("Two dequeues from q4    :");
        System.out.println ("  q2_dd = " + q2_dd);
        System.out.print ("A single dequeue from q3:");
        System.out.println ("  q2_d  = " + q2_d);
        System.out.print ("A single dequeue from q2:");
        System.out.println ("  q1_d  = " + q1_d);
        System.out.println ();

        System.out.println ("Exercising the peek() method.  This method shows");
        System.out.println ("the front element, without removing it.");
        System.out.println ("------------------------------------------------");
        System.out.println ("Peek at q1 = " + q1.peek());
        System.out.println ("Peek at q2 = " + q2.peek());
        System.out.println ("Peek at q3 = " + q3.peek());
        System.out.println ("Peek at q4 = " + q4.peek());
        System.out.println ("Peek at q3_d = " + q3_d.peek());
        System.out.println ("Peek at q2_d = " + q2_d.peek());
        System.out.println ("Peek at q2_dd = " + q2_dd.peek());
        System.out.println ("Peek at q1_d = " + q1_d.peek());

        System.out.println ();

        System.out.println ("Testing to see if the equals method works");
        System.out.println ("-----------------------------------------");
        System.out.println ("  q1.equals(q1_d)    ---> " + q1.equals(q1_d));
        System.out.println ("    Note: false, since the contents differ.");
        System.out.println ("  q1.equals(q1_copy) ---> " + q1.equals(q1_copy));
        System.out.println ("    Note: true, since the contents are the same.");

        System.out.println ();
        System.out.println ("Testing to see if the == operator is correct.");

        System.out.println ("-----------------------------------------");
        System.out.println ("  q1 == q1_copy      ---> " + (q1==q1_copy));
        System.out.println ("    Note: false, since they are different instances.");
    }
}
