package javaBase;

import java.util.Scanner;

public class panaderia {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		double kg;
		String cliente;
		String producto;
		double precio;	
		
		System.out.println("Bienvenidos al sistema de panaderia");
		System.out.println("Ingrese los kg:");
		kg=in.nextDouble();
		System.out.println("Ingrese su nombre:");
		cliente=in.next();
		System.out.println("Ingrese el producto:");
		producto=in.next();
		System.out.println("Ingrese el precio * kg:");
		precio=in.nextDouble();
		System.out.println("El cliente " + cliente + " compro " + kg + "kg de " + producto + " debe abonar $" + precio * kg);
		
		in.close();
	}
	
}

