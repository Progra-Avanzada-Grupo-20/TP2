package polinomio;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PolinomioTests {

    public static Polinomio polinomioGrado2;
    public static Polinomio polinomioGrado3;
    public static Polinomio polinomioGrado4;

    @BeforeClass
    public static void instanciate(){
        double [] coeficientes = {1,2};
        polinomioGrado2 = new Polinomio(coeficientes);
        System.out.println(polinomioGrado2);

        double [] coeficientes2 = {3,5,2};
        polinomioGrado3 = new Polinomio(coeficientes2);
        System.out.println(polinomioGrado3);

        double [] coeficientes3 = {1,2,5,1};
        polinomioGrado4 = new Polinomio(coeficientes3);
        System.out.println(polinomioGrado4);
    }

    @Test
    public void nUsandoMSucesivasGrado2(){
        double rta = polinomioGrado2.evaluarMSucesivas(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoMSucesivasGrado3(){
        double rta = polinomioGrado3.evaluarMSucesivas(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoMSucesivasGrado4(){
        double rta = polinomioGrado4.evaluarMSucesivas(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoRecursivaGrado2(){
        double rta = polinomioGrado2.evaluarRecursiva(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoRecursivaGrado3(){
        double rta = polinomioGrado3.evaluarRecursiva(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoRecursivaGrado4(){
        double rta = polinomioGrado4.evaluarRecursiva(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoRecursivaParGrado2(){
        double rta = polinomioGrado2.evaluarRecursivaPar(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoRecursivaParGrado3(){
        double rta = polinomioGrado3.evaluarRecursivaPar(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoRecursivaParGrado4(){
        double rta = polinomioGrado4.evaluarRecursivaPar(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoDinamicaGrado2(){
        double rta = polinomioGrado2.evaluarProgDinamica(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoDinamicGrado3(){
        double rta = polinomioGrado3.evaluarProgDinamica(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoDinamicaGrado4(){
        double rta = polinomioGrado4.evaluarProgDinamica(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoDinamicaMejoradaGrado2(){
        double rta = polinomioGrado2.evaluarMejorada(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoDinamicaMejoradaGrado3(){
        double rta = polinomioGrado3.evaluarMejorada(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoDinamicaMejoradaGrado4(){
        double rta = polinomioGrado4.evaluarMejorada(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoPowGrado2(){
        double rta = polinomioGrado2.evaluarPow(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoPowGrado3(){
        double rta = polinomioGrado3.evaluarPow(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoPowGrado4(){
        double rta = polinomioGrado4.evaluarPow(2);
        Assert.assertEquals(27,rta,2);
    }

    @Test
    public void nUsandoHornerGrado2(){
        double rta = polinomioGrado2.evaluarHorner(3);
        Assert.assertEquals(5,rta,2);
    }

    @Test
    public void nUsandoHornerGrado3(){
        double rta = polinomioGrado3.evaluarHorner(-2);
        Assert.assertEquals(4,rta,2);
    }

    @Test
    public void nUsandoHornerGrado4(){
        double rta = polinomioGrado4.evaluarHorner(2);
        Assert.assertEquals(27,rta,2);
    }


}
