package polinomio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Polinomio {
	
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(int grado, double[] coeficientes){
		this.grado = grado;
		this.coeficientes = new double[grado + 1];

		for(int i = 0;i < grado + 1; i++){
			this.coeficientes[i] = coeficientes[i];
		}
	}
	
	public Polinomio(double[] coeficientes) {
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}
	
	public Polinomio(String path){
		
		try {
			leerArchivo(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void leerArchivo(String path) throws IOException{
		
		FileReader fr;
		BufferedReader bfInput = null;
		
		try {
			
			String linea;
			
			fr= new FileReader(new File(path));
			bfInput = new BufferedReader(fr);
			
			linea = bfInput.readLine();
			
			if( linea != null){
				this.grado = Integer.parseInt(linea);
				this.coeficientes = new double[this.grado+1];
				
				linea = bfInput.readLine();
				
				for(int i=0; i<this.grado+1; i++){
					this.coeficientes[i]= Double.parseDouble(linea);
					linea = bfInput.readLine();
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		bfInput.close();
	}
	
	public double evaluarMSucesivas(double x){
		double resultado = 0;
		double valorTermino = 1;
		
		for(int termino = 0; termino<(grado + 1); termino++){
			for(int exponente = (grado - termino); exponente > 0; exponente--){
				valorTermino*=x;
			}
			//multiplica el producto por el coeficiente
			resultado+=valorTermino*this.coeficientes[termino]; 
			valorTermino=1;
		}
	return resultado;
	}
	
	public double evaluarRecursiva(double x){
		double resultado = 0;
		for (int i = 0; i < (grado+1); i++) {
			if(this.coeficientes[i] != 0)
				resultado+= this.coeficientes[i] * potencia(x,(grado-i));
		}
		return resultado;
	}
	
	private double potencia(double x, int n){
		if(n==0) return 1;
		return x*potencia(x,n-1);
	}
	
	public double evaluarRecursivaPar(double x){
		double resultado = 0;
		for (int i = 0; i < (grado+1); i++) {
			if(this.coeficientes[i] != 0)
				resultado+= this.coeficientes[i] * potenciaPar(x,(grado-i));
		}
		return resultado;
	}
	
	private double potenciaPar(double x, int n){
		if(n == 0) return 1;
		if(n%2 != 0)
			return x*potenciaPar(x,n-1);
		return potenciaPar(x*x, n/2);
	}
	
	public double evaluarProgDinamica(double x){
		int anterior = 1;
		double resultado=this.coeficientes[this.grado];

		//si es una polinomio de grado 0, devuelvo el termino independiente. Para que no me de error. 
		if(this.grado == 0) 
			return this.coeficientes[0]; 
		
		for (int i = 1; i < this.grado+1; i++) {
			anterior*=x;
			//Hago la cuenta de coeficiente mas chico con el vector que le corresponde.
			resultado+= this.coeficientes[this.grado - i] * anterior;		
		}
		return resultado;
	}
	
	public double evaluarMejorada(double x){
		double resultado = this.coeficientes[0];
		for(int termino = 1; termino < this.coeficientes.length; termino++){
			resultado = (resultado * x) + this.coeficientes[termino];
		}
		return resultado;
	}
	
	public double evaluarPow(double x){
		double resultado = 0;
		for (int i = 0; i < (grado+1); i++) {
			if(this.coeficientes[i] != 0)
				resultado+= this.coeficientes[i] * Math.pow(x,(grado-i));
		}
		return resultado;
	}
	
	///EL ALGORITMO DE HORNER HACE QUE, TENIENDO, POR EJEMPLO UN POLINOMIO X^3+2X^2+5X+4---> [(X+2)X+5]X+4
	public double evaluarHorner(double x){     
        double resultado = coeficientes[0];		///ACA TOMO EL COEFICIENTE MAS ALTO
        for (int i = 1; i < this.coeficientes.length ; i++)
            resultado = this.coeficientes[i] + (x * resultado);       ///a0*x+a1
        return resultado;
    }

	@Override
	public String toString() {
		return "Polinomio [coeficientes=" + Arrays.toString(coeficientes) + "]";
	}
	
	
	

}

