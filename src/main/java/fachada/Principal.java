package fachada;

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
	private static Controlador controlador = Controlador.getServicios();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ViveroFachada portal = ViveroFachada.getPortal();
		
		ViveroFachada.getPortal().MenuInicial();
		
		
	
	}

}
