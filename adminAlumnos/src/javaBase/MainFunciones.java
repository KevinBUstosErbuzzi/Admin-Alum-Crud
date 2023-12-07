package javaBase;

public class MainFunciones {

	public static void main(String[] args) {
		Funciones2 func2=new Funciones2();
		func2.mostrarHola();
		func2.mostrachau();
		func2.sumar(5, 4);
		func2.sumar(45, 13);
		int resta=func2.restar(8, 3);
		System.out.println("La resta es " + resta);
		System.out.println("La resta es " + func2.restar(18, 3));
	}

}
