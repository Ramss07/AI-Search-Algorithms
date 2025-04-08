## Projects Overview

### 1. Uninformed Search (BFS, DFS)

Implements classic uninformed search algorithms on a binary tree structure to locate a target node without using any heuristics.

**Algorithms Included:**
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Depth-Limited DFS
- Iterative Deepening DFS

**How to Run:**
Call static methods from `Search.java`:
```java
Search.BFS(tree, goal);
Search.DFS(tree, goal);
Search.DFSLimited(tree, depthLimit, goal);
Search.iterativeDFS(tree, goal);
```
### 2. Simple Reflex Agent

Simulates a Simple Reflex Agent operating in a two-room environment. The agent acts based on its current percept (location and cleanliness) without using memory or internal state.

**Agent Actions:**
- `Clean` – if the current room is dirty
- `MoveRight` – if in Room A (index 0) and the room is clean
- `MoveLeft` – if in Room B (index 1) and the room is clean

**How to Run:**
Compile and run with command-line arguments:
```bash
java SimpleReflexAgent <start-location> <roomA-status> <roomB-status>
```
### 3. A* Pathfinding Visualizer

A Java Swing GUI that visually demonstrates the A* pathfinding algorithm on a 2D grid. Users can interact with the grid to place start and end points, toggle walls, and visualize the shortest path found by the algorithm.

**Features:**
- Adjustable obstacle density via slider
- Left-click to place start and end points
- Right-click to toggle obstacles
- Real-time path visualization using A*

**How to Run:**
Compile and run the application:
```bash
javac com/astar/*.java
java com.astar.Main
```

Base code structure or logic may be adapted from course-provided material in ITCS-4230.
All logic for BFS, DFS, and A* search was written from scratch, based on algorithm theory. Only the class headers and file structure were provided by the course.


