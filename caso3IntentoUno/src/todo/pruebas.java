package todo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class pruebas {
  public static void main(String[] args) {
    String inputString = "aabaa";
    
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
      
      // Imprimir el hash
      System.out.println("El hash SHA-256 del String \"" + inputString + "\" es:\n" + hashString);
      
    } catch (NoSuchAlgorithmException e) {
      System.out.println("Error: algoritmo de hashing no encontrado.");
    }
  }
}

