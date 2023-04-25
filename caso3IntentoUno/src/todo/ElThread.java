package todo;


import java.security.*;
import java.util.HashMap;
import java.math.BigInteger;

public class ElThread extends Thread{
	
	private static int algoritmo;
	private static String buscado;
	private static String sal;
	private static int cuantoHago;
	private String[] letras = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	//private String[] primMitad = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l", "m"};
	//private String[] segMitad = new String[] {"n","o","p","q","r","s","t","u","v","w","x","y","z"};
	HashMap<String, Integer> map = new HashMap<>();

	
	public ElThread(int algoritmo, String buscado, String sal, int numThreads) {
		this.algoritmo = algoritmo;
		this.buscado = buscado;
		this.sal = sal;
		this.cuantoHago = numThreads;
		for (char c = 'a'; c <= 'z'; c++) {
			  map.put(Character.toString(c), c - 'a');
		}
	}

	
	public void run()
	{
		long startTime = System.currentTimeMillis();
		if(cuantoHago==1)
		{
			ejecutarPrimeraMitad(startTime);
		}
		else if(cuantoHago==2)
		{
			ejecutarSegundaMitad(startTime);
		}
		else
		{
			ejecutarTodo(startTime);
		}
		
	}
	private void ejecutarTodo(long startTime) {
		// TODO Auto-generated method stub
		
		int inicio = 0;
		int fin = 25;
		int longitud = 1;
		String cualvoy = letras[inicio];
		String inputString = cualvoy.concat(sal);
		verificarHash(cualvoy+sal, cualvoy, startTime);
		System.out.println(cualvoy);
		
		while(longitud<8) 
		{
			if(Character.toString(cualvoy.charAt(cualvoy.length()-1)).equals("z"))
			  {
				 int centinela =  cualvoy.length();
				 boolean yaCambie = false;
				 while(centinela>0 && !yaCambie)
				 {
					centinela--;
					if(!Character.toString(cualvoy.charAt(centinela)).equals("z"))
					{
						int numAbcdario = map.get(Character.toString(cualvoy.charAt(centinela)));
						String newLetra = letras[numAbcdario+1];
						if(centinela==0)
						{
							String nuevo="";
				    		 for(int j=0; j<cualvoy.length()-1;j++)
				    		 {
				    			 nuevo+="a";
				    		 }
							cualvoy= newLetra + nuevo;
							verificarHash(cualvoy+sal, cualvoy, startTime);
							//System.out.println("EY");
							
							//System.out.println(cualvoy);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							yaCambie=true;
							
						}
						else
						{
							String nuevo="";
				    		 for(int j=centinela; j<cualvoy.length()-1;j++)
				    		 {
				    			 nuevo+="a";
				    		 }
				    		 cualvoy= cualvoy.substring(0,centinela)+newLetra + nuevo;
				    		 verificarHash(cualvoy+sal, cualvoy, startTime);
			    				
							
							//System.out.println(cualvoy);
							try {
								Thread.sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							yaCambie=true;
						}
						
					}
				 }
				 if(!yaCambie)
				 {
					 String nuevo="";
					 for(int j=0; j<=cualvoy.length();j++)
					 {
						 nuevo+="a";
					 }
					 cualvoy=nuevo;
					 verificarHash(cualvoy+sal, cualvoy, startTime);
					 longitud++;
				 }
			  }
			  else
			  {
				  int numAbcdario = map.get(Character.toString(cualvoy.charAt(cualvoy.length()-1)));
				  String newLetra = letras[numAbcdario+1];
				  cualvoy = cualvoy.substring(0,cualvoy.length()-1)+newLetra;
				  verificarHash(cualvoy+sal, cualvoy, startTime);
				  //System.out.println(cualvoy);
			  }
		}
	}
	
	private void ejecutarPrimeraMitad(long startTime) {
		// TODO Auto-generated method stub
		
		int inicio = 0;
		int fin = 25;
		int longitud = 1;
		String cualvoy = letras[inicio];
		String inputString = cualvoy.concat(sal);
		verificarHash(cualvoy+sal, cualvoy, startTime);
		System.out.println(cualvoy);
		
		
		while(longitud<4) 
		{
			
				 int centinela =  cualvoy.length();
				 boolean yaCambie = false;
				 while(centinela>0 && !yaCambie)
				 {
					centinela--;
					if(centinela==0 && Character.toString(cualvoy.charAt(centinela)).equals("m"))
					{
						String nuevo="";
						 for(int j=0; j<=cualvoy.length();j++)
						 {
							 nuevo+="a";
						 }
						 cualvoy=nuevo;
						 verificarHash(cualvoy+sal, cualvoy, startTime);
						 longitud++;
						 System.out.println(cualvoy);
						 yaCambie=true;
					}
					else if(!Character.toString(cualvoy.charAt(centinela)).equals("z"))
					{
						int numAbcdario = map.get(Character.toString(cualvoy.charAt(centinela)));
						String newLetra = letras[numAbcdario+1];
						String nuevo="";
			    		 for(int j=centinela; j<cualvoy.length()-1;j++)
			    		 {
			    			 nuevo+="a";
			    		 }
			    		 cualvoy= cualvoy.substring(0,centinela)+newLetra + nuevo;
			    		 verificarHash(cualvoy+sal, cualvoy, startTime);
			    		 System.out.println(cualvoy);
						yaCambie=true;
						
					}
				 }
				 if(!yaCambie)
				 {
					 String nuevo="";
					 for(int j=0; j<=cualvoy.length();j++)
					 {
						 nuevo+="a";
					 }
					 cualvoy=nuevo;
					 verificarHash(cualvoy+sal, cualvoy, startTime);
					 longitud++;
					 //System.out.println("JUEPUTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					 System.out.println(cualvoy);
				 }
		}
	}

	private void ejecutarSegundaMitad(long startTime) {
		// TODO Auto-generated method stub
		
		int inicio = 0;
		int fin = 25;
		int longitud = 1;
		String cualvoy = letras[13];
		String inputString = cualvoy.concat(sal);
		verificarHash(cualvoy+sal, cualvoy, startTime);
		System.out.println(cualvoy);
		
		while(longitud<4) 
		{
			if(Character.toString(cualvoy.charAt(cualvoy.length()-1)).equals("z"))
			  {
				 int centinela =  cualvoy.length();
				 boolean yaCambie = false;
				 while(centinela>0 && !yaCambie)
				 {
					centinela--;
					if(!Character.toString(cualvoy.charAt(centinela)).equals("z"))
					{
						int numAbcdario = map.get(Character.toString(cualvoy.charAt(centinela)));
						String newLetra = letras[numAbcdario+1];
						if(centinela==0)
						{
							String nuevo="";
				    		 for(int j=0; j<cualvoy.length()-1;j++)
				    		 {
				    			 nuevo+="a";
				    		 }
							cualvoy= newLetra + nuevo;
							verificarHash(cualvoy+sal, cualvoy, startTime);
							//System.out.println("EY");
							
							System.out.println(cualvoy);
							yaCambie=true;
							
						}
						else
						{
							String nuevo="";
				    		 for(int j=centinela; j<cualvoy.length()-1;j++)
				    		 {
				    			 nuevo+="a";
				    		 }
				    		 cualvoy= cualvoy.substring(0,centinela)+newLetra + nuevo;
				    		 verificarHash(cualvoy+sal, cualvoy, startTime);
			    				
							
							System.out.println(cualvoy);
							yaCambie=true;
						}
						
					}
				 }
				 if(!yaCambie)
				 {
					 String nuevo="n";
					 for(int j=0; j<cualvoy.length();j++)
					 {
						 nuevo+="a";
					 }
					 cualvoy=nuevo;
					 verificarHash(cualvoy+sal, cualvoy, startTime);
					 longitud++;
					 System.out.println(cualvoy);
				 }
			  }
			  else
			  {
				  int numAbcdario = map.get(Character.toString(cualvoy.charAt(cualvoy.length()-1)));
				  String newLetra = letras[numAbcdario+1];
				  cualvoy = cualvoy.substring(0,cualvoy.length()-1)+newLetra;
				  verificarHash(cualvoy+sal, cualvoy, startTime);
				  System.out.println(cualvoy);
			  }
		}
	}

	public void verificarHash(String inputString, String cualvoy, long startTime) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			if(algoritmo==2)
			{
				digest = MessageDigest.getInstance("SHA-512");
			}
		      
		      // Convertir el string a un array de bytes y actualizar el digest
		      byte[] inputBytes = inputString.getBytes();
		      digest.update(inputBytes);
		      
		      // Calcular el hash
		      byte[] hashBytes = digest.digest();
		      
		      // Convertir el hash a un String legible
		      BigInteger hashValue = new BigInteger(1, hashBytes);
		      String hashString = hashValue.toString(16);
		      
		      if(hashString.equals(buscado))
		      {
		    	  Principal.setClave(cualvoy);
		    	  long endTime = System.currentTimeMillis();
		    	  long elapsedTime = endTime - startTime;
		    	  Principal.setTiempo(elapsedTime);
		    	  //notifyAll();
		    	  System.out.println("LO ENCONTRE Y ES: "+cualvoy);
		    	  System.out.println("LO ENCONTRE EN : "+elapsedTime+" ms");
		      }
		}catch (NoSuchAlgorithmException e) {
		      System.out.println("Error: algoritmo de hashing no encontrado.");
		    }
	}
	

}
