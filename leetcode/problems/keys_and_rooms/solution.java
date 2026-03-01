class Solution {
     public void dfs(List<List<Integer>> rooms, int s, boolean[] visited) {
        visited[s] = true;

        for (int v : rooms.get(s)) {
            if (!visited[v]) {
                dfs(rooms, v, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, 0, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}