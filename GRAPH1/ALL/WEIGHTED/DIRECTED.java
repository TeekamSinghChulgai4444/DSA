package WEIGHTED;

import java.util.ArrayList;
import java.util.List;

public class DIRECTED {

    public class pair {
        int des;
        int w;

        public pair(int des, int w) {
            this.des = des;w = w;
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

        void addEdge(int s, int d, int w) {
            l.get(s).add(new pair(d, w));
        }

        void printGraph() {
            for (int i = 0; i < v; i++) {
                System.out.print(i + " -> ");
                for (pair p : l.get(i)) {
                    System.out.print("(" + p.des + ", " + p.w + ") ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        DIRECTED obj = new DIRECTED();
        graph g = obj.new graph(5);

        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 20);
        g.addEdge(2, 3, 30);
        g.addEdge(3, 1, 40); // cycle

        g.printGraph();
    }
}