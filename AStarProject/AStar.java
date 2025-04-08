package com.astar;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;

class AStar {

    /**
     * Runs A* on the given board
     * @param board The board to run A* on
     * @param start The starting Point
     * @param end The ending Point
     * @return The spaces in order from the start Point to the end Point
     */
    public static ArrayList<Space> findPath(Board board, Point start, Point end) {
        
        //Create open list
        PriorityQueue<Space> openList = new PriorityQueue<>();

        //Create closed list
        HashSet<Space> closedList = new HashSet<>();

        //Create list to store the path found by algorithm
        ArrayList<Space> path = new ArrayList<>();

        Space startSpace = board.getSpace(start);
        Space endSpace = board.getSpace(end);

        //Set starting space G and H values and add it to the open list
        startSpace.setG(0);
        startSpace.setH(heuristic(startSpace, endSpace));
        openList.add(startSpace);

        while (!openList.isEmpty()) 
        {
            //Set current node to first element in queue
            Space current = openList.poll();
            
            //If current is the goal space, reconstruct that path
            if (current.equals(endSpace)) 
            {
                return reconstructPath(current, path);
            }

            //Add current node to closed list
            closedList.add(current);

            //For each neighbor of current
            for (Space neighbor : board.getNeighbors(current)) 
            {
                //If neighbor is in closed list or it is a blocked node, continue.
                if (closedList.contains(neighbor) || neighbor.getType() == SpaceType.BLOCK) 
                {
                    continue;
                }

                //Calculate cost to reach neighbor node
                int tentativeG = current.getG() + 1;

                //If neighbor is not in the open list or a cheaper way to reach it
                if (!openList.contains(neighbor) || tentativeG < neighbor.getG()) 
                {
                    //Sets previous neighbor space to current and set its G and H values
                    neighbor.setPrevious(current);
                    neighbor.setG(tentativeG);
                    neighbor.setH(heuristic(neighbor, endSpace));

                    //Adds neighbor to open list
                    if (!openList.contains(neighbor)) 
                    {
                        openList.add(neighbor);
                    }
                }
            }
        }

        return path;
    }

   
    private static int heuristic(Space a, Space b) 
    {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private static ArrayList<Space> reconstructPath(Space current, ArrayList<Space> path) 
    {
        while (current != null) 
        {
            path.add(0, current);
            current.setType(SpaceType.PATH); 
            current = current.getPrevious();
        }
        return path;
    }
}
