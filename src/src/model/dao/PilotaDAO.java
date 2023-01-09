package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import model.entity.Pilota;
import model.entity.Utente;

public class PilotaDAO {
	public static void doSave(Pilota pilota) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO pilota" +
				"(fk_utente, punteggio, numvittorie, numpole, numpiazz,"
				+ " numritiri) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, pilota.getId());
			preparedStatement.setInt(2, pilota.getPunteggio());
			preparedStatement.setInt(3, pilota.getNumeroVittorie());
			preparedStatement.setInt(4, pilota.getNumeroPole());
			preparedStatement.setInt(5, pilota.getNumeroPiazzamenti());
			preparedStatement.setInt(6, pilota.getNumeroRitiri());
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();
		
			connection.commit();

		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}	
	}
	
	public static Pilota doRetrieveByPilota(Pilota pilota) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = " SELECT * FROM pilota WHERE fk_utente = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, pilota.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				pilota.setPunteggio(rs.getInt("punteggio"));
				pilota.setNumeroVittorie(rs.getInt("numvittorie"));
				pilota.setNumeroPole(rs.getInt("numpole"));
				pilota.setNumeroPiazzamenti(rs.getInt("numpiazz"));
				pilota.setNumeroRitiri(rs.getInt("numritiri"));
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
		return pilota;
	}
	
	
	public static Collection<Pilota> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Pilota> piloti = new ArrayList<Pilota>();
		Utente utente = new Utente();
		String selectSQL = " SELECT * FROM pilota";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Pilota pilota = new Pilota();
				utente = UtenteDAO.doRetrieveByKey(rs.getString("fk_utente"));
				pilota.setNome(utente.getNome());
				pilota.setCognome(utente.getCognome());
				pilota.setId(rs.getString("fk_utente"));
				pilota.setPunteggio(rs.getInt("punteggio"));
				pilota.setNumeroVittorie(rs.getInt("numvittorie"));
				pilota.setNumeroPole(rs.getInt("numpole"));
				pilota.setNumeroPiazzamenti(rs.getInt("numpiazz"));
				pilota.setNumeroRitiri(rs.getInt("numritiri"));
				piloti.add(pilota);			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return piloti;
	}
	
	

	

}
