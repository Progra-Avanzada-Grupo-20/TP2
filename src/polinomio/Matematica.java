package polinomio;

public class Matematica {

	private static double[] tablaFactorial = new double[100];
	private static double[][] tablaCombinatoria = new double[100][150];
	private static int cantidad_filas = 1;
	
    public static double combinatoria(int m, int n){
    	return factorial(m) / (factorial(m - n) * factorial(n));
    }
    
    public static double combinatoriaFactorialRecursivo(int m, int n){
    	return factorialRecursivo(m) / (factorialRecursivo(m - n) * factorialRecursivo(n));
    }
    
    public static double combinatoriaFactorialDinamico(int m, int n){
    	return factorialDinamicoConVector(m) / (factorialDinamicoConVector(m - n) * factorialDinamicoConVector(n));
    }
    
	public static double combinatoriaRecursiva(int m, int n) {
		if (n == 0 || m == n) return 1;
		if (m == 0) return 0;
		return combinatoriaRecursiva(m - 1, n - 1) + combinatoriaRecursiva(m - 1, n);
	}

	public static double combinatoriaDinamicaConVector(int m, int n) { // Complejidad: O(m^2)
		tablaCombinatoria[0][0] = 1;
		tablaCombinatoria[1][0] = 1;
		tablaCombinatoria[1][1] = 1;
		if(n == 0 || m == n) return 1;
		if(m == 0) return 0;
		if(tablaCombinatoria[m][n] != 0.0) return tablaCombinatoria[m][n];
		int filas = cantidad_filas;
        for (int i = filas + 1; i <= m; i++) { 
            for (int j = 0; j < i + 1; j++) { 
                if (j == 0 || j == i) { 
                	tablaCombinatoria[i][j] = 1;
                } else { 
                	tablaCombinatoria[i][j] = (tablaCombinatoria[i - 1][j - 1] + tablaCombinatoria[i - 1][j]);
                }
            }
            System.out.println("Calculo en k = " + i);
            cantidad_filas = i;
        } 
        System.out.println("retorno: " + tablaCombinatoria[m][n]);
		return tablaCombinatoria[m][n];
	}
	
    public static double factorial(int n) {
		int f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
    }
    
    public static double factorialRecursivo(int n) {
    	if(n == 1 || n == 0) return 1;
    	return n * factorialRecursivo(n - 1);
    }
    
    public static double factorialDinamicoConVector(int n) {
    	tablaFactorial[0] = 1;
    	tablaFactorial[1] = 1;
    	if(n == 0) return tablaFactorial[0];
    	if(n == 1) return tablaFactorial[1];
    	if(tablaFactorial[n] != 0.0) return tablaFactorial[n];
    	for(int i = 2; i <= n; i++) {
    		tablaFactorial[i] = i * tablaFactorial[i-1];
    	}
    	return tablaFactorial[n];
    }

}
