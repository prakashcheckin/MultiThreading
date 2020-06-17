package com.threads.part3.semaphore;

import java.util.concurrent.Semaphore;

//Semaphore - Semaphore give you an option to allow multiple threads to enter into the critcal section at same time.
//In this example semaphore have 3 permits, so thread threads can enter into the critical section simultaneously.
class PrintThread extends Thread {
  int id;
  Semaphore semaphore;
  
  PrintThread(int id, Semaphore semaphore) {
    this.id = id;
    this.semaphore = semaphore;
  }

  public void run() {
	  try {

	      //Thread acquires the Semaphore permit. we have 3 permit. so three thread can execute this below critical statemnt at a time.
		  semaphore.acquire();
		  // critical
	      System.out.println("Printer " + id + " is printing...");

	      //this is for simulation purpose
          //In output we can see that, we have 3 permits. So 3 thread execute simultaneouly and remaining one thread execute after the sleep time ends and semaphore release the permit.
	      Thread.sleep(5000);
	      //Once the critical section complete, release the permit.
	      semaphore.release();
	  } catch(InterruptedException e) {
		  e.printStackTrace();
	  }
  }
}

public class SemaphoreEx {
	
  public static void main(String [] args) {

      //If Semaphore has only one permit then it works same as the lock process.

	  Semaphore semaphore = new Semaphore(3);
      new PrintThread(1, semaphore).start();
      new PrintThread(2, semaphore).start();
      new PrintThread(3, semaphore).start();
      new PrintThread(4, semaphore).start();
  }
  
}
