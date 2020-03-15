package src.com.peace.graph;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Graph {
    
    public Graph() {

    }

    class Edge {
        private int weight;
        private Vertex vertex1;
        private Vertex vertex2;
    }

    class Vertex {
        private List<Edge> edges;
        private List<Vertex> adjacentVertex;
    }
}