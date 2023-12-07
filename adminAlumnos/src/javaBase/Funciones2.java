package javaBase;

public class Funciones2 {
	
	public void mostrarHola() {
		this.mostraMensajes("hola");
	}
	public void mostrachau() {
		this.mostraMensajes("chau");
	}
	private void mostraMensajes(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void sumar(int a, int b) {
		//int result=a+b;
		System.out.println("La suma es " + (a+b));
	}
	public int restar(int a, int b) {
		return a-b;
	}
}

