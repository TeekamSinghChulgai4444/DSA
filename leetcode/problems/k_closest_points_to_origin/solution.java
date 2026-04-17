class Solution {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Triplate> pq = new PriorityQueue<>();

        int n = points.length;

        int i = 0;

        while (i < k) {
            int[] temp = points[i];
            int dis = temp[0]*temp[0] + temp[1]*temp[1];
            pq.add(new Triplate(dis, temp));
            i++;
        }

        while (i < n) {
            int[] temp = points[i];
            int dis = temp[0]*temp[0] + temp[1]*temp[1];
            pq.add(new Triplate(dis, temp));
            pq.poll();
            i++;
        }

        int[][] ans = new int[k][2];
        int l = 0;

        while (!pq.isEmpty()) {
            ans[l++] = pq.poll().j;
        }

        return ans;
    }

}
class Triplate implements Comparable<Triplate> {

    int dis;
    int[] j;

    public Triplate(int dis, int[] i) {
        this.dis = dis;
        this.j = i;
    }

    public int compareTo(Triplate s) {
        return Integer.compare(s.dis, this.dis);
    }
}