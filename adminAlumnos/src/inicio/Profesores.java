package inicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Profesores {

	public void mostrarMenuProf() {

		Scanner in=new Scanner(System.in);
		int opcion;
		List<String> menuProf=new ArrayList<String>();
		menuProf.add("------------Módulo Profesores-----------");
		menuProf.add("Elija alguna opción: ingrese 1, 2, 3 o 0");
		menuProf.add("[1] Listar Profesores");
		menuProf.add("[2] Modificar Profesores");
		menuProf.add("[3] Eliminar Profesores");
		menuProf.add("[4] Crear Profesores");
		menuProf.add("[5] Materias por Profesores");
		menuProf.add("[9] Volver al menu principal");
		menuProf.add("----------------------------------------");
		
		System.out.println("\n\n\n\n");
		
		do {
			for (String op : menuProf) {
			System.out.println(op);
			}
			opcion=in.nextInt();
			
			switch (opcion) {
			case 1:

				listarProfesores(in);
				System.out.println("\n\n\n\n");
				break;
			case 2:
				modificarProfesores(in);
				System.out.println("\n\n\n\n");
				break;
			case 3:
				eliminarProfesores(in);
				System.out.println("\n\n\n\n");
				break;
			case 4:
				AltaProfesores(in);
				System.out.println("\n\n\n\n");
				break;
			case 5:
				materiasProfesores(in);
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
	
	
	public void listarProfesores(Scanner in) {
		
		List<Profesor> listProf=new ArrayList<Profesor>();
		
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		ResultSet rs;
		
		try {
			rs = st.executeQuery("SELECT * FROM `profesores`");
			while (rs.next()) {
				Profesor Prof=new Profesor();
				Prof.setId(rs.getInt("id"));
				Prof.setNombre(rs.getString("nombre"));
				Prof.setApellido(rs.getString("apellido"));
				Prof.setDni(rs.getInt("dni"));
				Prof.setEmail(rs.getString("email"));
				listProf.add(Prof);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n\n");
		System.out.println("------------------Listado de Profesores--------------------------");
		System.out.println("");
		System.out.println("--------|---------|-----------|-------------|--------------------");
		System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
		System.out.println("--------|---------|-----------|-------------|--------------------");
		String outProf=new String();
		for (Profesor Profes : listProf) {
			System.out.println("  " + Profes.getId() + "       " + Profes.getNombre() + "      " + Profes.getApellido() + "       " + Profes.getDni() + "       "  + Profes.getEmail());
		}
		System.out.println("--------|---------|-----------|------------------------");
		System.out.println("Ingrese un número para continuar");
		int cont=in.nextInt();
	}
	
	
	public void modificarProfesores(Scanner in) {
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		
		System.out.println("\n\n\n\n\n");
		System.out.println("------------Modificar Profesor------------");
		List<Profesor> listProf=buscarProfesores(in, st);
		System.out.println("Ingrese el id del profesor a modificar");
		int id=in.nextInt();
			
		try {
			for (Profesor Profes : listProf) {
				if(Profes.getId()==id) {
					System.out.println("Ingrese los datos del profesor a modificar");
					System.out.println("Nombre: " + Profes.getNombre());
					String nombre=in.next();
					System.out.println("Apellido: " + Profes.getApellido());
					String apellido=in.next();
					System.out.println("Dni: " + Profes.getDni());
					String dni=in.next();
					System.out.println("Email: " + Profes.getEmail());
					String email=in.next();
					int updateOk=st.executeUpdate("UPDATE profesores SET nombre='"+nombre+"', apellido='"+apellido+"', dni='"+dni+"', email='"+email+"' WHERE id="+id);
					if (updateOk==1) {
						System.out.println("El profesor se modifico correctamente");
					} else {
						System.err.println("No se pudo modificar el profesor");
					}
				}else {
					System.err.println("No se pudo modificar el profesor");
				}
			}	
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("No se pudo modificar el profesor");
		}
	}
	
	
	public void eliminarProfesores(Scanner in) {
		ConexionDB db=new ConexionDB();
		Statement st=db.conectar();
		
		System.out.println("\n\n\n\n");
		System.out.println("-----------------------Eliminar Profesores------------------------");
		buscarProfesores(in, st);
		System.out.println("Ingrese el id del profesor a eliminar");
		int id=in.nextInt();
		
		try {
			int deleteOk=st.executeUpdate("Delete FROM `profesores` WHERE id="+id);
			if (deleteOk==1) {
				System.out.println("El profesor se elimino correctamente");
			} else {
				System.err.println("No se pudo eliminar el profesor contactese con el administrador");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("No se pudo eliminar el profesor contactese con el administrador");
		}
	
	}
	
	
	public void AltaProfesores(Scanner in) {
		System.out.println("\n\n\n\n");
		System.out.println("------------------Alta de Profesor----------------");
		System.out.println("");
		System.out.println("--------|---------|-----------|---------------------");
		System.out.println("Ingrese los datos del profesor");
		System.out.println("Nombre:");
		String nombre=in.next();
		System.out.println("Apellido:");
		String apellido=in.next();
		System.out.println("Dni:");
		int dni=in.nextInt();
		System.out.println("Email:");
		String email=in.next();
		
		ConexionDB db=new ConexionDB();
		Statement st=db.conectar();
		try {
			int insOk = st.executeUpdate("INSERT INTO profesores (nombre, apellido, dni, email) VALUES ('" + nombre + "','" + apellido + "'," + dni + ",'" + email + "')");
			if (insOk==1) {
				System.out.println("El profesor se agregó correctamente");
			} else {
				System.err.println("ERROR: el profesor no se pudo cargar, contactesé con el administrador");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: el profesor no se pudo cargar, contactesé con el administrador");
		}
	}
	
	
	public void materiasProfesores(Scanner in) {
		List<Materia> listMat=new ArrayList<Materia>();
		ConexionDB db=new ConexionDB();
		Statement st=db.conectar();
		ResultSet rs;
		buscarProfesores(in, st);
		
		System.out.println("Ingrese el id del profesor para buscar las materias dictadas");
		int idProfesor=in.nextInt();
		//todo: buscar en tabla materias idProfesor=id
		try {
			rs = st.executeQuery("SELECT * FROM `materias` WHERE idProfesor = " + idProfesor);
			while (rs.next()) {
				Materia Mat=new Materia();
				Mat.setId(rs.getInt("id"));
				Mat.setNombre(rs.getString("nombre"));
				Mat.setIdProfesor(rs.getInt("idProfesor"));
				listMat.add(Mat);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("--------|-----------|----------------");
		System.out.println("  id    |  nombre   |   idProfesor   ");
		System.out.println("--------|-----------|----------------");
		

		for (Materia Materia : listMat) {
			System.out.println("  " + Materia.getId() + "       " + Materia.getNombre() + "      " + Materia.getIdProfesor());
		}
		System.out.println("-----------------------------------");
		
	}
	

	
	public List<Profesor> buscarProfesores (Scanner in, Statement st) {
		List<Profesor> listProf=new ArrayList<Profesor>();
		ResultSet rs;
		System.out.println("");
		System.out.println("¿Por que campo desea buscar el profesor?");
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op=in.nextInt();
		
		switch (op) {
		case 1:
			System.out.println("Ingrese el nombre a buscar");
			String nom=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `profesores` WHERE nombre LIKE '"+nom+"%' ");
				while (rs.next()) {
					Profesor Prof=new Profesor();
					Prof.setId(rs.getInt("id"));
					Prof.setNombre(rs.getString("nombre"));
					Prof.setApellido(rs.getString("apellido"));
					Prof.setDni(rs.getInt("dni"));
					Prof.setEmail(rs.getString("email"));
					listProf.add(Prof);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Profesor Profes : listProf) {
				System.out.println("  " + Profes.getId() + "       " + Profes.getNombre() + "      " + Profes.getApellido() + "       " + Profes.getDni() + "       "  + Profes.getEmail());
			}

			System.out.println("----------------------------------------------------");
			break;
		case 2:
			System.out.println("Ingrese el apellido a buscar");
			String ape=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `profesores` WHERE apellido LIKE '"+ape+"%' ");
				while (rs.next()) {
					Profesor Prof=new Profesor();
					Prof.setId(rs.getInt("id"));
					Prof.setNombre(rs.getString("nombre"));
					Prof.setApellido(rs.getString("apellido"));
					Prof.setDni(rs.getInt("dni"));
					Prof.setEmail(rs.getString("email"));
					listProf.add(Prof);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Profesor Profes : listProf) {
				System.out.println("  " + Profes.getId() + "       " + Profes.getNombre() + "      " + Profes.getApellido() + "       " + Profes.getDni() + "       "  + Profes.getEmail());
			}

			System.out.println("----------------------------------------------------");
			break;
		case 3:
			System.out.println("Ingrese el dni a buscar");
			String dni=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `profesores` WHERE dni LIKE '"+dni+"%' ");
				while (rs.next()) {
					Profesor Prof=new Profesor();
					Prof.setId(rs.getInt("id"));
					Prof.setNombre(rs.getString("nombre"));
					Prof.setApellido(rs.getString("apellido"));
					Prof.setDni(rs.getInt("dni"));
					Prof.setEmail(rs.getString("email"));
					listProf.add(Prof);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Profesor Profes : listProf) {
				System.out.println("  " + Profes.getId() + "       " + Profes.getNombre() + "      " + Profes.getApellido() + "       " + Profes.getDni() + "       "  + Profes.getEmail());
			}

			System.out.println("----------------------------------------------------");
		}
		return listProf;
	}
}
	

