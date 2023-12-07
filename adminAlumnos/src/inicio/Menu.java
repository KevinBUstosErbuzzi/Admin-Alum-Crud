package inicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int opcion;
		
		List<String> menuIni=new ArrayList<String>();
		menuIni.add("--------Bienvenidos al Sistema de Administración de Alumnos--------");
		menuIni.add("Elija alguna opción: ingrese 1, 2, 3, 4 o 0");
		menuIni.add("[1] Alumnos");
		menuIni.add("[2] Profesores");
		menuIni.add("[3] Materias");
		menuIni.add("[4] Preceptores");
		menuIni.add("[0] Salir");
		menuIni.add("-------------------------------------------------------------------");
		
		do {
			for (String op : menuIni) {
				System.out.println(op);
			}
		
			opcion=in.nextInt();
		
			switch (opcion) {
			
				case 1:
					Alumnos alum=new Alumnos();
					alum.mostrarMenuAlum();
					break;
					
				case 2:
					Profesores prof=new Profesores();
					prof.mostrarMenuProf();
					break;
					
				case 3:
					Materias mat=new Materias();
					mat.mostrarMenuMat();
					break;
				
				case 4:
					Preceptores pre=new Preceptores();
					pre.mostarMenuPreceptores();
					break;
				case 0:
					System.out.println("Saludos");
					break;
		
				default:
					System.err.println("opcion incorrecta, vuelva a ingresar");
					break;
			} 
		}while (opcion!=0);

	}
	
}
	

		
