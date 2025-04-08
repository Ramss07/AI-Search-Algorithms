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


## Project 2: Simple Reflex Agent

This project simulates a **Simple Reflex Agent** in a basic two-room vacuum world environment. The agent operates based on immediate percepts without memory or internal state, demonstrating rule-based decision-making.

### Concept

The environment consists of two rooms, each of which may be clean or dirty. The agent perceives its current location and whether that room is dirty, then chooses an action accordingly.

### Agent Behavior

The agent can take the following actions:
- `Clean` – if the current room is dirty
- `MoveRight` – if in Room A (index 0) and the room is clean
- `MoveLeft` – if in Room B (index 1) and the room is clean

### How to Run

Compile the program and run it with command-line arguments:
```bash
java SimpleReflexAgent <start-location> <roomA-status> <roomB-status>

