package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modelo.Credencial;

public class CredencialDAO  {

	Connection con;
	private PreparedStatement ps;
	 private ResultSet rs;

	public CredencialDAO(Connection con) {
		
			this.con = con;
	}

	public boolean autenticarUsuario(String usuario,String password) {
		String consulta = "SELECT COUNT(*) FROM credenciales WHERE usuario =? AND contrasena=?";
		try(PreparedStatement ps=con.prepareStatement(consulta)){
			ps.setString(1,"usuario");
			ps.setString(2, "password");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
		}
	

}

