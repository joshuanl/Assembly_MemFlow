package EE352;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EE352 extends JFrame{

	
	private JPanel centerPanel;
	
	public EE352(){
//		super("EE 352");
//		setLocation(100,50);
//		setSize(300,300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		setVisible(true);
	}//end of constructor
	static Scanner keyboard = new Scanner(System.in);
	static int cacheSize = 1024, mainmemSize = 2048;
	static ArrayList<Integer> CACHE = new ArrayList<Integer>();
	static ArrayList<Integer> MAINMEM = new ArrayList<Integer>();
	static int input;
	static boolean loop = true;
	public static void main(String args[]){
		int n = 0;
		int CI = 0; //cache index
		int MI = 0; //mainmem index
		boolean FIC = false; //found in cache 
		boolean FIMM = false; //found in mainmem
		for(int i=0; i < 1024; i++){
			CACHE.add(i);
			MAINMEM.add((i+1024));
			
			System.out.println("Cache: "+ i + "     --MM: "+i);
		}
		for(int i=1024; i < 2048; i++){
			MAINMEM.add(i);
			System.out.println("-------     --MM: "+i);
		}
		
		while(loop){
			System.out.print("Enter value to find: ");
			input = keyboard.nextInt();
			
			for(int i=0; i < cacheSize; i++){
				if(input == CACHE.get(i)){
					CI = i;
					FIC = true;
				}//end of if
			}//end of for
			if(FIC){
				System.out.println("Found value: "+ input + " at CACHE ADDRESS: ");
			}//end of if found in cache
			else if(!FIC){
				for(int i=0; i < mainmemSize; i++){
					if(input == MAINMEM.get(i)){
						MI = i;
						FIMM = true;
					}//end of if
				}//end of for
				if(FIMM){
					System.out.println("Found value: "+ input + " at MAINMEM ADDRESS: "+MI);
					System.out.println("Moving into Cache...");
					System.out.println("Moving LRU value from cache: "+CACHE.get(0));
					System.out.println("And moving to MAINMEM ADDRESS: "+MI);
					int k = CACHE.get(0);
					CACHE.remove(0);
					CACHE.add(MAINMEM.get(MI));
					MAINMEM.remove(MI);
					MAINMEM.add(MI, k);
					
				}
			}//else not found in cache
			System.out.println("---NEW MEM BOOK---");
			for(int i=0; i < 1024; i++){
				System.out.println("Cache: "+ CACHE.get(i) + "     --MM: "+MAINMEM.get(i));
			}
			for(int i=1024; i < 2048; i++){
				System.out.println("-------     --MM: "+MAINMEM.get(i));
			}
		}//end of while	
	}// main
}//end of class
