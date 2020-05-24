import java.util.*;
import java.util.HashMap;

class DijkstraAlgorithm{

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
    	String a = "";
    	int dist = 0;
    	int i = 0;

    	System.out.println("Step N`           \tD(x)         D(y)         D(z)         D(u)         D(v)         D(w)         D(t)");

    	for(String node : nodes){

    		if(!node.equals(source)){

    			dist = cost[indexOf(source)][indexOf(node)];
    			predQ.put(node, dist);
    		}else{

    			predQ.put(node, 100000);
    		}
    	}

    	System.out.print(i + "    " + path + "           \t" + predQ.get("x") + "         " + predQ.get("y") + "         " + predQ.get("z") + "         " + predQ.get("u") + "         " + predQ.get("v") + "         " + predQ.get("w") + "         " + predQ.get("t"));


    	while(path.size() != nodes.length){
    		
    		int current_min_cost = 100000;
    		Object[] arr = path.toArray();
    		for(String node : nodes){

    			if(!path.contains(node)){
    				
    				dist = min(predQ.get(node), predQ.get(arr[arr.length - 1]) + cost[indexOf(node)][indexOf(arr[arr.length - 1].toString())]);
    				predQ.put(node, dist);
    				if(dist <= current_min_cost){

    					current_min_cost = dist;
    					a = node;
    				}
    			}
    		}
    		path.add(a);
    		i++;
    		System.out.print("\n" + i + "    " + path + "           ");
    		if(!path.contains("x")){
    			System.out.print(predQ.get("x") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("y")){
    			System.out.print(predQ.get("y") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("z")){
    			System.out.print(predQ.get("z") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("u")){
    			System.out.print(predQ.get("u") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("v")){
    			System.out.print(predQ.get("v") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("w")){
    			System.out.print(predQ.get("w") + "           ");
    		}else{
    			System.out.print("           ");
    		}

    		if(!path.contains("t")){
    			System.out.print(predQ.get("t") + "\n");
    		}else{
    			System.out.print("           ");
    		}
    	}

    	System.out.println("\nShortest path from " + source + ": " + path);
    }
}