package javaBase;

import java.util.Scanner;

public class depositoBancario {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("Bienvenido/a al deposito bancario");
		int tipoMoneda;
		String usuario;
		String contraseña;
		String usu;
		String contra;
		usuario="kevin";
		contraseña="1234";
		int cantIntentos=1;
		
		System.out.println("Ingrese el usuario");
		usu=in.next();
		System.out.println("Ingrese la contraseña");
		contra=in.next();
		
		while (!usu.equals(usuario) || !contra.equals(contraseña)) {
			if (cantIntentos>2) {
				System.err.println("Superó la cantidad de intentos permitidos.");
				break;
			}
			System.out.println("Ingrese el usuario");
			usu=in.next();
			System.out.println("Ingrese la contraseña");
			contra=in.next();
			cantIntentos++;
		}
		
		if (usu.equals(usuario) && contra.equals(contraseña)) {

			System.out.println("Bienvenido! ¿Que tipo de moneda va a operar?");
			System.out.println("1-Pesos 2-Dolares 3-Reales");
			tipoMoneda=in.nextInt();
		
			switch (tipoMoneda) {
			case 1:
				double deposito;
				double saldo;
				saldo=80000;
				System.out.println("Bienvenido al deposito en pesos!");
				System.out.println("Ingrese el monto a depositar");
				deposito=in.nextDouble();
			
				if (deposito>=500) {
					saldo=saldo+deposito;
					System.out.println("Su depósito se realizó con exito, su saldo actual es $"+saldo);
				
				}	
				else {
					System.err.println("No puede depositar menos de $500 pesos");
					}
				break;
			case 2:
				double depositoDol;
				double saldoDol;
				saldoDol=300;
				System.out.println("Bienvenido al deposito en dolares!");
				System.out.println("Ingrese el monto a depositar");
				depositoDol=in.nextDouble();
		
				if (depositoDol>=10) {
				saldoDol=saldoDol+depositoDol;
				System.out.println("Su depósito se realizó con exito, su saldo actual es $"+saldoDol);
			
				}	
				else {
				System.err.println("No puede depositar menos de $10 dolares");
				}
				
				break;
			case 3:
				double depositoReal;
				double saldoReal;
				saldoReal=1000;
				System.out.println("Bienvenido al deposito en reales!");
				System.out.println("Ingrese el monto a depositar");
				depositoReal=in.nextDouble();
			
				if (depositoReal>=5) {
					saldoReal=saldoReal+depositoReal;
					System.out.println("Su depósito se realizó con exito, su saldo actual es $"+saldoReal);
				
				}	
				else {
					System.err.println("No puede depositar menos de $5 reales");
					}
				break;

			default:
				System.err.println("Debe colocar 1, 2 o 3 para seleccionar el tipo de moneda");
				break;
			}
		}
		else {
			
			System.err.println("Usuario o contraseña incorrecta");
		}
		
		
		in.close();
		 
	}
		

}
