import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Search 
{
	// Do NOT make any changes to the method name or parameters
	public static void BFS(Node tree, int goal)
	{
		System.out.println("BFS");
		System.out.println("goal: " + goal);	
		
		//Create FIFO queue starting at initial state
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(tree);
		//Create array of visited nodes with a size of 100. Set initial node to true.
		boolean[] reached = new boolean[100];
		reached[tree.data] = true;

		//Run while the que is not empty
		while (!frontier.isEmpty())
		{
			//Poll the front of the que and print
			Node currentNode = frontier.poll();
			System.out.println(currentNode.data);

			//If polled node is goal
			if(currentNode.data == goal)
			{
				System.out.println("Goal found: " + currentNode.data);
				return;
			}
			//If left of polled node is not null and is not in reached array
			if (currentNode.left != null && !reached[currentNode.left.data])
			{
				//Add left of polled node to que and to reached array
				frontier.add(currentNode.left);
				reached[currentNode.left.data] = true;
			}
			//If right of polled node is not null and is not in reached array
			if (currentNode.right != null && !reached[currentNode.right.data])
			{
				//Add right of polled node to que and to reached array
				frontier.add(currentNode.right);
				reached[currentNode.right.data] = true;
			}
		}
		System.out.println("Goal not found.");
		
	}
	
	public static void DFS(Node tree, int goal)
	{
		System.out.println("DFS");
		System.out.println("goal: " + goal);
		Stack<Node> stack = new Stack<>();
		stack.push(tree);
		//Create array of visited nodes with a size of 100. Set initial node to true.
		boolean[] reached = new boolean[100];
		reached[tree.data] = true;

		//Run while the que is not empty
		while (!stack.isEmpty())
		{
			//Set node to top of stack, remove it from stack, and print the node
			Node currentNode = stack.pop();
			System.out.println(currentNode.data);

			//Check if current node is the goal node
			if (currentNode.data == goal)
			{
				System.out.println("Goal found: " + currentNode.data);
				return;
			}
			//If right of current node exists, add it to stack
			if (currentNode.right != null && !reached[currentNode.right.data])
			{
				stack.push(currentNode.right);
				reached[currentNode.right.data] = true;
			}
			//If left of current node exists, add it to stack
			if (currentNode.left != null && !reached[currentNode.left.data])
			{
				stack.push(currentNode.left);
				reached[currentNode.left.data] = true;
			}
		}
		System.out.println("Goal not found.");
	}
	
	
	// Do NOT make any changes to the method name or parameters
	public static void DFSLimited(Node tree, int depthLimit, int goal)
	{
		System.out.println("DFS Limited");
		System.out.println("depth limit: "+ depthLimit);
		System.out.println("goal: " + goal);
		Stack<Node> stack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
		stack.push(tree);
		depthStack.push(0);
		//Create array of visited nodes with a size of 100. Set initial node to true.
		boolean[] reached = new boolean[100];
		reached[tree.data] = true;

		//Run while the que is not empty
		while (!stack.isEmpty())
		{
			//Set node to top of stack, remove it from stack, and print the node
			Node currentNode = stack.pop();
			int currentDepth = depthStack.pop();
			System.out.println(currentNode.data);

			//Check if current node is the goal node
			if (currentNode.data == goal)
			{
				System.out.println("Goal found: " + currentNode.data);
				return;
			}
			//If right of current node exists, add it to stack
			if (currentNode.right != null && !reached[currentNode.right.data] && currentDepth < depthLimit)
			{
				stack.push(currentNode.right);
				depthStack.push(currentDepth + 1);
				reached[currentNode.right.data] = true;
			}
			//If left of current node exists, add it to stack
			if (currentNode.left != null && !reached[currentNode.left.data] && currentDepth < depthLimit)
			{
				stack.push(currentNode.left);
				depthStack.push(currentDepth + 1);
				reached[currentNode.left.data] = true;
			}
		}
		System.out.println("Goal not found.");
	}
	
	
	//Do NOT make any changes to the method name or parameters
	public static void iterativeDFS(Node tree, int goal) {
		System.out.println("DFS Iterative");
		System.out.println("goal: " + goal);
	
		int depthLimit = 0;
		Stack<Node> stack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
		stack.push(tree);
		depthStack.push(0);
		boolean[] reached = new boolean[100];
		reached[tree.data] = true;
	
		while (!stack.isEmpty()) 
		{
			//Set current node and current depth to top of stacks
			Node currentNode = stack.pop();
			int currentDepth = depthStack.pop();
			System.out.println(currentNode.data);
	
			if (currentNode.data == goal) 
			{
				System.out.println("Goal found: " + currentNode.data);
				return;
			}
			//If depth is less than depth limit add nodes to stack, and increase depth by one
			if (currentDepth < depthLimit) 
			{
				if (currentNode.right != null && !reached[currentNode.right.data]) 
				{
					stack.push(currentNode.right);
					depthStack.push(currentDepth + 1);
					reached[currentNode.right.data] = true;
				}
			
				if (currentNode.left != null && !reached[currentNode.left.data]) 
				{
					stack.push(currentNode.left);
					depthStack.push(currentDepth + 1);
					reached[currentNode.left.data] = true;
				}
			}
			//If all nodes explored and depth is at depth limit, increase the depth limit and reset it to 0
			if (stack.isEmpty() && currentDepth == depthLimit) 
			{
				depthLimit++;
				stack.push(tree);
				depthStack.push(0);
				reached = new boolean[100];
				reached[tree.data] = true;
			}
		}
	
		System.out.println("Goal not found.");
	}
	
		
		
	}
