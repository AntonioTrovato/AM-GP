package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Curva;

public class CurvaDAO {
	
	public static ArrayList<Curva> doRetrieveAllByCircuito(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Curva> curve = new ArrayList<Curva>();
		String selectSQL = " SELECT * FROM curva WHERE fk_circuito = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Curva curva = new Curva();
				curva.setId(rs.getInt("idcurva"));
				curva.setNome(rs.getString("nome"));
				curva.setAngolo(rs.getFloat("angolo"));
				curve.add(curva);
			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return curve;
	}
}
