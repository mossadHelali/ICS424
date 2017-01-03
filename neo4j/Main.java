package neo4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import MySQL.*;

import org.neo4j.driver.v1.*;

public class Main {
	
	public static void main (String [] args) throws IOException{
		
		// making arrays of names
        String [] boys = new String [1000];
        String [] girls = new String[1000];
        Scanner scanB = new Scanner(new File("C:/Users/mosemos/workspace/ics424/src/main/java/MySQL/boys.txt"));
        Scanner scanG = new Scanner(new File("C:/Users/mosemos/workspace/ics424/src/main/java/MySQL/girls.txt"));
        int index = 0  ;
        System.out.println("Start reading from the file....");
        
        while(scanB.hasNext()){
            String boy = scanB.next();
            boys[index] = boy;
            String girl = scanG.next();
            girls[index] = girl;
            index++;
        }
        scanB.close();
        scanG.close();
	
        // initialize database connection
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "qwerty"));
		Session session = driver.session();
        
        
        Random rnd = new Random();
        
        long t1 = System.currentTimeMillis();
        
        // insert 1000 records
//        for(int i = 0; i < 1000; i++){
//        	String name = boys[rnd.nextInt(1000)] + " " + girls[rnd.nextInt(1000)];
//        	
//        	session.run("create (n:Man {name: \"" + name +  "\"})");
//        	
//        }
//		
       
        
		
		
        // add 0-100 relations per man node 
        
        for(int i = 7; i<2000; i++){
        	
        	
        	int iterations = rnd.nextInt(100);
        	
        	for(int k = 0; k<iterations; k++){
            	int j = rnd.nextInt(2000) + 6;

        		String addRelationQuery = "match (n:Man) where id(n) = " + i + " match(m:Man) where id(m) = " + j + " create (n)-[:cleans]->(m)";
        		
        		session.run(addRelationQuery);
        	}
        	
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2-t1)/1000.0);
        
		
/*		// search for all person nodes
		StatementResult sr = session.run("match (n) return n.name as name");
		
		
		while(sr.hasNext()){
			Record record = sr.next();
			System.out.println(record.get("name").asString());
		}
*/
		
		session.close();
		driver.close();
		
	}
}
