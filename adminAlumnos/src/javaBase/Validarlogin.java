package javaBase;

import java.util.Scanner;

public class Validarlogin {

	public static void main(String[] args) {
		Scanner in=new Scanner (System.in);
		String usuario;
		String contraseña;
		String usu=new String("");
		String contra=new String("");
		usuario="kevin";
		contraseña="1234";


		
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Ingrese el usuario");
			usu=in.next();
			System.out.println("Ingrese la contraseña");
			contra=in.next();
		
			
			
			if (usu.equals(usuario) && contra.equals(contraseña)) {
					System.out.println("Bienvenido");
					break;
			}
			else {
				System.err.println("error");
			}
		}
	in.close();
	}

}
