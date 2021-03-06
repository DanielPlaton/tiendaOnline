package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios implements java.io.Serializable {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "id_rol", nullable = true)
	private int roles;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "clave", nullable = true)
	private String clave;
	@Column(name = "nombre", nullable = true)
	private String nombre;
	@Column(name = "apellido1", nullable = true)
	private String apellido1;
	@Column(name = "apellido2", nullable = true)
	private String apellido2;
	@Column(name = "direccion", nullable = true)
	private String direccion;
	@Column(name = "localidad", nullable = true)
	private String localidad;
	@Column(name = "provincia", nullable = true)
	private String provincia;
	@Column(name = "telefono", nullable = true)
	private String telefono;
	@Column(name = "dni", nullable = true)
	private String dni;

	public Usuarios() {
	}

	public Usuarios(int roles, String email, String clave, String nombre, String apellido1, String apellido2,
			String direccion, String localidad, String provincia, String telefono, String dni) {
		this.roles = roles;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.dni = dni;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoles() {
		return this.roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", roles=" + roles + ", email=" + email + ", clave=" + clave + ", nombre="
				+ nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", telefono=" + telefono + ", dni=" + dni
				+ "]";
	}

	
}
