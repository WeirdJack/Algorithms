import java.util.*;
import java.util.HashMap;

class PrimAlgorithm{

	static String[] nodes = {"x", "y", "z", "u", "v", "w", "t"};
	

	static int min(int a, int b){

		return (a > b)? b : a;
	}

	static int indexOf(String node){

		int index = 0;

		for(int i = 0; i < nodes.length; i++){

			if(nodes[i].equals(node)){

				index = i;
				break;
			}
		}

		return index;
	}

    public static void main(String[] args){

    	int[][] cost = new int[nodes.length][nodes.length];

    	for(int i = 0; i < nodes.length; i++){

			for(int j = 0; j < nodes.length; j++){


				if((nodes[i].equals("x") && nodes[j].equals("y")) || (nodes[i].equals("y") && nodes[j].equals("x"))){

					cost[i][j] = 6;
					
				}

				else if((nodes[i].equals("x") && nodes[j].equals("z")) || (nodes[i].equals("z") && nodes[j].equals("x"))){

					cost[i][j] = 8;
					
				}

				else if((nodes[i].equals("x") && nodes[j].equals("w")) || (nodes[i].equals("w") && nodes[j].equals("x"))){

					cost[i][j] = 6;
					
				}

				else if((nodes[i].equals("x") && nodes[j].equals("v")) || (nodes[i].equals("v") && nodes[j].equals("x"))){

					cost[i][j] = 3;
					
				}

				else if((nodes[i].equals("u") && nodes[j].equals("v")) || (nodes[i].equals("v") && nodes[j].equals("u"))){

					cost[i][j] = 3;
					
				}

				else if((nodes[i].equals("v") && nodes[j].equals("t")) || (nodes[i].equals("t") && nodes[j].equals("v"))){

					cost[i][j] = 4;
					
				}

				else if((nodes[i].equals("v") && nodes[j].equals("w")) || (nodes[i].equals("w") && nodes[j].equals("v"))){

					cost[i][j] = 4;
					//System.out.println("cost[" + i + "][" + j + "]: " + cost[i][j]);
					
				}

				else if((nodes[i].equals("v") && nodes[j].equals("y")) || (nodes[i].equals("y") && nodes[j].equals("v"))){

					cost[i][j] = 8;
					
				}

				else if((nodes[i].equals("z") && nodes[j].equals("y")) || (nodes[i].equals("y") && nodes[j].equals("z"))){

					cost[i][j] = 12;
					
				}

				else if((nodes[i].equals("t") && nodes[j].equals("u")) || (nodes[i].equals("u") && nodes[j].equals("t"))){

					cost[i][j] = 2;
					
				}

				else if((nodes[i].equals("u") && nodes[j].equals("w")) || (nodes[i].equals("w") && nodes[j].equals("u"))){

					cost[i][j] = 3;
					
				}

				else if((nodes[i].equals("t") && nodes[j].equals("y")) || (nodes[i].equals("y") && nodes[j].equals("t"))){

					cost[i][j] = 7;
					
				} else{

					cost[i][j] = 100000;
				}
			}
		}

    	HashMap<String, Integer> predQ = new HashMap<String, Integer>();
    	LinkedHashSet<String> path = new LinkedHashSet<String>();
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter Source: ");
    	String source = scanner.next();
    	path.add(source);
    	System.out.println("Root node: " + path);
    	System.out.println("Visited Nodes: " + path);
    	String a = "";
    	String current_source = "";
    	int dist = 0;
    	int current_min_cost = 100000;

    	for(String node : nodes){

    		if(!path.contains(node)){
    				
    				dist = cost[indexOf(source)][indexOf(node)];
    				if(dist <= current_min_cost){

    					current_min_cost = dist;
    					a = node;
    					current_source = source;
    				}
    		}
    	}

    	path.add(a);
    	System.out.print("Visited Nodes: " + path);
    	System.out.print("\t\tLightest edge: {" + current_source + "," + a + "}\n");

    	while(path.size() != nodes.length){

    		current_min_cost = 100000;
    		Object[] arr = path.toArray();
    		for(String node : nodes){

    			if(!path.contains(node)){

    				for(Object ar : arr){

    					dist = cost[indexOf(ar.toString())][indexOf(node)];
    					if(dist <= current_min_cost){

    						current_min_cost = dist;
    						current_source = ar.toString();
    						a = node;
    					}
    				}
    			}
    		}
    		path.add(a);
    		System.out.print("Visited Nodes: " + path);
    		System.out.print("\t\tLightest edge: {" + current_source + "," + a + "}\n");
    	}

    	System.out.println("Shortest path from " + source + ": " + path);
    }
}