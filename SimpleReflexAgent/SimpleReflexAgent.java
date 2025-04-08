public class SimpleReflexAgent {

    public static void main(String[] args) 
    {
        Environment environment;
        
        if (args.length < 1)
        {
            System.out.println("Usage: java SimpleReflexAgent start-location roomA-status roomB-status");
            return;
        }
        else
        {
            int agentLocation = Integer.parseInt(args[0]);
            boolean rooms[] = new boolean[2];
            rooms[0] = Boolean.parseBoolean(args[1]);
            rooms[1] = Boolean.parseBoolean(args[2]); 
            
            environment = new Environment(agentLocation, rooms);
        }
        
        System.out.println("Agent Started...");
    
        for(int i=0; i<5; i++)
        {
            System.out.println("Environment Status:");
            System.out.println("\tAgent Location: " + environment.getAgentLocation());
            
            for (int locationIndex = 0; locationIndex < 2; locationIndex++)
            {
                System.out.print("\tLocation " + locationIndex + ": ");
                
                if (environment.getRooms()[locationIndex])
                    System.out.println("Dirty");
                else
                    System.out.println("Clean");
            }
            
            System.out.println();

            Percept percept = perceiveEnvironment(environment);
            
            AgentAction action = reflexVacuumAgent(percept);
            
            performAction(action, environment);
        }
    }

    private static Percept perceiveEnvironment(Environment environment) {
        int agentLocation = environment.getAgentLocation();
        boolean isCurrentLocationDirty = environment.getRooms()[agentLocation];
        
        return new Percept(agentLocation, isCurrentLocationDirty);
    }
    
    private static void performAction(AgentAction action, Environment environment) {
        switch (action) {
            case Clean:
                System.out.println("Action: Clean");
                environment.getRooms()[environment.getAgentLocation()] = false;
                break;
                
            case MoveLeft:
                System.out.println("Action: Move Left");
                environment.setAgentLocation(0);
                break;
                
            case MoveRight:
                System.out.println("Action: Move Right");
                environment.setAgentLocation(1);
                break;
                
            default:
                System.out.println("Action: NoOp");
                break;
        }
    }
    
    private static AgentAction reflexVacuumAgent(Percept percept) {
        if (percept.isDirty()) {
            return AgentAction.Clean;
        } else {
            if (percept.getLocation() == 0) {
                return AgentAction.MoveRight;
            } else {
                return AgentAction.MoveLeft; 
            }
        }
    }
}
