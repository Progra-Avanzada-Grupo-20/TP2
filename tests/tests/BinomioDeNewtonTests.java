package tests;

import polinomio.*;

import org.junit.Assert;
import org.junit.Test;



public class BinomioDeNewtonTests {

	@Test
	public void testFactorial() {
		Assert.assertEquals(Matematica.factorial(0), 1, 0);
		Assert.assertEquals(Matematica.factorial(1), 1, 0);
		Assert.assertEquals(Matematica.factorial(2), 2, 0);
		Assert.assertEquals(Matematica.factorial(3), 6, 0);
		Assert.assertEquals(Matematica.factorial(4), 24, 0);
		Assert.assertEquals(Matematica.factorial(5), 120, 0);
		Assert.assertEquals(Matematica.factorial(6), 720, 0);
		Assert.assertEquals(Matematica.factorial(7), 5040, 0);
	}
	
	public void testfactorialRecursivo() {
		Assert.assertEquals(Matematica.factorialRecursivo(0), 1, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(1), 1, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(2), 2, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(3), 6, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(4), 24, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(5), 120, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(6), 720, 0);
		Assert.assertEquals(Matematica.factorialRecursivo(7), 5040, 0);
	}
	
	public void testfactorialDinamicoConVector() {
		Assert.assertEquals(Matematica.factorialDinamicoConVector(0), 1, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(1), 1, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(2), 2, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(3), 6, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(4), 24, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(5), 120, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(6), 720, 0);
		Assert.assertEquals(Matematica.factorialDinamicoConVector(7), 5040, 0);
	}

	@Test
	public void testCombinatoria() {
		Assert.assertEquals(Matematica.combinatoria(6, 0), 1, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 1), 6, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 2), 15, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 3), 20, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 4), 15, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 5), 6, 0);
		Assert.assertEquals(Matematica.combinatoria(6, 6), 1, 0);
		Assert.assertEquals(Matematica.combinatoria(10, 6), 210, 0);
	}

	@Test
	public void testCombinatoriaRecursiva() {
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 0), 1, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 1), 6, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 2), 15, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 3), 20, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 4), 15, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 5), 6, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(6, 6), 1, 0);
		Assert.assertEquals(Matematica.combinatoriaRecursiva(10, 6), 210, 0);
	}

	@Test
	public void testCombinatoriaDinamicaConVector() {
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 0), 1, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 1), 6, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 2), 15, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 3), 20, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 4), 15, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 5), 6, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(6, 6), 1, 0);
		Assert.assertEquals(Matematica.combinatoriaDinamicaConVector(10, 6), 210, 0);
	}

	@Test
	public void testTartaglia() {
		int[][] tartaglia = { { 1}, { 1, 1}, { 1, 2, 1}, { 1, 3, 3, 1},	{ 1, 4, 6, 4, 1 }, { 1, 5, 10, 10, 5, 1 }  };
		BinomioDeNewton binomio = new BinomioDeNewton();
		int[][] miTartaglia = binomio.trianguloTartaglia(5);
		for (int i = 0; i < tartaglia.length; i++) {
			for (int j = 0; j < tartaglia[i].length; j++) {
				Assert.assertEquals(tartaglia[i][j], miTartaglia[i][j]);
			}
		}
	}

	@Test
	public void testConstructor() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Assert.assertEquals(binomio.getA(), 2);
		Assert.assertEquals(binomio.getB(), 1);
		Assert.assertEquals(binomio.getN(), 2);
	}


	@Test
	public void testCoeficienteK() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Assert.assertEquals(binomio.calculoCoeficienteK(binomio.getN()), 4, 0);
		Assert.assertEquals(binomio.calculoCoeficienteK(1), 4, 0);
		Assert.assertEquals(binomio.calculoCoeficienteK(0), 1, 0);
	}

	@Test
	public void testFormaPolinomica() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Polinomio p = binomio.formaPolinomica();
		double[] coeficientes = { 4, 4, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Assert.assertEquals(p.toString(), q.toString());
	}

	@Test
	public void testFormaPolinomicaConTartaglia() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 2);
		double[] coeficientes = { 1, 2, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(p.toString(), q.toString());
	}
	
	@Test
	public void testFormaPolinomicaConTartagliaDos() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		double[] coeficientes = { 1, 3, 3, 1};
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(p.toString(), q.toString());
	}
	
	@Test
	public void testFormaPolinomicaConTartagliaTres() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 4);
		double[] coeficientes = { 1, 4, 6, 4, 1};
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(p.toString(), q.toString());
	}

}
