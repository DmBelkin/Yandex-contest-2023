import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Deixtra {

  public static void  main(String[] args) throws IOException {
    /**
     * не решена
     */
    File resultFile = new File("out/output40.txt");
    File file = new File("input/inE15.txt");
    PrintWriter writer = new PrintWriter(resultFile);
    List<String> list = Files.readAllLines(Paths.get(file.getPath()));
    String[] input = list.get(0).split("\\s");
    int start = Integer.parseInt(input[1]);
    int end = Integer.parseInt(input[2]);
    String[] row = list.get(1).split("\\s");
    int[][] matrix = new int[list.size() - 1][row.length];
    int[] vertexes = new int[(list.size() - 1) * row.length];
    int index = 0;
    for (int i = 1; i < list.size(); i++) {
      String[] data = list.get(i).split("\\s");
      for (int j = 0; j < data.length; j++) {
        matrix[index][j] = Integer.parseInt(data[j]);
      }
      index++;
    }
    Graph graph = new Graph();
    graph.matrix = matrix;
    for (int[] a : matrix) {
      System.out.println(Arrays.toString(a));
    }
  }

  private static class Graph {
    int[][] matrix;
    Vertex[] vertexes;
  }

  private static class Vertex implements Comparable<Vertex> {
    int weight;
    double distance;
    boolean isVisited;
    Vertex prev;
    Vertex next;

    @Override
    public int compareTo(Vertex vertex) {
      return Integer.compare(this.weight, vertex.weight);
    }
  }

  public void dijkstra(Graph graph, int start, int end, int[] vertexes) {
    boolean[] marked = new boolean[vertexes.length];
    double[] distances = new  double[vertexes.length];
    graph.vertexes = new Vertex[vertexes.length];
    PriorityQueue<Vertex> queue = new PriorityQueue<>();
    Vertex prev = null;
    for (int i = 0; i < graph.matrix.length; i++) {
      for (int j = 0; j < graph.matrix[i].length; j++) {
        Vertex vertex = new Vertex();
        vertex.distance = Double.MAX_VALUE;
        vertex.isVisited = false;
        vertex.weight = graph.matrix[i][j];
        vertex.prev = prev;
        prev = vertex;
        if (i * j == start) {
          vertex.distance = 0.0;
          queue.add(vertex);
        }
        graph.vertexes[i] = vertex;
      }
    }
    while (!queue.isEmpty()) {
      Vertex v  = queue.peek();
      if (v.isVisited) {
        continue;
      }
      v.isVisited = true;
      for (Vertex vertex : graph.vertexes) {
        double dist = vertex.distance;
        if (dist > v.distance + v.weight) {
          vertex.distance = v.distance + v.weight;
          vertex.prev = vertex;
          queue.add(prev);
        }
//        if (dist[w]> dist[v] + e.weight()) {
//          dist[w] = dist[v] + e.weight();
//          pred[w] = e;
//          pq.insert(dist[w], w);
//        }
      }
    }
    for (Vertex v : queue) {
      System.out.println(v.weight);
    }
  }

}
