package javaBase;

public class ejemplosTiposDeDatos {

	public static void main(String[] args) {
		//modulo de edad
			int edad;
			edad=12;
			System.out.println("La edad del usuario es: " + edad);

			
		//modulo de panaderia
			double kg;
			String cliente;
			String producto;
			double precio;
			
		//viene el cliente juan perez y compre 2.5kg de pan a $800 kg
			kg=2.5;
			cliente="Juan Perez";
			producto="pan";
			precio=800.0;
			System.out.println("El cliente " + cliente + " compro " + kg + " kg de " + producto + ", debe abonar $" + precio * kg);
			
		//viene el cliente Kevin Suarez y compra 1.5 kg de pan negro a $900 x kg
			kg=1.5;
			cliente="Kevin Suarez";
			producto="pan negro";
			precio=900.0;
			System.out.println("El cliente " + cliente + " compro " + kg + "kg de pan negro a $" + precio * kg);
			
	}

}
