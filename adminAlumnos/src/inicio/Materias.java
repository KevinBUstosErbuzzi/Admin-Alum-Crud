package inicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Materias {

	public void mostrarMenuMat() {
		
		Scanner in=new Scanner(System.in);
		int opcion;
		List<String> menuMat=new ArrayList<String>();
		menuMat.add("------------Módulo Materias-----------");
		menuMat.add("Elija alguna opción: ingrese 1, 2, 3 o 0");
		menuMat.add("[1] Listar Materias");
		menuMat.add("[2] Modificar Materias");
		menuMat.add("[3] Eliminar Materias");
		menuMat.add("[4] Crear Materias");
		menuMat.add("[5] Alumnos por Materias");
		menuMat.add("[9] Volver al menu principal");
		menuMat.add("---------------------------------------");
		
		System.out.println("\n\n\n\n");
		
		do {
			for (String op : menuMat) {
			System.out.println(op);
			}
			opcion=in.nextInt();
			
			switch (opcion) {
			case 1:

				listarMaterias(in);
				System.out.println("\n\n\n\n");
				break;
			case 2:
				modificarMaterias(in);
				System.out.println("\n\n\n\n");
				break;
			case 3:
				eliminarMaterias(in);
				System.out.println("\n\n\n\n");
				break;
			case 4:
				AltaMaterias(in);
				System.out.println("\n\n\n\n");
				break;
			case 5:
				Alumnospormaterias();
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
	
	
	public void listarMaterias(Scanner in) {
		List<Materia> listMat=new ArrayList<Materia>();
		
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		ResultSet rs;
		
		try {
			rs = st.executeQuery("SELECT * FROM `materias`");
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
		
		System.out.println("\n\n\n\n");
		System.out.println("--------Listado de Materias----------");
		System.out.println("");
		System.out.println("--------|---------|----------------");
		System.out.println("  id    | nombre  |   idProfesor   ");
		System.out.println("--------|---------|----------------");
		String outMat=new String();
		for (Materia Mat : listMat) {
			System.out.println("  " + Mat.getId() + "       " + Mat.getNombre() + "      " + Mat.getIdProfesor());
		}
		System.out.println("--------------------------------------");
		System.out.println("Ingrese un número para continuar");
		int cont=in.nextInt();
	}
	
	
	public void modificarMaterias(Scanner in) {
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		
		System.out.println("\n\n\n\n\n");
		System.out.println("------------Modificar Materia------------");
		List<Materia> listMat=buscarMaterias(in, st);
		System.out.println("Ingrese el id de la materia");
		int id=in.nextInt();
			
		try {
			for (Materia Mat : listMat) {
				if(Mat.getId()==id) {
					System.out.println("Ingrese los datos de la materia a modificar");
					System.out.println("Nombre: " + Mat.getNombre());
					String nombre=in.next();
					int updateOk=st.executeUpdate("UPDATE materias SET nombre='"+nombre+"' WHERE id="+id);
					if (updateOk==1) {
						System.out.println("La materia se modifico correctamente");
					} else {
						System.err.println("No se pudo modificar la materia");
					}
				}else {
					System.err.println("No se pudo modificar la materia");
				}
			}	
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("No se pudo modificar la materia");
		}
	}
	
	
	public void eliminarMaterias(Scanner in) {
		ConexionDB con=new ConexionDB();
		Statement st=con.conectar();
		
		System.out.println("\n\n\n\n");
		System.out.println("-----------------------Eliminar Materias------------------------");
		buscarMaterias (in, st);
		System.out.println("Ingrese el id de la materia");
		int id=in.nextInt();
		
		try {
			int deleteOk=st.executeUpdate("Delete FROM `materias` WHERE id="+id);
			if (deleteOk==1) {
				System.out.println("La materia se elimino correctamente");
			} else {
				System.err.println("No se pudo eliminar la materia, contactese con el administrador");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("No se pudo eliminar la materia, contactese con el administrador");
		}

	}
	
	
	
	public void AltaMaterias(Scanner in) {
		System.out.println("\n\n\n\n");
		System.out.println("------------------Alta de Materia----------------");
		System.out.println("");
		System.out.println("--------|---------|-----------|---------------------");
		System.out.println("Ingrese el nombre de la materia");
		System.out.println("Materia:");
		String nombre=in.next();
		
		ConexionDB db=new ConexionDB();
		Statement st=db.conectar();
		try {
			int insOk = st.executeUpdate("INSERT INTO materias (nombre) VALUES ('" + nombre + "')");
			if (insOk==1) {
				System.out.println("La materia se agregó correctamente");
			} else {
				System.out.println("ERROR: La materia no se pudo cargar, contactesé con");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void Alumnospormaterias() {
		System.out.println("upd alumnos por materias");
	}
	
	public List<Materia> buscarMaterias (Scanner in, Statement st) {
		List<Materia> listMat=new ArrayList<Materia>();
		ResultSet rs;
		System.out.println("");
		System.out.println("¿Por que campo desea buscar la materia?");
		System.out.println("1-id, 2-nombre");
		int op=in.nextInt();
		
		switch (op) {
		case 1:
			
			break;

		case 2:
			System.out.println("Ingrese el nombre a buscar");
			String nom=in.next();
			try {
				rs = st.executeQuery("SELECT * FROM `materias` WHERE nombre LIKE '"+nom+"%' ");
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
			
			
			System.out.println("--------|---------|----------------");
			System.out.println("  id    | nombre  |   idProfesor   ");
			System.out.println("--------|---------|----------------");
			

			for (Materia Materia : listMat) {
				System.out.println("  " + Materia.getId() + "       " + Materia.getNombre() + "      " + Materia.getIdProfesor());
			}
			System.out.println("----------------------------------------------------");
		}
		return listMat;
	}
}
