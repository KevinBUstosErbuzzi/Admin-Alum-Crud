package javaBase;

public class Arrays {

	public static void main(String[] args) {
		int edad;
		edad=23;
		edad=18;
		
		if (edad>18) {
			System.out.println("es mayor de edad");
			
		}
		
		double [] sueldos=new double [20];
		for (int i = 0; i < sueldos.length; i++) {
			sueldos[i]=150000 + i*10000;
		}
		
		for (int i = 0; i < sueldos.length; i++) {
			System.out.println("El sueldo anterior era " + sueldos[i]);
			sueldos[i]=sueldos[i] + (sueldos[i]*10/100);
			System.out.println("El sueldo con incremento del 10% queda en " + sueldos[i]);
		}
		
		boolean [][] butacasDisp=new boolean[3][4];
		butacasDisp[0][0]=true;
		butacasDisp[0][1]=true;
		butacasDisp[0][2]=false;
		butacasDisp[0][3]=true;
		
		butacasDisp[1][0]=false;
		butacasDisp[1][1]=false;
		butacasDisp[1][2]=true;
		butacasDisp[1][3]=false;
		
		butacasDisp[2][0]=true;
		butacasDisp[2][1]=false;
		butacasDisp[2][2]=true;
		butacasDisp[2][3]=true;
		
		for (int i = 0; i < butacasDisp.length; i++) {
			for (int j = 0; j < butacasDisp[0].length; j++) {
				System.out.println("[i][j]="+i+j);
				System.out.println(butacasDisp[i][j]);
			}
			
		}
	}

}
