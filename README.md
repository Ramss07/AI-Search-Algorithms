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
