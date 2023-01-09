package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import model.entity.Messaggio;
import model.entity.Utente;

public class MessaggioDAO {
	public static void doSave(Messaggio messaggio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO messaggio" +
				" (oggetto, corpo, idMittente, idDestinatario) VALUES (?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, messaggio.getOggetto());
			preparedStatement.setString(2, messaggio.getCorpo());
			preparedStatement.setString(3, messaggio.getMittente().getId());
			preparedStatement.setString(4, messaggio.getDestinatario().getId());
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
	
	public static Messaggio doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Messaggio messaggio = new Messaggio();
		String selectSQL = " SELECT * FROM messaggio WHERE idmessaggio = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				messaggio.setCorpo(rs.getString("corpo"));
				messaggio.setOggetto(rs.getString("oggetto"));
				messaggio.setDestinatario(UtenteDAO.doRetrieveByKey(rs.getString("idDestinatario")));
				messaggio.setMittente(UtenteDAO.doRetrieveByKey(rs.getString("idMittente")));
				messaggio.setId(rs.getInt("idmessaggio"));
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
		return messaggio;
	}
	
	public static ArrayList<Messaggio> doRetrieveAllBySender(Utente mittente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Messaggio> messaggiInviati = new ArrayList<Messaggio>();
		String selectSQL = " SELECT * FROM messaggio WHERE idMittente = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, mittente.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Messaggio messaggioInviato = new Messaggio();
				messaggioInviato.setCorpo(rs.getString("corpo"));
				messaggioInviato.setOggetto(rs.getString("oggetto"));
				messaggioInviato.setDestinatario(UtenteDAO.doRetrieveByKey(rs.getString("idDestinatario")));
				messaggioInviato.setMittente(UtenteDAO.doRetrieveByKey(rs.getString("idMittente")));
				messaggioInviato.setId(rs.getInt("idmessaggio"));
				messaggiInviati.add(messaggioInviato);
			}
			connection.commit();
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return messaggiInviati;
	}
	
	public static ArrayList<Messaggio> doRetrieveAllByReceiver(Utente destinatario) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Messaggio> messaggiRicevuti = new ArrayList<Messaggio>();
		String selectSQL = " SELECT * FROM messaggio WHERE idDestinatario = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, destinatario.getId());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Messaggio messaggioRicevuto = new Messaggio();
				messaggioRicevuto.setCorpo(rs.getString("corpo"));
				messaggioRicevuto.setOggetto(rs.getString("oggetto"));
				messaggioRicevuto.setDestinatario(UtenteDAO.doRetrieveByKey(rs.getString("idDestinatario")));
				messaggioRicevuto.setMittente(UtenteDAO.doRetrieveByKey(rs.getString("idMittente")));
				messaggioRicevuto.setId(rs.getInt("idmessaggio"));
				messaggiRicevuti.add(messaggioRicevuto);
			}
			connection.commit();
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return messaggiRicevuti;
	}
}
