package polinomio;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import polinomio.BinomioDeNewton;
import polinomio.Polinomio;



public class BinomioDeNewtonTests {

	public static BinomioDeNewton binomio0;
	public static BinomioDeNewton binomio1;
	public static BinomioDeNewton binomio2;
	public static BinomioDeNewton binomio3;
	
	@BeforeClass
	public static void instanciate() {
		binomio0 = new BinomioDeNewton(1,1,0);
		binomio1 = new BinomioDeNewton(4,-5,1);
		binomio2 = new BinomioDeNewton(2,1,2);
		binomio3 = new BinomioDeNewton(1,1,3);
	}
	
	@Test
	public void gradoCero() {
		double resultado = binomio0.calculoCoeficienteK(2);
		double resultado2 = binomio0.calculoCoeficienteKConFactorialDinamico(2);
		double resultado3 = binomio0.calculoCoeficienteKConFactorialRecursivo(2);
		double resultado4 = binomio0.calculoCoeficienteKDinamica(2);
		double resultado5 = binomio0.calculoCoeficienteKRecursivo(2);
		Assert.assertEquals(1.0, resultado,0);
		Assert.assertEquals(1.0, resultado2,0);
		Assert.assertEquals(1.0, resultado3,0);
		Assert.assertEquals(1.0, resultado4,0);
		Assert.assertEquals(1.0, resultado5,0);
	}
	
	@Test
	public void grado1() {
		double resultado0 = binomio1.calculoCoeficienteK(0);
		double resultado1 = binomio1.calculoCoeficienteK(1);
		Assert.assertEquals(-5, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		resultado0 = binomio1.calculoCoeficienteKConFactorialDinamico(0);
		resultado1 = binomio1.calculoCoeficienteKConFactorialDinamico(1);
		Assert.assertEquals(-5, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		resultado0 = binomio1.calculoCoeficienteKConFactorialRecursivo(0);
		resultado1 = binomio1.calculoCoeficienteKConFactorialRecursivo(1);
		Assert.assertEquals(-5, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		resultado0 = binomio1.calculoCoeficienteKDinamica(0);
		resultado1 = binomio1.calculoCoeficienteKDinamica(1);
		Assert.assertEquals(-5, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		resultado0 = binomio1.calculoCoeficienteKRecursivo(0);
		resultado1 = binomio1.calculoCoeficienteKRecursivo(1);
		Assert.assertEquals(-5, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
	}
	
	@Test
	public void grado2() {
		double resultado1 = binomio2.calculoCoeficienteK(1);
		double resultado0 = binomio2.calculoCoeficienteK(0);
		double resultado2 = binomio2.calculoCoeficienteK(2);
		Assert.assertEquals(1, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		Assert.assertEquals(4, resultado2,0);
		resultado1 = binomio2.calculoCoeficienteKConFactorialDinamico(1);
		resultado0 = binomio2.calculoCoeficienteKConFactorialDinamico(0);
		resultado2 = binomio2.calculoCoeficienteKConFactorialDinamico(2);
		Assert.assertEquals(1, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		Assert.assertEquals(4, resultado2,0);
		resultado1 = binomio2.calculoCoeficienteKConFactorialRecursivo(1);
		resultado0 = binomio2.calculoCoeficienteKConFactorialRecursivo(0);
		resultado2 = binomio2.calculoCoeficienteKConFactorialRecursivo(2);
		Assert.assertEquals(1, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		Assert.assertEquals(4, resultado2,0);
		resultado1 = binomio2.calculoCoeficienteKDinamica(1);
		resultado0 = binomio2.calculoCoeficienteKDinamica(0);
		resultado2 = binomio2.calculoCoeficienteKDinamica(2);
		Assert.assertEquals(1, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		Assert.assertEquals(4, resultado2,0);
		resultado1 = binomio2.calculoCoeficienteKRecursivo(1);
		resultado0 = binomio2.calculoCoeficienteKRecursivo(0);
		resultado2 = binomio2.calculoCoeficienteKRecursivo(2);
		Assert.assertEquals(1, resultado0,0);
		Assert.assertEquals(4, resultado1,0);
		Assert.assertEquals(4, resultado2,0);
	}
	
	

	@Test
	public void testTartaglia() {
		double[][] tartaglia = { { 1}, { 1, 1}, { 1, 2, 1}, { 1, 3, 3, 1},	{ 1, 4, 6, 4, 1 }, { 1, 5, 10, 10, 5, 1 }  };
		BinomioDeNewton binomio = new BinomioDeNewton();
		double[][] miTartaglia = binomio.trianguloTartaglia(5);
		for (int i = 0; i < tartaglia.length; i++) {
			for (int j = 0; j < tartaglia[i].length; j++) {
				Assert.assertEquals(tartaglia[i][j], miTartaglia[i][j], 0);
			}
		}
	}

	@Test
	public void testConstructor() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Assert.assertEquals(2,binomio.getA(), 0);
		Assert.assertEquals(1,binomio.getB(), 0);
		Assert.assertEquals(2,binomio.getN());
	}

	@Test
	public void testFormaPolinomica() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 1, 2);
		Polinomio p = binomio.formaPolinomica();
		double[] coeficientes = { 4, 4, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Assert.assertEquals(q.toString(), p.toString());
	}

	@Test
	public void testFormaPolinomicaConTartaglia() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 2);
		double[] coeficientes = { 1, 2, 1 };
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(q.toString(),p.toString());
	}
	
	@Test
	public void testFormaPolinomicaConTartagliaDos() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 3);
		double[] coeficientes = { 1, 3, 3, 1};
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(q.toString(), p.toString());
	}
	
	@Test
	public void testFormaPolinomicaConTartagliaTres() {
		BinomioDeNewton binomio = new BinomioDeNewton(1, 1, 4);
		double[] coeficientes = { 1, 4, 6, 4, 1};
		Polinomio q = new Polinomio(coeficientes);
		Polinomio p = binomio.formaPolinomicaConTartaglia();
		Assert.assertEquals(q.toString(), p.toString());
	}

}
