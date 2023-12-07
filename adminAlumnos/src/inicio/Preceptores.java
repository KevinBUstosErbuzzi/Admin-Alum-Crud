package inicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Preceptores {

	public void mostarMenuPreceptores() {
		Scanner in=new Scanner(System.in);
		int opcion;
		List<String> menuPre=new ArrayList<String>();
		menuPre.add("------------Módulo Preceptores-----------");
		menuPre.add("Elija alguna opción: ingrese 1, 2, 3 o 0");
		menuPre.add("[1] Listar Preceptores");
		menuPre.add("[2] Modificar Preceptores");
		menuPre.add("[3] Eliminar Preceptores");
		menuPre.add("[4] Crear Preceptores");
		menuPre.add("[5] Alumnos por Preceptores");
		menuPre.add("[9] Volver al menu principal");
		menuPre.add("-----------------------------------------");
		
		System.out.println("\n\n\n\n");
		
		do {
			for (String op : menuPre) {
			System.out.println(op);
			}
			opcion=in.nextInt();
			
			switch (opcion) {
			case 1:

				listarPreceptores(in);
				System.out.println("\n\n\n\n");
				break;
			case 2:
				modificarPreceptores(in);
				System.out.println("\n\n\n\n");
				break;
			case 3:
				eliminarPreceptores(in);
				System.out.println("\n\n\n\n");
				break;
			case 4:
				AltaPreceptores(in);
				System.out.println("\n\n\n\n");
				break;
			case 5:
				AlumnosporPreceptores();
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
	public void listarPreceptores(Scanner in) {
		
		List<Preceptor> listPrece=new ArrayList<Preceptor>();
		
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		ResultSet rs;
		
		try {
			rs = st.executeQuery("SELECT * FROM `preceptores`");
			while (rs.next()) {
				Preceptor Prece=new Preceptor();
				Prece.setId(rs.getInt("id"));
				Prece.setNombre(rs.getString("nombre"));
				Prece.setApellido(rs.getString("apellido"));
				Prece.setDni(rs.getInt("dni"));
				Prece.setEmail(rs.getString("email"));
				listPrece.add(Prece);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		System.out.println("\n\n\n\n");
		System.out.println("------------------Listado de Preceptores----------------");
		System.out.println("");
		System.out.println("--------|---------|-----------|---------------------");
		System.out.println("  id    | nombre  | apellido  |       email         ");
		String outPrece=new String();
		for (Preceptor Prece : listPrece) {
			System.out.println("  " + Prece.getId() + "       " + Prece.getNombre() + "      " + Prece.getApellido() + "       " + Prece.getEmail());
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("Ingrese un número para continuar");
		int cont=in.nextInt();
	}
	
	
	public void modificarPreceptores(Scanner in) {
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		
		System.out.println("\n\n\n\n\n");
		System.out.println("------------Modificar Preceptor------------");
		List<Preceptor> listPrece=buscarPreceptores(in, st);
		System.out.println("Ingrese el id del preceptor a modificar");
		int id=in.nextInt();
			
		try {
			for (Preceptor Prece : listPrece) {
				if(Prece.getId()==id) {
					System.out.println("Ingrese los datos del preceptor a modificar");
					System.out.println("Nombre: " + Prece.getNombre());
					String nombre=in.next();
					System.out.println("Apellido: " + Prece.getApellido());
					String apellido=in.next();
					System.out.println("Dni: " + Prece.getDni());
					String dni=in.next();
					System.out.println("Email: " + Prece.getEmail());
					String email=in.next();
					int updateOk=st.executeUpdate("UPDATE preceptores SET nombre='"+nombre+"', apellido='"+apellido+"', dni='"+dni+"', email='"+email+"' WHERE id="+id);
					if (updateOk==1) {
						System.out.println("El preceptor se modifico correctamente");
					} else {
						System.err.println("No se pudo modificar el preceptor");
					}
				}else {
					System.err.println("No se pudo modificar el preceptor");
				}
			}	
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("No se pudo modificar el preceptor");
		}
	}
	
	
	public void eliminarPreceptores(Scanner in) {
		ConexionDB db=new ConexionDB();
		Statement st=db.conectar();
		
		System.out.println("\n\n\n\n");
		System.out.println("-----------------------Eliminar Preceptores------------------------");
		buscarPreceptores(in, st);	
		System.out.println("Ingrese el id del preceptor a eliminar");
		int id=in.nextInt();
		
		try {
			int deleteOk=st.executeUpdate("Delete FROM `preceptores` WHERE id="+id);
			if (deleteOk==1) {
				System.out.println("El preceptor se elimino correctamente");
			} else {
				System.err.println("No se pudo eliminar el preceptor, contactese con el administrador");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("No se pudo eliminar el preceptor, contactese con el administrador");
		}

	}
		
	
	
	public void AltaPreceptores(Scanner in) {
		System.out.println("\n\n\n\n");
		System.out.println("------------------Alta de Preceptor----------------");
		System.out.println("");
		System.out.println("--------|---------|-----------|---------------------");
		System.out.println("Ingrese los datos del preceptor");
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
			int insOk = st.executeUpdate("INSERT INTO preceptores (nombre, apellido, dni, email) VALUES ('" + nombre + "','" + apellido + "'," + dni + ",'" + email + "')");
			if (insOk==1) {
				System.out.println("El preceptor se agregó correctamente");
			} else {
				System.out.println("ERROR: el preceptor no se pudo cargar, contactesé con");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void AlumnosporPreceptores() {
		System.out.println("upd alumnos por Preceptores");
	}
	
	public List<Preceptor> buscarPreceptores (Scanner in, Statement st) {
		List<Preceptor> listPrece=new ArrayList<Preceptor>();
		ResultSet rs;
		System.out.println("");
		System.out.println("¿Por que campo desea buscar el preceptor?");
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op=in.nextInt();

		switch (op) {
		case 1:
			System.out.println("Ingrese el nombre a buscar");
			String nom=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `preceptores` WHERE nombre LIKE '"+nom+"%' ");
				while (rs.next()) {
					Preceptor Prece=new Preceptor();
					Prece.setId(rs.getInt("id"));
					Prece.setNombre(rs.getString("nombre"));
					Prece.setApellido(rs.getString("apellido"));
					Prece.setDni(rs.getInt("dni"));
					Prece.setEmail(rs.getString("email"));
					listPrece.add(Prece);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Preceptor Prece : listPrece) {
				System.out.println("  " + Prece.getId() + "       " + Prece.getNombre() + "      " + Prece.getApellido() + "       " + Prece.getDni() + "       "  + Prece.getEmail());
			}
			System.out.println("----------------------------------------------------");
			break;
		case 2:
			System.out.println("Ingrese el apellido a buscar");
			String ape=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `preceptores` WHERE apellido LIKE '"+ape+"%' ");
				while (rs.next()) {
					Preceptor Prece=new Preceptor();
					Prece.setId(rs.getInt("id"));
					Prece.setNombre(rs.getString("nombre"));
					Prece.setApellido(rs.getString("apellido"));
					Prece.setDni(rs.getInt("dni"));
					Prece.setEmail(rs.getString("email"));
					listPrece.add(Prece);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Preceptor Prece : listPrece) {
				System.out.println("  " + Prece.getId() + "       " + Prece.getNombre() + "      " + Prece.getApellido() + "       " + Prece.getDni() + "       "  + Prece.getEmail());
			}
			System.out.println("----------------------------------------------------");
			break;
		case 3:
			System.out.println("Ingrese el dni a buscar");
			String dni=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `preceptores` WHERE apellido LIKE '"+dni+"%' ");
				while (rs.next()) {
					Preceptor Prece=new Preceptor();
					Prece.setId(rs.getInt("id"));
					Prece.setNombre(rs.getString("nombre"));
					Prece.setApellido(rs.getString("apellido"));
					Prece.setDni(rs.getInt("dni"));
					Prece.setEmail(rs.getString("email"));
					listPrece.add(Prece);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("--------|---------|-----------|-------------|--------------------");
			System.out.println("   id   | nombre  | apellido  |   dni       |      email         ");
			System.out.println("--------|---------|-----------|-------------|--------------------");
			

			for (Preceptor Prece : listPrece) {
				System.out.println("  " + Prece.getId() + "       " + Prece.getNombre() + "      " + Prece.getApellido() + "       " + Prece.getDni() + "       "  + Prece.getEmail());
			}
			System.out.println("----------------------------------------------------");
		}
		return listPrece;
	}
}
