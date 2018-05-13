package polinomio;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaTests {
	
	@Test
	public void testFactorial() {
		Assert.assertEquals(1,Matematica.factorial(0), 0);
		Assert.assertEquals(1,Matematica.factorial(1), 0);
		Assert.assertEquals(2,Matematica.factorial(2), 0);
		Assert.assertEquals(6,Matematica.factorial(3), 0);
		Assert.assertEquals(24,Matematica.factorial(4), 0);
		Assert.assertEquals(120, Matematica.factorial(5), 0);
		Assert.assertEquals(720, Matematica.factorial(6), 0);
		Assert.assertEquals(5040, Matematica.factorial(7), 0);
	}
	
	public void testfactorialRecursivo() {
		Assert.assertEquals(1, Matematica.factorialRecursivo(0), 0);
		Assert.assertEquals(1, Matematica.factorialRecursivo(1), 0);
		Assert.assertEquals(2, Matematica.factorialRecursivo(2), 0);
		Assert.assertEquals(6, Matematica.factorialRecursivo(3), 0);
		Assert.assertEquals(24, Matematica.factorialRecursivo(4), 0);
		Assert.assertEquals(120, Matematica.factorialRecursivo(5), 0);
		Assert.assertEquals(720, Matematica.factorialRecursivo(6), 0);
		Assert.assertEquals(5040, Matematica.factorialRecursivo(7), 0);
	}
	
	public void testfactorialDinamicoConVector() {
		Assert.assertEquals(1, Matematica.factorialDinamicoConVector(0), 0);
		Assert.assertEquals(1, Matematica.factorialDinamicoConVector(1),0);
		Assert.assertEquals(2, Matematica.factorialDinamicoConVector(2), 0);
		Assert.assertEquals(6, Matematica.factorialDinamicoConVector(3), 0);
		Assert.assertEquals(24, Matematica.factorialDinamicoConVector(4), 0);
		Assert.assertEquals(120, Matematica.factorialDinamicoConVector(5), 0);
		Assert.assertEquals(720, Matematica.factorialDinamicoConVector(6), 0);
		Assert.assertEquals(5040, Matematica.factorialDinamicoConVector(7), 0);
	}

	@Test
	public void testCombinatoria() {
		Assert.assertEquals(1, Matematica.combinatoria(6, 0), 0);
		Assert.assertEquals(6, Matematica.combinatoria(6, 1), 0);
		Assert.assertEquals(15, Matematica.combinatoria(6, 2), 0);
		Assert.assertEquals(20, Matematica.combinatoria(6, 3), 0);
		Assert.assertEquals(15, Matematica.combinatoria(6, 4), 0);
		Assert.assertEquals(6, Matematica.combinatoria(6, 5), 0);
		Assert.assertEquals(1,Matematica.combinatoria(6, 6), 0);
		Assert.assertEquals(210, Matematica.combinatoria(10, 6), 0);
	}
	
	@Test
	public void testCombinatoriaConFactorialRecursivo() {
		Assert.assertEquals(1, Matematica.combinatoriaFactorialRecursivo(6, 0), 0);
		Assert.assertEquals(6, Matematica.combinatoriaFactorialRecursivo(6, 1), 0);
		Assert.assertEquals(15, Matematica.combinatoriaFactorialRecursivo(6, 2), 0);
		Assert.assertEquals(20, Matematica.combinatoriaFactorialRecursivo(6, 3), 0);
		Assert.assertEquals(15, Matematica.combinatoriaFactorialRecursivo(6, 4), 0);
		Assert.assertEquals(6, Matematica.combinatoriaFactorialRecursivo(6, 5), 0);
		Assert.assertEquals(1,Matematica.combinatoriaFactorialRecursivo(6, 6), 0);
		Assert.assertEquals(210, Matematica.combinatoriaFactorialRecursivo(10, 6), 0);
	}
	
	@Test
	public void testCombinatoriaConFactorialDinamico() {
		Assert.assertEquals(1, Matematica.combinatoriaFactorialDinamico(6, 0), 0);
		Assert.assertEquals(6, Matematica.combinatoriaFactorialDinamico(6, 1), 0);
		Assert.assertEquals(15, Matematica.combinatoriaFactorialDinamico(6, 2), 0);
		Assert.assertEquals(20, Matematica.combinatoriaFactorialDinamico(6, 3), 0);
		Assert.assertEquals(15, Matematica.combinatoriaFactorialDinamico(6, 4), 0);
		Assert.assertEquals(6, Matematica.combinatoriaFactorialDinamico(6, 5), 0);
		Assert.assertEquals(1,Matematica.combinatoriaFactorialDinamico(6, 6), 0);
		Assert.assertEquals(210, Matematica.combinatoriaFactorialDinamico(10, 6), 0);
	}

	@Test
	public void testCombinatoriaRecursiva() {
		Assert.assertEquals(1, Matematica.combinatoriaRecursiva(6, 0), 0);
		Assert.assertEquals(6, Matematica.combinatoriaRecursiva(6, 1), 0);
		Assert.assertEquals(15, Matematica.combinatoriaRecursiva(6, 2), 0);
		Assert.assertEquals(20, Matematica.combinatoriaRecursiva(6, 3), 0);
		Assert.assertEquals(15, Matematica.combinatoriaRecursiva(6, 4), 0);
		Assert.assertEquals(6, Matematica.combinatoriaRecursiva(6, 5), 0);
		Assert.assertEquals(1, Matematica.combinatoriaRecursiva(6, 6), 0);
		Assert.assertEquals(210, Matematica.combinatoriaRecursiva(10, 6), 0);
	}

	@Test
	public void testCombinatoriaDinamicaConVector() {
		Assert.assertEquals(1, Matematica.combinatoriaDinamicaConVector(6, 0), 0);
		Assert.assertEquals(15, Matematica.combinatoriaDinamicaConVector(6, 2), 0);
		Assert.assertEquals(6, Matematica.combinatoriaDinamicaConVector(6, 1), 0);
		Assert.assertEquals(20, Matematica.combinatoriaDinamicaConVector(6, 3), 0);
		Assert.assertEquals(15, Matematica.combinatoriaDinamicaConVector(6, 4), 0);
		Assert.assertEquals(6, Matematica.combinatoriaDinamicaConVector(6, 5), 0);
		Assert.assertEquals(1, Matematica.combinatoriaDinamicaConVector(6, 6), 0);
		Assert.assertEquals(210, Matematica.combinatoriaDinamicaConVector(10, 6), 0);
		Assert.assertEquals(10, Matematica.combinatoriaDinamicaConVector(5, 2), 0);
		Assert.assertEquals(5, Matematica.combinatoriaDinamicaConVector(5, 4), 0);
		Assert.assertEquals(20, Matematica.combinatoriaDinamicaConVector(6, 3), 0);
		Assert.assertEquals(5, Matematica.combinatoriaDinamicaConVector(5, 4), 0);
	}

}
