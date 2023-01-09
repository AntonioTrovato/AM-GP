package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.entity.Rettilineo;

public class RettilineoDAO {
	
	public static Collection<Rettilineo> doRetrieveAllByCircuito(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Rettilineo> beanCollection = new ArrayList<Rettilineo>();
		String selectSQL = " SELECT * FROM rettilineo WHERE fk_circuito = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Rettilineo bean = new Rettilineo();
				bean.setId(rs.getInt("idrettilineo"));
				bean.setNome(rs.getString("nome"));
				bean.setLunghezza(rs.getDouble("lunghezza"));
				beanCollection.add(bean);
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
		return beanCollection;
	}


}
