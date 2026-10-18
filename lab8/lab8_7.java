package lab8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class lab8_7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) {
            return;
        }
        StringTokenizer st = new StringTokenizer(line);
        if (!st.hasMoreTokens()) {
            return;
        }
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> stationToLines = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            for (int s = 0; s < S; s++) {
                int station = Integer.parseInt(st.nextToken());
                stationToLines.computeIfAbsent(station, k -> new ArrayList<>()).add(i);
            }
        }

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            adj.add(new HashSet<>());
        }

        for (List<Integer> lines : stationToLines.values()) {
            for (int u : lines) {
                for (int v : lines) {
                    if (u != v) {
                        adj.get(u).add(v);
                        adj.get(v).add(u);
                    }
                }
            }
        }

        int[][] lineDist = new int[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(lineDist[i], -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            lineDist[i][i] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (lineDist[i][v] == -1) {
                        lineDist[i][v] = lineDist[i][u] + 1;
                        q.add(v);
                    }
                }
            }
        }

        String qLine = br.readLine();
        while (qLine != null && qLine.trim().isEmpty()) {
            qLine = br.readLine();
        }
        if (qLine == null) {
            return;
        }

        int Q = Integer.parseInt(qLine.trim());
        PrintWriter out = new PrintWriter(System.out);

        for (int q = 0; q < Q; q++) {
            String queryLine = br.readLine();
            while (queryLine != null && queryLine.trim().isEmpty()) {
                queryLine = br.readLine();
            }
            if (queryLine == null) {
                break;
            }
            st = new StringTokenizer(queryLine);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == B) {
                out.println(0);
                continue;
            }

            List<Integer> linesA = stationToLines.get(A);
            List<Integer> linesB = stationToLines.get(B);

            if (linesA == null || linesB == null) {
                out.println("impossible");
                continue;
            }

            int minTransfer = Integer.MAX_VALUE;
            for (int u : linesA) {
                for (int v : linesB) {
                    if (lineDist[u][v] != -1) {
                        minTransfer = Math.min(minTransfer, lineDist[u][v]);
                    }
                }
            }

            if (minTransfer == Integer.MAX_VALUE) {
                out.println("impossible");
            } else {
                out.println(minTransfer);
            }
        }
        out.flush();
    }
}
