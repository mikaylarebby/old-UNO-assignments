// Name     : Mikayla Thomas
    // Class    : 1620
    // Program #    : 5
    // Due Date     : 11-17-2016
    //
    // Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu

    // Partners: NONE

    // Assignment #5 is a program that uses linked 
import java.util.*;
import java.awt.*;

public class Graph {
	private LinkedList<GraphVertex> vertices;
	
	public Graph() {
		vertices = new LinkedList<GraphVertex>();
	}
	public void addVertex() {
		GraphVertex toAdd;
			
		if(vertices.size() == 0) {
			toAdd = new GraphVertex(GraphVertex.START_VERTEX);
		}
		else {
			toAdd = new GraphVertex(GraphVertex.INTERIOR_VERTEX);
		}
		
		vertices.add(toAdd);
	}
	
	public void addEdge(int vertex1, int vertex2, int distance) throws NoSuchVertexException {
		if(vertex1 > vertices.size() || vertex1 < 0) {
			throw new NoSuchVertexException(vertex1);
		}
		if(vertex2 > vertices.size() || vertex2 < 0) {
			throw new NoSuchVertexException(vertex2);
		}
		else {
			vertices.get(vertex1).addEdge(vertex2,distance);
		}
	}
	
	public void setVertexDistanceFromStart(int vertex, int distance) {
		vertices.get(vertex).setDistanceFromStart(distance);
		
	}
	
	public int Dijkstra() {
		boolean[] processed = new boolean[vertices.size()];
		GraphVertex temp;
		for(int i = 0; i < processed.length; i++) {
			processed[i] = false;
		}
		do{
			temp = extractMinVertex(processed);
			if(temp != null){
				temp.relaxEdges(this);
			}
		}while(temp != null);
		return vertices.getLast().getDistanceFromStart();
		
	}
	
	public GraphVertex extractMinVertex(boolean[] visited) {
		GraphVertex temp;
		int i = 0;
		while(i < visited.length && visited[i] == true){
			i++;
		}
		if(i == visited.length) {
			return null;
		}
		else {
			temp = vertices.get(i);
			for(int c = i + 1; c < visited.length; c++){
				if(visited[c] == false && temp.compareTo(vertices.get(c)) > 0) {
					temp = vertices.get(c);
					i = c;
				}
			}
		}
		visited[i] = true;
		return temp;
	}
}