package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Principal {
	
	private static int algoritmo;
	private static String buscado;
	private static String sal;
	private static int numThreads;
	private static String clave = null;
	private static long tiempo =0;



    public static int getAlgoritmo() {
		return algoritmo;
	}

	public static String getBuscado() {
		return buscado;
	}

	public static String getSal() {
		return sal;
	}

	public static int getNumThreads() {
		return numThreads;
	}
	public static void setClave(String clavee) {
		clave = clavee;
	}
	public static void setTiempo(long tiempoo) {
		tiempo = tiempoo;
	}

	public static void main(String[] args) throws Exception {

        inicio();
        
    }

    public static void inicio(){
        String header = "\n";
        header += formatDiv("a----------------------------------------------------------------c\n");
        header += formatRow("|                  CASO 3:  PASSWORD CRACKING                    |\n");
        header += formatRow("|              Infraestructura Computacional 2023-1              |\n");
        header += formatRow("|                    Profesor: Ricardo Gómez                     |\n");
        header += formatDiv("d-------------------------------------b--------------------------f\n");
        header += formatRow("|          NOMBRE INTEGRANTE          |    CóDIGO INTEGRANTE     |\n");
        header += formatDiv("d-------------------------------------e--------------------------f\n");
        header += formatRow("|   Diego Alejandro Gonzalez Vargas   |         202110240        |\n");
        header += formatDiv("d-------------------------------------e--------------------------f\n");
        header += formatRow("|    Lindsay Vanessa Pinto Morato     |         20XXXXXXX        |\n");
        header += formatDiv("d-------------------------------------e--------------------------f\n");
        header += formatRow("|      Luis Angel Angarita Coba       |         20XXXXXXX        |\n");
        header += formatDiv("g-------------------------------------h--------------------------i\n"); 
        System.out.println(header);

        String datos = "";

        datos += formatDiv("a----------------------------------------------------------------c\n");
        datos += formatRow("| Ingrese el tipo de algoritmo de hash que  desea correr         |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        datos += formatRow("| 1. SHA-256                                                     |\n");
        datos += formatRow("| 2. SHA-512                                                     |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        System.out.print(datos);
        System.out.print(formatRow("| RTA:  "));
        Scanner sc = new Scanner(System.in);
        algoritmo = Integer.parseInt(sc.nextLine());
        System.out.print(formatDiv("g----------------------------------------------------------------i\n\n"));   

        datos = "";
        datos += formatDiv("a----------------------------------------------------------------c\n");
        datos += formatRow("| Ingrese el hash buscado                                        |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        System.out.print(datos);
        System.out.print(formatRow("| RTA:  "));
        //sc = new Scanner(System.in);
        buscado = sc.nextLine();
        System.out.print(formatDiv("g----------------------------------------------------------------i\n\n"));   

        datos = "";
        datos += formatDiv("a----------------------------------------------------------------c\n");
        datos += formatRow("| Ingrese la sal                                                 |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        System.out.print(datos);
        System.out.print(formatRow("| RTA:  "));
        //sc = new Scanner(System.in);
        sal = sc.nextLine();
        System.out.print(formatDiv("g----------------------------------------------------------------i\n\n"));   

        datos = "";

        datos += formatDiv("a----------------------------------------------------------------c\n");
        datos += formatRow("| Ingrese el numero de threads que desea                         |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        datos += formatRow("| 1. 1                                                           |\n");
        datos += formatRow("| 2. 2                                                           |\n");
        datos += formatDiv("d----------------------------------------------------------------f\n");
        System.out.print(datos);
        System.out.print(formatRow("| RTA:  "));
        //sc = new Scanner(System.in);
        numThreads = Integer.parseInt(sc.nextLine());
        System.out.print(formatDiv("g----------------------------------------------------------------i\n\n"));   

        if(numThreads==1)
        {
        	ElThread todo = new ElThread(algoritmo, buscado, sal, 3);
        	todo.start();
        	
        }
        if(numThreads==2)
        {
        	ElThread primeraMitad = new ElThread(algoritmo, buscado, sal, 1);
        	//ElThread segundaMitad = new ElThread(algoritmo, buscado, sal, 2);
        	primeraMitad.start();
        	//segundaMitad.start();
        	
        }
        

                
        sc.close();
        
    }


    // METODOS PARA IMPRESIÓN Y LOG

    public static String formatDiv(String str)
    {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    public static String formatRow(String str)
    {
        return str.replace('|', '\u2502');
    }

}