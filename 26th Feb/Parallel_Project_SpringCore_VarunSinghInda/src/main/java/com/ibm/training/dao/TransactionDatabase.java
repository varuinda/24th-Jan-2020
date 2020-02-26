package com.ibm.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ibm.training.bean.Account;
import com.ibm.training.bean.Transaction;

@Repository
public class TransactionDatabase {
	DataSource dataSource;
	JdbcTemplate temp;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		temp = new JdbcTemplate(dataSource);
	}
	public void debitTransaction(Account a) {
		int m = (-1)*a.getBalance();
		temp.update("insert into transactions values(?,?,?)",new Object[] {a.getDate_created(),a.getId(),m});
	}
	public void creditTransaction(Account a) {
		int m = a.getBalance();
		temp.update("insert into transactions values(?,?,?)",new Object[] {a.getDate_created(),a.getId(),m});
		
	}
	public List<Transaction> viewAll(Account a) {
		List<Transaction> al =  temp.query("select * from transactions where id=?",new Object[] {a.getId()},new UserMapper());
		return al;
	}
	class UserMapper implements RowMapper<Transaction>{
		public Transaction mapRow(ResultSet rs,int rowNum)throws SQLException{
			Transaction user = new Transaction();
			user.setId(rs.getInt("id"));
			user.setDate_transaction(rs.getString("date_transaction"));
			user.setChanged(rs.getInt("changed"));
			return user;
		}
	}
}
