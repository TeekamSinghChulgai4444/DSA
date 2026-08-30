package WEIGHTED;

import java.util.ArrayList;
import java.util.List;

public class UN_DIRECTED {

    public class pair {
        int des;
        int w;

        public pair(int des, int w) {
            this.des = des;
            this.w = w;
        }
    }

    class graph {
        int v;
        List<List<pair>> l;

        public graph(int v) {
            this.v = v;
            l = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                l.add(new ArrayList<>());
            }
        }

        // ✅ method OUTSIDE constructor
        void addEdge(int s, int d, int w) {
            l.get(s).add(new pair(d, w));
            l.get(d).add(new pair(s, w));
        }
    }

    public static void main(String[] args) {

        UN_DIRECTED obj = new UN_DIRECTED();
        graph g = obj.new graph(5);

        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 20);
        g.addEdge(2, 0, 30);

        System.out.println("Graph created successfully");
    }
}