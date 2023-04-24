package todo;


import java.security.*;
import java.math.BigInteger;

public class ElThread extends Thread{
	
	private static int algoritmo;
	private static String buscado;
	private static String sal;
	private static int cuantoHago;
	private String[] letras = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private String[] primMitad = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l", "m"};
	private String[] segMitad = new String[] {"n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	
	public ElThread(int algoritmo, String buscado, String sal, int numThreads) {
		this.algoritmo = algoritmo;
		this.buscado = buscado;
		this.sal = sal;
		this.cuantoHago = numThreads; 
	}

	
	public void run()
	{
		long startTime = System.currentTimeMillis();
		int inicio = 0;
		int fin = 25;
		int longitud = 1;
		if(cuantoHago==1)
		{
			fin = 12;
		}
		else if(cuantoHago==2)
		{
			inicio = 13;
		}
		String cualvoy = letras[inicio];
		String inputString = cualvoy.concat(sal);
		for (int i = inicio; i<fin && longitud<8; i++ )
		{
			try {
			      // Crear objeto MessageDigest para SHA-256
			      MessageDigest digest = MessageDigest.getInstance("SHA-256");
			      
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
			    	  notifyAll();
			    	  
			      }
			      if(Character.toString(cualvoy.charAt(cualvoy.length()-1)).equals("z"))
			      {
			    	  
			      }
			      
			    } catch (NoSuchAlgorithmException e) {
			      System.out.println("Error: algoritmo de hashing no encontrado.");
			    }
		}
	}

}
