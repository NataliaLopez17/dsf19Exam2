package dsf19Exam2;

public class frr {

	/*
	 * Every hashing function distributes the keys uniformly around the hash table as long the number of buckets is maintained close a prime number p, p > 11. 

Select one:
a. True, only of the hash function uses the Java hashCode() method.
b. False 
c. True
d. None of the alternatives is correct.
	 */
	
	
	
	
	
	
	/*
	 * Engineer Amy Grant might be running into trouble with the following code:

public int buggyQueue(Queue<String> Q){
      int count = 0;
      while (!Q.isEmpty()){
           if (Q.front().equals("Trump")){
                   count++;
           }
           Q.enqueue(Q.dequeue());
      }
}
What is the problem with this code?

Select one:
a. None of the alternatives is right.
b. Instruction Q.front().equals("Trump") will throw an exception if the queue is empty.
c. Instruction Q.enqueue(Q.dequeue()) will cause an infinite loop. 
d. You cannot enqueue elements that you just dequeue.
e. Nothing, this code has no bugs.
	 */
	
	
	
	
	
	
	/*
	 * public void printIfNamePresent(Map<String> L, int i){
     String s = L.get(i);
     if (s!= null){
          System.out.println(s);
      }
}
What is the time complexity of this code fragment?

Select one:
a. O(N), N = L.size()
b. O(N+M), where N = L.size() and M = i
c. O(1) 
d. Cannot be determined from the information given
	 */
	
	
	
	
	
	
	/*
	 * void printList(SinglyLinkedList<Integer> L) {
     int i = 200, k = 0;
     for (Integer I : L){
          if (k == i){
               break;
          }
          System.out.println(I);
          k++;
     }
}
What is the time complexity of this code fragment?
Select one:
a. None of the alternatives is correct.
b. O(N), N = L.size() 
c. O(1)
d. O(N*k), where N = L.size(), and k < i
	 */

	
	
	
	
	/*
	 * Consider the following code fragment:

void list_array_print(ArrayList<String> name_lists[], int len){

     for (int i=0; i < len; ++i){

           for(String s : name_lists[i]){

                  System.out.println(s);

           }

     }

}

What is the time complexity for this method?


Select one:
a. O(N), N = len 
b. O(1)
c. O(N*M), N = len, and M = max(name_lists[i])
d. None of the alternatives since each list might have different size.
	 */
	
	
	
	
	
	
	
	
	/*
	 * Engineer Apu Smith is arguing with engineer Tom Selleck. Apu is telling Tom that separate chaining is good because using a list solves the problems of collisions, and will make all operations O(1) in the worst case. Tom is telling Apu that separate chaining works only when a singly linked list used, because with the array list it will be O(N). Who is right?



Select one:
a. They are both wrong.
b. Tom
c. They are both right.
d. Apu 
	 */
}
