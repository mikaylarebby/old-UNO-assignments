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

    // Assignment #5 is a program that uses linked lists

import java.util.*;
import java.awt.*;

public class GraphVertex implements Comparable<GraphVertex> {
	
	private int distanceFromStart;
	private LinkedList<Point> edges;
	public static final boolean START_VERTEX = true;
	public static final boolean INTERIOR_VERTEX = false;
	
	public GraphVertex(boolean vertexType) {
		edges = new LinkedList<Point>();
		if(vertexType) {
			distanceFromStart = 0;
		}
		if(!vertexType){
			distanceFromStart = Integer.MAX_VALUE;
		}
	}
	public void addEdge(int vertex, int distance) {
		Point toAdd = new Point(vertex,distance);
		edges.add(toAdd);
	}
	
	public int getDistanceFromStart() {
		return distanceFromStart;
	}
	public void setDistanceFromStart(int distance) {
		
		if(distance < this.getDistanceFromStart()) {
			this.distanceFromStart = distance;
		}
	}
	
	public void relaxEdges(Graph g) {
		Point temp;
		for(int i = 0; i < edges.size(); i++) {
			temp = edges.get(i);
			g.setVertexDistanceFromStart(temp.x,temp.y + this.getDistanceFromStart());
		}
	}
	
	@Override
	public int compareTo(GraphVertex gv) {
		return this.getDistanceFromStart() - gv.getDistanceFromStart(); 
	}
}