package polinomio;


public class BinomioDeNewton {
	
	private int[][] tartaglia;
	private int a;
	private int b;
	private int n;
	
	public BinomioDeNewton(int a, int b, int n) {
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	public BinomioDeNewton() {
	}
	
    public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getN() {
		return n;
	}

	public int[][] trianguloTartaglia(int n) { 
        tartaglia = new int[n+1][]; 
        //Añado a cada fila, el array correspondiente con el numero de numeros que tendra 
        for (int i = 1; i <= n+1; i++) { 
            tartaglia[i - 1] = new int[i]; 
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
    	if (n == 0) return 1;
    	if (k > n) return 0;
    	return (Matematica.combinatoria(this.n, k) * Math.pow(a, k) * Math.pow(b, this.n - k));
    }
    
    
	public Polinomio formaPolinomica() {
		double[] coeficientes = new double[this.n + 1];
		for (int i = 0; i < coeficientes.length; i++) {
			coeficientes[i] = calculoCoeficienteK(n - i);
		}
		return new Polinomio(coeficientes);
	}
	
	public Polinomio formaPolinomicaConTartaglia() {
		trianguloTartaglia(this.n);
		double[] coeficientes = new double[n + 1];
		for (int i = 0; i < coeficientes.length; i++) {
			coeficientes[i] = this.tartaglia[n][i];
		}
		return new Polinomio(coeficientes);
	}

}
