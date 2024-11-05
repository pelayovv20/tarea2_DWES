package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

import control.Controlador;
import control.ServiciosPlanta;
import dao.PlantaDAO;
import fachada.ViveroFachada;
import modelo.Planta;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("INI");
		Scanner in = new Scanner(System.in);
		
		//ViveroFachada portal = ViveroFachada.getPortal();
		
		ViveroFachada fachada = new ViveroFachada();
		fachada.mostrarMenuInicial();
		

//		System.out.println("Dame el código de la nueva Planta:");
//		String codigo = in.nextLine().trim().toUpperCase();
//		System.out.println("Dame el nombre común de la nueva planta:");
//		String nombre_comun = in.nextLine();
//		System.out.println("Dame el nombre científico de la nueva planta:");
//		String nombre_cientifico = in.nextLine();
//
//		Planta nueva = new Planta(codigo, nombre_comun, nombre_cientifico);
//		
//		//correcto
//		//ServiciosPlanta servPlanta = new ServiciosPlanta();
//		if(!Controlador.getServicios().getServiciosPlanta().validarPlanta(nueva)) {
//			System.out.println("Los valores introducidos para la planta son incorrectos. Repita el proceso");
//		}
//		
//		//int resultado = Controlador.getServicios().getServiciosPlanta().insertar(nueva);
//		
//		
//		
//
//		Connection con;
//		MysqlDataSource m = new MysqlDataSource();
//		Properties prop = null;
//		FileInputStream fis;
//		String url = "jdbc:mysql://localhost:3306/basededatos";
//		String usuario = "root";
//		String password = "";
//		try {
//			fis = new FileInputStream("src/main/resources/db.properties");
//			prop.load(fis);
//			url = prop.getProperty("url");
//			usuario = prop.getProperty("usuario");
//			password = prop.getProperty("password");
//			m.setUrl(url);
//			m.setUser(usuario);
//			m.setPassword(password);
//			con = m.getConnection();
//			
//			String sql = "INSERT INTO plantas(codigo,nombrecomun,nombrecientifico) VALUES(" + nueva.getCodigo()
//			+ " , " + nueva.getNombrecomun() + " , " + nueva.getNombrecientifico();
//			
//			//ESTA FORMA MEJOR
//			String sql2 = "INSERT INTO plantas(codigo,nombrecomun,nombrecientifico) VALUES(?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql2);
//			ps.setString(1, nueva.getCodigo());
//			ps.setString(2, nueva.getNombrecomun());
//			ps.setString(3, nueva.getNombrecientifico());
//			
//			ps.executeUpdate();
//			ps.close();
//			con.close();
//
//		} catch (SQLException e) {
//			System.out.println("Ha ocurrido un error de SQLException" + e.getLocalizedMessage());
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			System.out.println("Ha ocurrido un error de FileNotFoundException " + e.getLocalizedMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("Ha ocurrido un error de IOException " + e.getLocalizedMessage());
//			e.printStackTrace();
//
//		}

		
		
		
		
		
		
		System.out.println("FIN");
	}

}
