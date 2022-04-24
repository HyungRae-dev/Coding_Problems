import java.util.*;
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    public int binLessE(int low, int high, int num){
        List<Integer> list1 = list;
        int mid = (low+high)/2;
        if(high<low){return -1;}
        if(mid==low||mid==high){
            if(list.get(high)<=num)return high;
            if(list.get(low)<=num) return low;
            return -1;
        }
        if(list.get(mid)<=num){return mid;}
        else{return this.binLessE(low,mid-1,num);}
    }
    public int find(int num){
        List<Integer> list1 = list;
        int loc = this.binLessE(0,list.size()-1,num);
        int buff = loc;
        while(loc!=-1){
            buff = loc;loc = this.binLessE(loc+1,list.size()-1,num);
        }
        return buff+1;
    }
    public void addNum(int num) {
        List<Integer> list1 = list;
        if(list.isEmpty()){list.add(num);return;}
        list.add(this.find(num),num);
    }
    
    public double findMedian() {
        int n = list.size();List<Integer> list1 = list;
        if(n%2==0){
            return (double)(list.get(n/2)+list.get(n/2-1))/2;
        }else{
            return list.get(n/2);
        }
    }    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
