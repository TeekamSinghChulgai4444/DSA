class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        int i = 0;
        int n = arr.length;

        // first k elements
        while (i < k && i < n) {
            int dis = Math.abs(x - arr[i]);
            maxHeap.add(new Pair(dis, arr[i]));
            i++;
        }

        // remaining elements
        while (i < n) {
            int dis = Math.abs(x - arr[i]);
            maxHeap.add(new Pair(dis, arr[i]));
            maxHeap.poll();
            i++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().ele);
        }

        Collections.sort(ans);
        return ans;
    }

}
class Pair implements Comparable<Pair> {
    int dis;
    int ele;

    Pair(int dis, int ele) {
        this.dis = dis;
        this.ele = ele;
    }

    
    public int compareTo(Pair other) {
        if (this.dis == other.dis) {
            return Integer.compare(other.ele,this.ele);
        }
        return Integer.compare(other.dis,this.dis);
    }
}