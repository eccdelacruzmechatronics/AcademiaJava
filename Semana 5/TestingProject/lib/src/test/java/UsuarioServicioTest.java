import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class UsuarioServicioTest {
	
	private UsuarioServicio usuarioServicio;
	
	@BeforeEach
	public void setUp() {
		usuarioServicio = new  UsuarioServicio(); 
		usuarioServicio.crearUsuario(0L, "Usuario");
		usuarioServicio.crearUsuario(2L, "Usuario");
		
	}
	
	
	@DisplayName("dado un usuario que queremos crear, esperamos que cuando"
			+ " llamamos a crear un usuario esperamos que el usuario este creado")
	
	@Test
	public void test1() {
		
		UsuarioDto esperado = new UsuarioDto(1L, "Prueba");
		final UsuarioDto resultado = 
				usuarioServicio.crearUsuario(1L, "Prueba");
		Assertions.assertEquals(esperado.id,resultado.id);
		Assertions.assertEquals(esperado.nombre,resultado.nombre, "los nombres son diferentes");
		Assertions.assertEquals(esperado.id,resultado.id);
	//	Assertions.assertTrue(true);
	//	Assertions.assertFalse(false);
	//	Assertions.fail();
		
	}
	
	@Test
	public void test2() {
		
		UsuarioDto esperado = new UsuarioDto(1L, "Nombre");
		final UsuarioDto resultado = 
				usuarioServicio.crearUsuario(1L, "Prueba");
		Assertions.assertEquals(esperado.id,resultado.id);
		Assertions.assertEquals(esperado.nombre,resultado.nombre, "los nombres no son diferentes");
		Assertions.assertNotEquals(esperado.id,resultado.id);
	//	Assertions.assertTrue(true);
	//	Assertions.assertFalse(false);
	//	Assertions.fail();
		
	}
	
	@DisplayName("obtener usuario")
	
	@Test
	public void test3() {
		
		UsuarioDto esperado = new UsuarioDto(1L, "Prueba");
		final UsuarioDto resultado = 
				usuarioServicio.obtenerUsuario(1L);
		Assertions.assertEquals(esperado,resultado);
	//	Assertions.assertTrue(true);
	//	Assertions.assertFalse(false);
	//	Assertions.fail();
		
	}
	@DisplayName("obtener usuario")
	
	@Test
	public void test4() {
		
		UsuarioDto esperado = new UsuarioDto(0L, "Prueba");
		final UsuarioDto resultado = 
				usuarioServicio.obtenerUsuario(0L);
		Assertions.assertEquals(esperado,resultado);
	//	Assertions.assertTrue(true);
	//	Assertions.assertFalse(false);
	//	Assertions.fail();
		
	}
}
