package javaBase;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Matematica mat=new Matematica();
		int op;
		double a;
		double b;

		do {
			System.out.println("\n\n\n\n");
			System.out.println("Ingrese la operacion a realizar\n");
			System.out.println("1- sumar");
			System.out.println("2- restar");
			System.out.println("3- multiplicar");
			System.out.println("4- dividir");
			System.out.println("5- promedio");
			op=in.nextInt();
			
			switch (op) {
				case 1:
					//sumar	
					System.out.println("Ingrese el primer valor");
					a=in.nextDouble();
					System.out.println("Ingrese el segundo valor");
					b=in.nextDouble();
					System.out.println(a + " + " + b + " es " + mat.sumar(a, b));
					break;
				case 2:
					//restar
					System.out.println("Ingrese el primer valor");
					a=in.nextDouble();
					System.out.println("Ingrese el segundo valor");
					b=in.nextDouble();
					System.out.println(a + " - " + b + " es " + mat.restar(a, b));
					break;
				case 3:
					//multiplicar
					System.out.println("Ingrese el primer valor");
					a=in.nextDouble();
					System.out.println("Ingrese el segundo valor");
					b=in.nextDouble();
					System.out.println(a + " * " + b + " es " + mat.multiplicar(a, b));
					break;
				case 4:
					//dividir
					System.out.println("Ingrese el primer valor");
					a=in.nextDouble();
					System.out.println("Ingrese el segundo valor");
					b=in.nextDouble();
					System.out.println(a + " / " + b + " es " + mat.dividir(a, b));
					break;
				case 5:
					//promedio
					double valorAPromediar;
					double resultProm;
					List<Double> listaNroAPromediar=new ArrayList<Double>();
					System.out.println("Ingrese un número a promediar");
					valorAPromediar=in.nextDouble();
					while (valorAPromediar!=0.0) {
						listaNroAPromediar.add(valorAPromediar);
						System.out.println("Ingrese el número a promediar");
						valorAPromediar=in.nextDouble();
					}
					resultProm=mat.promedio(listaNroAPromediar);
					System.out.println("\n\n\n");
					System.out.println("El promedio de los números es " + resultProm);
					break;
				case 6:
					System.out.println("Ingrese el valor a calcular");
					double raiz=in.nextDouble();
					System.out.println("La raiz cuadrada es " + mat.raizCuadrada(raiz));
					break;
				case 0:
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("Ingrese un numero correcto");
					break;
			}
		}while (op!=0);
		in.close();
	}

}
