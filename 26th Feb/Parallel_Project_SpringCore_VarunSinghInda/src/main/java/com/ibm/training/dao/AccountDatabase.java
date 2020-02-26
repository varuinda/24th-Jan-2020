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
public class AccountDatabase {
	
	DataSource dataSource;
	JdbcTemplate temp;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		temp = new JdbcTemplate(dataSource);
	}

	public boolean check(Account a) {
		int c = temp.queryForObject("select count(*) from wallet where id=?",new Object[] {a.getId()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public void addNewAccount(Account a) {
		// TODO Auto-generated method stub
		temp.update("insert into wallet values(?,?,?,?,?)",new Object[] {a.getId(),a.getName(),a.getBalance(),a.getPassword(),a.getDate_created()});
	}

	public boolean log(Account a) {
		int c = temp.queryForObject("select count(*) from wallet where id=? and password=?",new Object[] {a.getId(),a.getPassword()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public int balance(Account a) {
		return temp.queryForObject("select balance from wallet where id=?",new Object[] {a.getId()},Integer.class);
	}

	public void withdrawMoney(Account a) {
		int m = balance(a) - a.getBalance();
		temp.update("update wallet set balance=? where id=?",new Object[] {m,a.getId()});
	}

	public void addMoney(Account a) {
		int m = balance(a) + a.getBalance();
		temp.update("update wallet set balance=? where id=?",new Object[] {m,a.getId()});
	}

	public boolean checkid(Account a) {
		int c = temp.queryForObject("select count(*) from wallet where id=?",new Object[] {a.getId()},Integer.class);
		if(c==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public List<Account> viewAll() {
			List<Account> al =  temp.query("select * from wallet",new UserMapper());
			return al;
	}
	class UserMapper implements RowMapper<Account>{
		public Account mapRow(ResultSet rs,int rowNum)throws SQLException{
			Account user = new Account();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setDate_created(rs.getString("date_created"));
			user.setBalance(rs.getInt("balance"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}

}
