package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.entity.Circuito;

public class CircuitoDAO {

	public static Circuito doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Circuito circuito = new Circuito();
		String selectSQL = " SELECT * FROM circuito WHERE idcircuito = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				circuito.setNome(rs.getString("nome"));
				circuito.setId(rs.getInt("idcircuito"));
				circuito.setSede(rs.getString("sede"));
				circuito.setLunghezza(rs.getLong("lunghezza"));
				circuito.setMeteo(rs.getString("meteo"));
				circuito.setTpm(rs.getLong("tpm"));
				circuito.setRpm(rs.getLong("rpm"));
				circuito.setUmidita(rs.getLong("umidita"));
				circuito.setNumeroGiri(rs.getInt("ngiri"));
				circuito.setNome(rs.getString("nome"));
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
		return circuito;
	}

	public static Collection<Circuito> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Circuito> circuiti = new ArrayList<Circuito>();
		String selectSQL = " SELECT * FROM circuito";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Circuito circuito = new Circuito();
				circuito.setNome(rs.getString("nome"));
				circuito.setId(rs.getInt("idcircuito"));
				circuito.setSede(rs.getString("sede"));
				circuito.setLunghezza(rs.getLong("lunghezza"));
				circuito.setMeteo(rs.getString("meteo"));
				circuito.setTpm(rs.getLong("tpm"));
				circuito.setRpm(rs.getLong("rpm"));
				circuito.setUmidita(rs.getLong("umidita"));
				circuito.setNumeroGiri(rs.getInt("ngiri"));
				circuito.setNome(rs.getString("nome"));
				circuiti.add(circuito);
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
		return circuiti;
	}
	
	
	
	

	
	
	

	public synchronized byte[]load(String id) throws SQLException
	{
		Connection connection=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		
		String sql="SELECT foto FROM circuito where idcircuito= ?";
		
		byte[] foto=null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			stat=connection.prepareStatement(sql);
			stat.setString(1, id);
			
			rs=stat.executeQuery();
			
			if(rs.next())
			{
				foto=rs.getBytes("foto");
			}
			
		} finally {
			try {
				if (stat != null)
					stat.close();
			} finally {
				if(connection!=null)
					connection.close();
			}
		}
		return foto;
	}
	
	
}
