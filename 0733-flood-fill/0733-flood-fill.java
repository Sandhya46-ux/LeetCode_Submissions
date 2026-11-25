class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int ori= image[sr][sc];

        if (ori== color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] dx = {-1,1,0, 0};
        int[] dy = {0,0,-1,1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] ==ori) {
                    image[nx][ny] = color;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return image;
    }
}