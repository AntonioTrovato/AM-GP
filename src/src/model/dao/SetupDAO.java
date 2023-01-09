package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.entity.Circuito;
import model.entity.Setup;
import model.entity.Tecnico;

public class SetupDAO {

	
	public static Collection<Setup> doRetrieveByTecnico(Tecnico tecnico) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Setup> beanCollection = new ArrayList<Setup>();
		String selectSQL = " SELECT * FROM setup WHERE userAutore = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, tecnico.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Setup bean = new Setup();
				bean.setId(rs.getInt("idSetup"));
				bean.setCaricoAerodinamicoAnteriore(rs.getDouble("caricoaerodinant"));
				bean.setCaricoAerodinamicoPosteriore(rs.getDouble("caricoaerodinpost"));
				bean.setCampanaturaAnteriore(rs.getDouble("campanaturaant"));
				bean.setCampanaturaPosteriore(rs.getDouble("campanaturaant"));
				bean.setConvergenzaAnteriore(rs.getDouble("convergenzaant"));
				bean.setConvergenzaPosteriore(rs.getDouble("convergenzapost"));
				bean.setPressioneFreni(rs.getDouble("pressionefreni"));
				bean.setBarraAntirollioPosteriore(rs.getDouble("barraantirollpost"));
				bean.setBarraAntirollioAnteriore(rs.getDouble("barraantirollant"));
				bean.setCircuito(CircuitoDAO.doRetrieveByKey(rs.getInt("idCircuito")));
				bean.setDate(rs.getString("date"));
				beanCollection.add(bean);
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
		return beanCollection;
	}
	
	
	
	
	public static void doSave(Setup setup) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LocalDateTime date = LocalDateTime.now();
		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String insertSQL ="INSERT INTO setup (caricoaerodinant, caricoaerodinpost, campanaturaant, campanaturapost, convergenzaant, convergenzapost, pressionefreni, barraantirollant, barraantirollpost, userAutore, idCircuito, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setDouble(1, setup.getCaricoAerodinamicoAnteriore() );
			preparedStatement.setDouble(2, setup.getCaricoAerodinamicoPosteriore());
			preparedStatement.setDouble(3, setup.getCampanaturaAnteriore());
			preparedStatement.setDouble(4, setup.getCampanaturaPosteriore());
			preparedStatement.setDouble(5, setup.getConvergenzaAnteriore());
			preparedStatement.setDouble(6, setup.getConvergenzaPosteriore());
			preparedStatement.setDouble(7, setup.getPressioneFreni());
			preparedStatement.setDouble(8, setup.getBarraAntirollioPosteriore());
			preparedStatement.setDouble(9, setup.getBarraAntirollioAnteriore());
			preparedStatement.setString(10, setup.getAutore().getId());
			preparedStatement.setInt(11, setup.getCircuito().getId());
			preparedStatement.setString(12, date.format(dateFormat));
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
	
	public static void doUpdate(Setup setup) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String insertSQL ="UPDATE setup SET caricoaerodinant=?, caricoaerodinpost=?, campanaturaant=?, campanaturapost=?,"
				+ " convergenzaant= ?, convergenzapost=?, pressionefreni=?, barraantirollant=?, barraantirollpost=?, date= ?"
				+ " WHERE idSetup=?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setDouble(1, setup.getCaricoAerodinamicoAnteriore());
			preparedStatement.setDouble(2, setup.getCaricoAerodinamicoPosteriore());
			preparedStatement.setDouble(3, setup.getCampanaturaAnteriore());
			preparedStatement.setDouble(4, setup.getCampanaturaPosteriore());
			preparedStatement.setDouble(5, setup.getConvergenzaAnteriore());
			preparedStatement.setDouble(6, setup.getConvergenzaPosteriore());
			preparedStatement.setDouble(7, setup.getPressioneFreni());
			preparedStatement.setDouble(8, setup.getBarraAntirollioPosteriore());
			preparedStatement.setDouble(9, setup.getBarraAntirollioAnteriore());
			preparedStatement.setString(10, date.format(dateFormat) );
			preparedStatement.setInt(11, setup.getId());
			System.out.println("doUpdate: "+ preparedStatement.toString());
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
	
	public static void doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL ="DELETE from setup WHERE idSetup= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, id);
			System.out.println("doDelete: "+ preparedStatement.toString());
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
	
	public static Setup doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Setup setup = new Setup();
		String selectSQL = " SELECT * FROM setup WHERE idSetup = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				setup.setId(id);
				setup.setCaricoAerodinamicoAnteriore(rs.getDouble("caricoaerodinant"));
				setup.setCaricoAerodinamicoPosteriore(rs.getDouble("caricoaerodinpost"));
				setup.setCampanaturaAnteriore(rs.getDouble("campanaturaant"));
				setup.setCampanaturaPosteriore(rs.getDouble("campanaturapost"));
				setup.setConvergenzaAnteriore(rs.getDouble("convergenzaant"));
				setup.setConvergenzaPosteriore(rs.getDouble("convergenzapost"));
				setup.setPressioneFreni(rs.getDouble("pressionefreni"));
				setup.setBarraAntirollioAnteriore(rs.getDouble("barraantirollant"));
				setup.setBarraAntirollioPosteriore(rs.getDouble("barraantirollpost"));
				setup.setDate(rs.getString("date"));
				setup.setCircuito((Circuito)(CircuitoDAO.doRetrieveByKey(rs.getInt("idCircuito"))));
		
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
		return setup;
	}
	
	
}
