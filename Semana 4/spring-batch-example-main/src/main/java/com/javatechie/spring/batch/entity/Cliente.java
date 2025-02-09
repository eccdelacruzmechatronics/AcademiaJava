package com.javatechie.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @Column(name = "customer_id")
    private int id;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "pais")
    private String pais;
    @Column(name = "fecha_nacimiento")
  //  @JsonProperty("fecha_nacimiento") 
    private String fechaNacimiento;
    
	public Cliente(int id, String nombre, String apellido, String correo, String genero, String telefono,
			String pais, String fechaNacimiento) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.correo = correo;
		this.genero = genero;
		this.telefono = telefono;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Cliente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getfechaNacimiento() {
		return fechaNacimiento;
	}

	public void setfechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", genero=" + genero + ", telefon=" + telefono + ", pais=" + pais + ", fecha de nacimiento=" + fechaNacimiento + "]";
	}
	

}
