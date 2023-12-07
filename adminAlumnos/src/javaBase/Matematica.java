package javaBase;
import java.util.List;

public class Matematica {
	public double sumar(double a, double b) {
		return a+b;
	}
	public double restar(double a, double b) {
		return a-b;
	}
	public double multiplicar(double a, double b) {
		return a*b;
	}
	public double dividir(double a, double b) {
		if (b<=0) {
			System.out.println("No se puede dividir por 0");
			return 0;
		} else {
		return a/b;
		}
	}
	public double promedio(List<Double> listaNroAPromediar) {
		double sumatoria=0;
		for (Double valor : listaNroAPromediar) {
			sumatoria+=valor;
		};
		
		return sumatoria/listaNroAPromediar.size();
	}
	public double raizCuadrada(double a) {
		return Math.sqrt(a);
	}
}

//todo: implementar funciones de min max oifhfpuoishf ptito
