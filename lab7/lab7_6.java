package lab7;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class lab7_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int M = sc.nextInt();
        int N = sc.nextInt();
        int rs = sc.nextInt() - 1;
        int cs = sc.nextInt() - 1;
        int re = sc.nextInt() - 1;
        int ce = sc.nextInt() - 1;

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[][] distS = bfs(grid, M, N, rs, cs);
        int[][] distE = bfs(grid, M, N, re, ce);

        int count = 0;
        int minDist = Integer.MAX_VALUE;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0) {
                    int minS = Integer.MAX_VALUE;
                    int minE = Integer.MAX_VALUE;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                            if (distS[nr][nc] > 0) {
                                minS = Math.min(minS, distS[nr][nc]);
                            }
                            if (distE[nr][nc] > 0) {
                                minE = Math.min(minE, distE[nr][nc]);
                            }
                        }
                    }
                    if (minS != Integer.MAX_VALUE && minE != Integer.MAX_VALUE) {
                        count++;
                        minDist = Math.min(minDist, minS + 1 + minE);
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(minDist);
    }

    private static int[][] bfs(int[][] grid, int M, int N, int sr, int sc) {
        int[][] dist = new int[M][N];
        if (sr < 0 || sr >= M || sc < 0 || sc >= N || grid[sr][sc] == 0) {
            return dist;
        }
        Queue<int[]> q = new ArrayDeque<>();
        dist[sr][sc] = 1;
        q.add(new int[]{sr, sc});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && grid[nr][nc] == 1 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}
