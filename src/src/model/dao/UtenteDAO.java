package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.entity.Setup;
import model.entity.Tecnico;
import model.entity.Utente;

public class UtenteDAO {
	public static Utente doRetrieveByKey(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Utente utente = new Utente();
		String selectSQL = " SELECT * FROM utente WHERE id = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				utente.setId(rs.getString("id"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setPassword(rs.getString("password"));
				utente.setRuolo(rs.getString("ruolo"));
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
		return utente;
	}
	
	public static boolean match(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = " SELECT * FROM utente WHERE id = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return true;
			}
			else return false;
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	

	public static boolean doValidate(String id, String password) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String sql="SELECT password FROM utente WHERE id=?";
			try {
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				ResultSet rs=preparedStatement.executeQuery();
				if(rs.next()){
					if(rs.getString("password").equals(password))
						return true;
				}
			}
			finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if(connection!=null)
						connection.close();
				}
			}
			
			return false;
	}
	
	
	
	public static Collection<Utente> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Utente> utenti = new ArrayList<Utente>();
		String selectSQL = " SELECT * FROM utente";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Utente utente = new Utente();
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setId(rs.getString("id"));
				utente.setRuolo(rs.getString("ruolo"));
				utenti.add(utente);			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utenti;
	}
	
	public static Collection<Tecnico> doRetrieveAllTecnico() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Tecnico> tecnici = new ArrayList<Tecnico>();
		Collection<Setup> setupList = new ArrayList<Setup>();
		String selectSQL = " SELECT * FROM utente where ruolo = 'tecnico'";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Tecnico tecnico = new Tecnico();
				tecnico.setNome(rs.getString("nome"));
				tecnico.setCognome(rs.getString("cognome"));
				tecnico.setId(rs.getString("id"));
				tecnico.setRuolo(rs.getString("ruolo"));
				setupList = SetupDAO.doRetrieveByTecnico(tecnico);
				tecnico.setSetupList(setupList);
				tecnici.add(tecnico);			
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
		return tecnici;
	}	
}
