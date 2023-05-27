//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 DNA Transcription: LinkedQueue Class
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class is a generic implementation of a linked queue.
 *
 * @param <T> - The type of data to be contained in the queue
 */
public class LinkedQueue<T> extends Object implements QueueADT<T> {

  protected Node<T> back; // The node at the back of the queue, added MOST recently
  protected Node<T> front; // The node at the front of the queue, added LEAST recently
  private int n; // The number of elements in the queue


  /**
   * Adds the given data to this queue; every addition to a queue is made at the back.
   * 
   * @param data - data to add
   */
  @Override
  public void enqueue(T data) {
    this.n++;
    if (front == null) {
      front = new Node<T>(data);
      back = front;
    } else {
      Node<T> enqueueNode = new Node<>(data);
      this.back.setNext(enqueueNode);
      this.back = enqueueNode;
    }
  }


  /**
   * Removes and returns the item from this queue that was least recently added.
   * 
   * @return the item from this queue that was least recently added
   * @throws NoSuchElementException if this queue is empty
   */
  @Override
  public T dequeue() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Error! The queue is empty!");
    }
    Node<T> dequeueNode = front;
    front = front.getNext();
    if (front == null) {
      back = null;
    }
    n--;
    return dequeueNode.getData();
  }


  /**
   * Returns the item least recently added to this queue without removing it.
   * 
   * @return the item least recently added to this queue
   * @throws NoSuchElementException if this queue is empty
   */
  @Override
  public T peek() throws NoSuchElementException {
    if (this.isEmpty())
      throw new NoSuchElementException("Error! The queue is empty!");
    return front.getData();
  }


  /**
   * Checks whether the queue contains any elements.
   * 
   * @return true if this queue is empty; false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (this.size() == 0) {
      return true;
    }
    return false;
  }


  /**
   * Returns the number of items in this queue.
   * 
   * @return the number of items in this queue
   */
  @Override
  public int size() {
    return this.n;
  }


  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) of
   * the queue and ending at the back (most recently added). An empty queue is represented as an
   * empty string; otherwise items in the queue are represented using their data separated by
   * spaces.
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String string = "";
    if (this.isEmpty()) {
      return string;
    } else {
      Node firstNode = this.front;
      for (int j = 0; j < size(); j++) {
        string = string + firstNode.getData() + " ";
        firstNode = firstNode.getNext();
      }
      return string;
    }
  }
}


