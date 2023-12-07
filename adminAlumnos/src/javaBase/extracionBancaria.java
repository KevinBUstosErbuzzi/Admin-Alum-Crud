package javaBase;

import java.util.Scanner;

public class extracionBancaria {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("Bienvenidos al Sistema de Extracción Bancaria");
		
		double extraccion;
		double saldo;
		
		saldo=20000;
		
		System.out.println("Ingrese el monto a extraer");
		extraccion=in.nextDouble();
		
		if (saldo>=extraccion) {
			
			saldo=saldo-extraccion;
			System.out.println("Puede extraer su dinero, el saldo restante es $" + saldo);
			
			
		}
		else {
			
			System.err.println("Fondos insuficientes, su saldo es $" + saldo + " y usted desea extraer $" + extraccion);
			
		}
		in.close();
	}

}
