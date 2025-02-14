package gt.edu.url;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.Mockito.* ;
//import org.mockito.Mock;
// import org.junit,jupiter.api. * ;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) //actuvando la extension de mockito
public class CalculadoraTest {

	//Calculadora calculadora; //EN UN ESCENARIO IDEAL siempre se utiliza un constructor para inyectar las dependencias que calculadora necesita 
	
	//Stub o mock 
	//calculadoraOracleCloud calculadoraOracleCloud = (Double ... number) -> {
		// return number [0] + number[1]; //codigo para generar sin mockito
	//}
    @InjectMocks
    Calculadora calculadora = new Calculadora();

    @Mock CalculadoraOracleCloud calculadoraOracleCloud;//generamos instancia como mock

    @Test
    @DisplayName("Prueba de suma simple")
    public void probarSuma(){
        assertEquals(25.0, calculadora.sumar(5.0,20.0));
    }

    @Test
    @Disabled("El test de resta fue deshabilitado por decison del jefe")
    public void probarResta(){
        assertEquals(30.0, calculadora.restar(50.0,20.0));
    }

    @Test
    public void probarMultiplicacion(){
        assertEquals(25.0, calculadora.multiplicar(5.0,5.0));
    }

    @Test
    public void probarDivision(){
        assertThrows(ArithmeticException.class, () -> {
            var division = 100/0;
        });
    }

    @Test
    public void probarSumaEnLaNube(){ 
    	// al INICIO SIN MOCKITO: arrroja nullpointer exception porque calculadora no tiene como satisfacer su dependencia en oracle cloud 

        when(calculadoraOracleCloud.sumarEnOracleCloud(5.0,20.0)).thenReturn(25.0); //cuando se pruebe la sumaenlanube se programa la sig. condicion con el when
        //es decir cuando se introduzcan 5 y 20 en la funcion entonces se regrese 25
        //.... aqui se podrian agregar mas condiciones when 
       // when(calculadoraOracleCloud.sumarEnOracleCloud(5.0,5.0)).thenReturn(10.0);
        // se tiene la responsabilidad completA DE PROGRAMAR CORRECTAMENTE LOS VALORES ESPERADOS
        lenient().when(calculadoraOracleCloud.sumarEnOracleCloud(5.0,5.0)).thenReturn(10.0);

        assertEquals(25.0, calculadora.sumarEnLaNube(5.0,20.0));
    }

    @Test
    @DisplayName("Prueba de la tabla del 5")
    public void probarTabla5(){
        int[] numbers = {1,2,3,4,5};
        assertAll("tabla del 5",
                () -> {assertEquals(5, calculadora.multiplicar(5,1));},
                () -> {assertEquals(10, calculadora.multiplicar(5,2));},
                () -> {assertEquals(15, calculadora.multiplicar(5,3));},
                () -> {assertEquals(20, calculadora.multiplicar(5,4));},
                () -> {assertEquals(25, calculadora.multiplicar(5,5));}
                );

    }


}
