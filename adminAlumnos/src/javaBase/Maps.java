package javaBase;

import java.util.HashMap;
import java.util.Map;

public class Maps {

	public static void main(String[] args) {

		Map<Integer, String> meses=new HashMap<Integer, String>();
		meses.put(1,"Enero");
		meses.put(1,"Febrero");
		meses.put(1,"Marzo");
		meses.put(1,"Abril");
		meses.put(1,"Mayo");
		meses.put(1,"Junio");
		
		Map<String, String> passUser=new HashMap<String, String>();
		passUser.put("Juan1234", "jperez@gmail.com");
		passUser.put("Pedro1234", "pgimenez@gmail.com");
		passUser.put("Lore1234", "lperez@gmail.com");
		
		System.out.println(passUser.get("Juan1234"));

	}

}
