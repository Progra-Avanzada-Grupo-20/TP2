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
	
	public double evaluarMSucesivas (double x ) {
        double respuesta = 0;
        for(int i = 0; i < grado; i++){
            double parcial = x;
            for(int k = 0; k < (grado-i-1); k++){
                parcial *= x;
            }
            respuesta += coeficientes[i] * parcial;
        }
        respuesta += coeficientes[grado];
        return respuesta;
    }
	
	public double evaluarRecursiva(double x){
		double respuesta = 0;

        for(int i = 0; i < grado; i++){
            respuesta += coeficientes[i] * potencia(x,(grado-i));
        }
        respuesta += coeficientes[grado];

        return respuesta;
	}
	
	private double potencia(double x, int n){
		if(n==0) return 1;
		return x*potencia(x,n-1);
	}
	
	public double evaluarRecursivaPar(double x){
		double respuesta = 0;

        for(int i = 0; i < grado; i++){
            if((coeficientes.length-i-1) % 2 == 0){
                respuesta += coeficientes[i] * potencia(x*x,(coeficientes.length-i-1)/2);
            } else {
                respuesta += coeficientes[i] * potencia(x,(coeficientes.length-i-1));
            }
        }
        respuesta += coeficientes[grado];

        return respuesta;
	}
	
	public double evaluarProgDinamica(double x){
		int anterior = 1;
		double resultado=this.coeficientes[this.grado];

		if(this.grado == 0) 
			return this.coeficientes[0]; 
		
		for (int i = 1; i < this.grado+1; i++) {
			anterior*=x;
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
		double respuesta = 0;

        for(int i = 0; i < coeficientes.length; i++){
            respuesta += coeficientes[i] * Math.pow(x,(coeficientes.length-i-1));
        }

        return respuesta;
	}
	
	public double evaluarHorner(double x){     
		double b[] = new double[coeficientes.length];
        b[0] = coeficientes[0];
        for(int i = 1; i <= grado; i++){
            b[i] = coeficientes[i] + b[i-1]*x;
        }

        return b[grado];
    }

	@Override
    public String toString() {
        String txt = "";
        for(int i = 0; i < coeficientes.length; i++){
                txt += coeficientes[i] + "x^" + (coeficientes.length-i-1) + " + ";
        }
        txt = txt.substring(0,txt.length()-3);
        return txt;
    }
	
	
	

}

