Q. Implement the MedianFinder class:
  - MedianFinder() initializes the MedianFinder object.
  - void addNum(int num) add the integer num from the data stream to the data structure.
  - double findMedian() return the median of all elements. 

Constraints:
  - -10^5 <= num <= 10^5.
  - There will be at least one element in the data structure before calling findMedian.
  - At most 5*10^4 calls will be made to addNum and findMedian.

Follow Up.
  1.  If all integer numbers from the stram are in the range [0,100], how would you optimize your solution. 
  2.  If 99% of all integer numbers from the stream are in the range [0,100], how  would you optimize?

Solution. 
  1. With one arraylist, everytime addNum is called, sort the list and return the median. 
  2. Maintain two priority_queue smalls(reverse-order)/larges with two invariant. 
      -   |smalls|-|larges|<=1.
      -   small.peek()<larges.peek().
     and return the median by peeking those two priority queue.
  3. Maintain sorted list with finding index with binary search.  
