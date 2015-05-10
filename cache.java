import java.util.Scanner;


public class cache {
	
	static int associativity = 2;          // Associativity of cache
	static int blocksize_bytes = 32;       // Cache Block size in bytes
	static int cachesize_kb = 64;          // Cache size in KB
	static int miss_penalty = 30;
	
	public int[][] table;
	public cache() {
	    table = new int[cache.cachesize_kb*1024/(cache.blocksize_bytes*associativity)][associativity];
	    
	}
	public int executionCycles() {
	    return 0;
	}
	public int numInstructions() {
	    return 0;
	}
	public int memoryAccesses() {
	    return 0;
	}
	public int dirtyEvictions() {
	    return 0;
	}
	public int loadMisses() {
	    return 0;
	}
	public int storeMisses() {
	    return 0;
	}
	public int loadHits() {
	    return 0;
	}
	public int storeHits() {
	    return 0;
	}
	public float overallMissRate() {
	    return 0;
	}
	public float readMissRate() {
	    return 0;
	}
	public float memoryCPI() {
	    return 0;
	}
	public float totalCPI() {
	    return 0;
	}
	public float averageMemoryAccessTime() {
	    return 0;
	}
	public static void print_usage()
	{
	  System.out.println("Usage: gunzip2 -c <tracefile> | java cache -a assoc -l blksz -s size -mp mispen\n");
	  System.out.println("  tracefile : The memory trace file\n");
	  System.out.println("  -a assoc : The associativity of the cache\n");
	  System.out.println("  -l blksz : The blocksize (in bytes) of the cache\n");
	  System.out.println("  -s size : The size (in KB) of the cache\n");
	  System.out.println("  -mp mispen: The miss penalty (in cycles) of a miss\n");
	  System.exit(0);
	}
	
	public static void main(String[] args) {
		  long address;
		  int loadstore, icount;
		  
		  int i = 0;
		  int j = 0;
		  // Process the command line arguments
		 // Process the command line arguments
		  while (j < args.length) {
		    if (args[j].equals("-a")) {
		      j++;
		      if (j >= args.length)
		        print_usage();
		      associativity = Integer.parseInt(args[j]);
		      j++;
		    } else if (args[j].equals("-l")) {
		      j++;
		      if (j >= args.length)
		        print_usage ();
		      blocksize_bytes = Integer.parseInt(args[j]);
		      j++;
		    } else if (args[j].equals("-s")) {
		      j++;
		      if (j >= args.length)
		        print_usage ();
		      cachesize_kb = Integer.parseInt(args[j]);
		      j++;
		    } else if (args[j].equals("-mp")) {
		      j++;
		      if (j >= args.length)
		        print_usage ();
		      miss_penalty = Integer.parseInt(args[j]);
		      j++;
		    } else {
		    	System.out.println("Bad argument: " + args[j]);
		      print_usage ();
		    }
		  }
		  

		  // print out cache configuration
		  System.out.println("Cache parameters:\n");
		  System.out.format("Cache Size (KB)\t\t\t%d\n", cachesize_kb);
		  System.out.format("Cache Associativity\t\t%d\n", associativity);
		  System.out.format("Cache Block Size (bytes)\t%d\n", blocksize_bytes);
		  System.out.format("Miss penalty (cyc)\t\t%d\n",miss_penalty);
		  System.out.println("\n");

		  Scanner sc = new Scanner(System.in);
		  cache c = new cache();
		  while (sc.hasNextLine()) {
			sc.next(); //get rid of hashmark
			loadstore = sc.nextInt();
			address = sc.nextLong(16); //16 specifies it's in hex
			icount = sc.nextInt();
			// Code to print out just the first 10 addresses.  You'll want to delete
		    // this part once you get things going.
		    /*if(i<10){
		    	System.out.println("\t " + loadstore + " " + Long.toHexString(address) + " " + icount);
		    }
		    else{
			System.exit(0);
		    }*/
		    i++;

		    //here is where you will want to process your memory accesses

		  }
		  sc.close();
		  // Here is where you want to print out stats
		  System.out.format("Lines found = %i \n",i);
		  
		  System.out.println("Simulation results:\n");
		  //  Use your simulator to output the following statistics.  The 
		  //  print statements are provided, just replace the question marks with
		  //  your calcuations.
		  
		  System.out.format("\texecution time %d cycles\n", c.executionCycles());	//number of total cycles, including memory penalties
		  System.out.format("\tinstructions %d\n", c.numInstructions());				//number of total instructions run
		  System.out.format("\tmemory accesses %d\n", c.memoryAccesses());			//number of both loads and stores
		  System.out.format("\toverall miss rate %.2f\n", c.overallMissRate() );		//number of misses for both loads and stores, divided by number of loads and stores
		  System.out.format("\tread miss rate %.2f\n", c.readMissRate() );			//number of load misses divided by number of loads
		  System.out.format("\tmemory CPI %.2f\n", c.memoryCPI());				//number of memory penalty cycles, divided by number of instructions
		  System.out.format("\ttotal CPI %.2f\n", c.totalCPI());				//total number of cycles, divided by number of instructions
		  System.out.format("\taverage memory access time %.2f cycles\n", c.averageMemoryAccessTime());  //number of memory penalty cycles, divided by number of memory accesses
		  System.out.format("dirty evictions %d\n", c.dirtyEvictions());				//number of evictions that needed to be written to memory
		  System.out.format("load_misses %d\n", c.loadMisses());					//number of loads not already in the cache
		  System.out.format("store_misses %d\n", c.storeMisses());				//number of stores not already in cache
		  System.out.format("load_hits %d\n", c.loadHits());					//number of loads in cache
		  System.out.format("store_hits %d\n", c.storeHits());					//number of stores in cache
		  
	}

}
