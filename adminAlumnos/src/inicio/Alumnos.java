package inicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import conf.ConexionDB;

public class Alumnos {

	public void mostrarMenuAlum() {
			Scanner in=new Scanner(System.in);
			
			List<String> menuAlum=new ArrayList<String>();
			
			menuAlum.add("------------Módulo alumnos-----------");
			menuAlum.add("Elija alguna opción: ingrese 1, 2, 3 o 0");
			menuAlum.add("[1] Listar Alumnos");
			menuAlum.add("[2] Modificar Alumnos");
			menuAlum.add("[3] Eliminar Alumnos");
			menuAlum.add("[4] Crear Alumnos");
			menuAlum.add("[5] Materias por Alumno");
			menuAlum.add("[9] Volver al menu principal");
			menuAlum.add("--------------------------------------");
			
			
			int opcion;
			System.out.println("\n");
			do {
				for (String op : menuAlum) {
				System.out.println(op);
				}
				opcion=in.nextInt();
				
				switch (opcion) {
				case 1:

					listarAlumnos(in);
					System.out.println("\n\n\n\n");
					break;
				case 2:
					modificarAlumnos(in);
					System.out.println("\n\n\n\n");
					break;
				case 3:
					eliminarAlumnos(in);
					System.out.println("\n\n\n\n");
					break;
				case 4:
					altaAlumnos(in);
					System.out.println("\n\n\n\n");
					break;
				case 5:
					materiasAlumnos(in);
					System.out.println("\n\n\n\n");
					break;
				case 9:
					
					break;

				default:
					System.err.println("opcion incorrecta, vuelva a ingresar");
					break;
				}
			}	while (opcion!=9);

		}
	
	
		public void listarAlumnos(Scanner in) {
			
			List<Alumno> listAlum=new ArrayList<Alumno>();
			
			ConexionDB con=new ConexionDB();
			Statement st=con.conectar();
			ResultSet rs;
			try {
				rs = st.executeQuery("SELECT * FROM `alumnos`");
				while (rs.next()) {
					Alumno alumn=new Alumno();
					alumn.setId(rs.getInt("id"));
					alumn.setNombre(rs.getString("nombre"));
					alumn.setApellido(rs.getString("apellido"));
					alumn.setDni(rs.getInt("dni"));
					alumn.setEmail(rs.getString("email"));
					listAlum.add(alumn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			
			System.out.println("\n\n\n\n");
			System.out.println("-----------------------Listado de Alumnos------------------------");
			System.out.println("");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			
			String outAlum=new String();
			for (Alumno alumno : listAlum) {
				System.out.println("    " + alumno.getId() + "     " + alumno.getNombre() + "      " + alumno.getApellido() + "       " + alumno.getDni() +"       "+ alumno.getEmail());
			}
			System.out.println("----------------------------------------------------");
			
			System.out.println("¿Desea buscar alumnos Y/N?");
			String busc=in.next();
			if (busc.equals("Y")) {
				listAlum=buscarAlumnos(in, st);
			}
			
		}
		
		
		public void modificarAlumnos(Scanner in) {
			ConexionDB con=new ConexionDB();
			Statement st=con.conectar();
			
			System.out.println("\n\n\n\n\n");
			System.out.println("------------Modificar Alumno------------");
			List<Alumno> listAlum=buscarAlumnos(in, st);
			System.out.println("Ingrese el id del alumno a modificar");
			int id=in.nextInt();
				
			try {
				for (Alumno alumno : listAlum) {
					if(alumno.getId()==id) {
						System.out.println("Ingrese los datos del alumno a modificar");
						System.out.println("Nombre: " + alumno.getNombre());
						String nombre=in.next();
						System.out.println("Apellido: " + alumno.getApellido());
						String apellido=in.next();
						System.out.println("Dni: " + alumno.getDni());
						String dni=in.next();
						System.out.println("Email: " + alumno.getEmail());
						String email=in.next();
						int updateOk=st.executeUpdate("UPDATE alumnos SET nombre='"+nombre+"', apellido='"+apellido+"', dni='"+dni+"', email='"+email+"' WHERE id="+id);
						if (updateOk==1) {
							System.out.println("El alumno se modifico correctamente");
						} else {
							System.err.println("No se pudo modificar el alumno");
						}
					}else {
						System.err.println("No se pudo modificar el alumno");
					}
				}	
			} 	catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("No se pudo modificar el alumno");
			}
		}
		
		
		public void eliminarAlumnos(Scanner in) {
			ConexionDB con=new ConexionDB();
			Statement st=con.conectar();
			
			System.out.println("\n\n\n\n");
			System.out.println("-----------------------Eliminar Alumnos------------------------");
			buscarAlumnos(in, st);
			System.out.println("Ingrese el id del alumno a eliminar");
			int id=in.nextInt();
			
			try {
				int deleteOk=st.executeUpdate("Delete FROM `alumnos` WHERE id="+id);
				if (deleteOk==1) {
					System.out.println("El alumno se elimino correctamente");
				} else {
					System.err.println("No se pudo eliminar el alumno");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("No se pudo eliminar el alumno");
			}

		}
		
		
		
		public void altaAlumnos(Scanner in) {
			System.out.println("\n\n\n\n");
			System.out.println("------------------Alta de Alumno----------------");
			System.out.println("");
			System.out.println("--------|---------|-----------|---------------------");
			System.out.println("Ingrese los datos del alumno");
			System.out.println("Nombre:");
			String nombre=in.next();
			System.out.println("Apellido:");
			String apellido=in.next();
			System.out.println("Dni:");
			int dni=in.nextInt();
			System.out.println("Email:");
			String email=in.next();
			
			ConexionDB con=new ConexionDB();
			Statement st=con.conectar();
			try {
				int insOk = st.executeUpdate("INSERT INTO alumnos (nombre, apellido, dni, email) VALUES ('" + nombre + "','" + apellido + "'," + dni + ",'" + email + "')");
				if (insOk==1) {
					System.out.println("El alumno se agregó correctamente");
				} else {
					System.err.println("ERROR: el alumno no se pudo agregar, contactesé con el administrador");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("ERROR: el alumno no se pudo agregar, contactesé con el administrador");
			}
			
			
		}
		
		
		public void materiasAlumnos(Scanner in) {
			System.out.println("upd materias por alumnos");
		}
		
		public List<Alumno> buscarAlumnos(Scanner in, Statement st) {
			List<Alumno> listAlum=new ArrayList<Alumno>();
			ResultSet rs;
			
			System.out.println("¿Por que campo desea buscar el alumno?");
			System.out.println("1-nombre, 2-apellido, 3-dni");
			int op=in.nextInt();
			
			switch (op) {
			case 1:
				System.out.println("Ingrese el nombre a buscar");
				String nom=in.next();
				try {
					rs = st.executeQuery("SELECT * FROM `alumnos` WHERE nombre LIKE '"+nom+"%' ");
					while (rs.next()) {
						Alumno alumn=new Alumno();
						alumn.setId(rs.getInt("id"));
						alumn.setNombre(rs.getString("nombre"));
						alumn.setApellido(rs.getString("apellido"));
						alumn.setDni(rs.getInt("dni"));
						alumn.setEmail(rs.getString("email"));
						listAlum.add(alumn);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("--------|---------|-----------|-------------|--------------------");
				System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
				System.out.println("--------|---------|-----------|-------------|--------------------");
				

				for (Alumno alumno : listAlum) {
					System.out.println("    " + alumno.getId() + "     " + alumno.getNombre() + "      " + alumno.getApellido() + "       " + alumno.getDni() +"       "+ alumno.getEmail());
				}
				
				System.out.println("----------------------------------------------------");
				break;
			case 2:
				System.out.println("Ingrese el apellido a buscar");
				String ape=in.next();
				try {
					rs = st.executeQuery("SELECT * FROM `alumnos` WHERE apellido LIKE '"+ape+"%' ");
					while (rs.next()) {
						Alumno alumn=new Alumno();
						alumn.setId(rs.getInt("id"));
						alumn.setNombre(rs.getString("nombre"));
						alumn.setApellido(rs.getString("apellido"));
						alumn.setDni(rs.getInt("dni"));
						alumn.setEmail(rs.getString("email"));
						listAlum.add(alumn);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("--------|---------|-----------|-------------|--------------------");
				System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
				System.out.println("--------|---------|-----------|-------------|--------------------");
				

				for (Alumno alumno : listAlum) {
					System.out.println("    " + alumno.getId() + "     " + alumno.getNombre() + "      " + alumno.getApellido() + "       " + alumno.getDni() +"       "+ alumno.getEmail());
				}
				
				System.out.println("----------------------------------------------------");
				break;
			case 3:
				System.out.println("Ingrese el dni a buscar");
				String dni=in.next();
				try {
					rs = st.executeQuery("SELECT * FROM `alumnos` WHERE dni LIKE '"+dni+"%' ");
					while (rs.next()) {
						Alumno alumn=new Alumno();
						alumn.setId(rs.getInt("id"));
						alumn.setNombre(rs.getString("nombre"));
						alumn.setApellido(rs.getString("apellido"));
						alumn.setDni(rs.getInt("dni"));
						alumn.setEmail(rs.getString("email"));
						listAlum.add(alumn);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("--------|---------|-----------|-------------|--------------------");
				System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
				System.out.println("--------|---------|-----------|-------------|--------------------");
				

				for (Alumno alumno : listAlum) {
					System.out.println("    " + alumno.getId() + "     " + alumno.getNombre() + "      " + alumno.getApellido() + "       " + alumno.getDni() +"       "+ alumno.getEmail());
				}
				
				System.out.println("----------------------------------------------------");
			}
			return listAlum;
		}		
}
