package dao;

import javax.sql.DataSource; 

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.hibernate.SessionFactory;
import org.postgresql.ds.common.BaseDataSource;

public class CustomDao {
	private DataSource dataSource;
	private Connection connection;
	private SessionFactory sessionFactory;
	
	public CustomDao()throws Exception{}
	
	public CustomDao(DataSource _dataSource)throws Exception{dataSource = _dataSource;connection = _dataSource.getConnection();}
	
	public BaseDataSource getPostgresqlDataSource() throws Exception{
		DelegatingDataSource c = ((DelegatingDataSource)dataSource);
		if(c.isWrapperFor(org.postgresql.ds.common.BaseDataSource.class));
		{
			return ((BaseDataSource) c.getConnection());
		}
	}
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public DataSource getDataSource(){
		return this.dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource ds){
		this.dataSource = ds;
		try {
		if(connection == null || !connection.isClosed()){
			connection = dataSource.getConnection();
			}
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	public Connection getDataBaseConnection()throws Exception{
		return connection;
	}

	public CallableStatement getCallableStatement(String sql)throws Exception{
		CallableStatement cs = connection.prepareCall(String.format("%s", sql));
	
		return cs;
	}
	
	public PreparedStatement getPreparedStatement(String sql)throws Exception{
		PreparedStatement ps = connection.prepareStatement(String.format("%s", sql));
		return ps;
	}
	
	public Statement getStatement(String sql)throws Exception{
		Statement s = connection.createStatement();
		return s;
	}
	
}
