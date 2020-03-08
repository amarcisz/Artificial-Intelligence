package aima.search.mc;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.io.*;

import aima.search.mc.MCInstance;
import aima.search.mc.MCGoalTest;
import aima.search.mc.MCSuccessorFunction;
import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.framework.TreeSearch;
import aima.search.uninformed.IterativeDeepeningSearch;

/**
 * @author Justin Deschenes and Michael Fleming (Modified by Adam Marciszewski)
 * 
 */

public class MCDemo {
	public static void main(String[] args) {
		int mis = 0;
		int can = 0;

		System.out.print("Enter number of missionaries: ");	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			mis = Integer.parseInt(br.readLine());
		}	
		catch (IOException e) {
		   	System.err.println("Error: " + e);
		}

		System.out.print("Enter number of cannibals: ");
		try {
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));		
		  	can = Integer.parseInt(br2.readLine());
		}
		catch (IOException e) {
		  	System.err.println("Error: " + e);
		}
		MCInstance test = new MCInstance(mis, can);
		MCIDSDemo(test, mis, can);
	}


        private static void MCIDSDemo(MCInstance instance, int mis, int can) {
                System.out.println("\nMCDemo IDS for test case " + instance.toString() + " -->");
                try {
                        Problem problem = new Problem(instance,
                                        new MCSuccessorFunction(), new MCGoalTest(mis, can));
                        Search search = new IterativeDeepeningSearch();
                        SearchAgent agent = new SearchAgent(problem, search);

                        System.out.println();
                        printActions(agent.getActions());
                        printInstrumentation(agent.getInstrumentation());
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

	private static void printInstrumentation(Properties properties) {
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i);
			System.out.println(action);
		}
	}
}
