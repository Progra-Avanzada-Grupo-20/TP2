package polinomio;


public class BinomioDeNewton {
	
	private double[][] tartaglia;
	private double a;
	private double b;
	private int grado;
	
	public BinomioDeNewton(double a, double b, int n) {
		this.a = a;
		this.b = b;
		this.grado = n;
	}
	
	public BinomioDeNewton() {
	}
	
    public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public int getN() {
		return grado;
	}

	public double[][] trianguloTartaglia(int n) { 
        tartaglia = new double[n+1][]; 
        //Añado a cada fila, el array correspondiente con el numero de numeros que tendra 
        for (int i = 1; i <= n+1; i++) { 
            tartaglia[i - 1] = new double[i]; 
        } 
        rellenar();
        return tartaglia;
    } 

 
    private void rellenar() { 
        for (int i = 0; i < tartaglia.length; i++) { 
            for (int j = 0; j < tartaglia[i].length; j++) { 
                if (j == 0 || j == tartaglia[i].length - 1) { 
                    tartaglia[i][j] = 1; 
                } else { 
                    tartaglia[i][j] = (tartaglia[i - 1][j] + tartaglia[i - 1][j - 1]); 
                } 
            } 
        } 
    }
    
    public void imprimirTriangulo() {
    	for(int i = 0; i < tartaglia.length; i++) {
    		for(int j = 0; j < tartaglia[i].length; j++) {
    			System.out.print(tartaglia[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    public double calculoCoeficienteK(int k) {
    	if (grado == 0) return 1;
    	if (k > grado) return 0;
    	return (Matematica.combinatoria(this.grado, k) * Math.pow(a, k) * Math.pow(b, this.grado - k));
    }
    
    public double calculoCoeficienteKConFactorialRecursivo(int k) {
    	if (grado == 0) return 1;
    	if (k > grado) return 0;
    	return (Matematica.combinatoriaFactorialRecursivo(this.grado, k) * Math.pow(a, k) * Math.pow(b, this.grado - k));
    }
    
    public double calculoCoeficienteKConFactorialDinamico(int k) {
    	if (grado == 0) return 1;
    	if (k > grado) return 0;
    	return (Matematica.combinatoriaFactorialDinamico(this.grado, k) * Math.pow(a, k) * Math.pow(b, this.grado - k));
    }
    
    public double calculoCoeficienteKRecursivo(int k) {
    	if (grado == 0) return 1;
    	if (k > grado) return 0;
    	return (Matematica.combinatoriaRecursiva(this.grado, k) * Math.pow(a, k) * Math.pow(b, this.grado - k));
    }
    
    public double calculoCoeficienteKDinamica(int k) {
    	if (grado == 0) return 1;
    	if (k > grado) return 0;
    	return (Matematica.combinatoriaDinamicaConVector(this.grado, k) * Math.pow(a, k) * Math.pow(b, this.grado - k));
    }
    
    
	public Polinomio formaPolinomica() {
		double[] coeficientes = new double[this.grado + 1];
		for (int i = 0; i < coeficientes.length; i++) {
			coeficientes[i] = calculoCoeficienteK(grado - i);
		}
		return new Polinomio(coeficientes);
	}
	
	public Polinomio formaPolinomicaConTartaglia() {
		trianguloTartaglia(this.grado);
		double[] coeficientes = new double[grado + 1];
		for (int i = 0; i < coeficientes.length; i++) {
			coeficientes[i] = this.tartaglia[grado][i];
		}
		return new Polinomio(coeficientes);
	}

}
