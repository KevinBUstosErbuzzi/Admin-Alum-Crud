package javaBase;

import java.util.ArrayList;
import java.util.List;

public class Listas {

	public static void main(String[] args) {
		List<Double> listSueldos=new ArrayList<Double>();
		listSueldos.add(150000.00);
		listSueldos.add(160000.00);
		listSueldos.add(170000.00);
		listSueldos.add(180000.00);
		listSueldos.add(190000.00);
		
		//recorriendo la lista manualmente de 1 en 1
		System.out.println("sueldo 0 = " + listSueldos.get(0));
		System.out.println("sueldo 1 = " + listSueldos.get(1));
		System.out.println("sueldo 2 = " + listSueldos.get(2));
		System.out.println("sueldo 3 = " + listSueldos.get(3));
		System.out.println("sueldo 4 = " + listSueldos.get(4));
		listSueldos.indexOf(180000.00);
		//listSueldos.remove(3);
		System.out.println("cantidad de sueldos: " + listSueldos.size());
		
		
		//recorriendo la lista 
		for (int i = 0; i < listSueldos.size(); i++) {
			System.out.println("sueldo " + i + " = " + listSueldos.get(i));
			
		}
		
		
		for (Double suel : listSueldos) {
			System.out.println("aumento del 10% = " + (suel+=suel*10/100));
			System.out.println("promedio de sueldos = ");
			
		}
		
		List<String> listPaises= new ArrayList<String>();
		listPaises.add("Argentina");
		listPaises.add("Chile");
		listPaises.add("Bolivia");
		listPaises.add("Paraguay");
		
	}

}
