import java.util.*;
class MedianFinder {

    int total; 
    PriorityQueue<Integer> smalls;
    PriorityQueue<Integer> larges;
    public MedianFinder() {
        total =0; smalls= new PriorityQueue<>((a,b)->b-a);
        larges = new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        if(total==0) {smalls.add(num);total++;return;}
        if(total==1){
            int val =0;
            if(smalls.isEmpty()){val = larges.poll();}
            else{val=smalls.poll();}
            smalls.add(Math.min(val,num));
            larges.add(Math.max(val,num));
            total++; return;
        }
        if(total%2==0){
            if(num>larges.peek()){smalls.add(larges.poll());larges.add(num);}  
            else{smalls.add(num);}
        }else{
            if(num>larges.peek()||num>smalls.peek()){larges.add(num);}
            else{larges.add(smalls.poll());smalls.add(num);}
        }
        total++;
    }
    
    public double findMedian() {
        if(total%2==0)
            return (double)(smalls.peek()+larges.peek())/2;
        else
            return smalls.peek();
    }    
}
