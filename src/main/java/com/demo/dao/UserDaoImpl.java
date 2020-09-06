package com.demo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Login;
import com.demo.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;
@Autowired
public JdbcTemplate jdbcTemplate;

	public void register(User user) {
     String sql="insert into user1 values(?,?,?,?,?,?,?)";
     jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),
    		 user.getEmail(),user.getLoc(),user.getPhone()
     });

	}

	public User validateUser(Login login) {
		String sql="select * from user1 where username='" + login.getUsername() + "'and password='" + login.getPassword() +"'";
		List<User>user=jdbcTemplate.query(sql,new UserMapper());
		
		return user.size() >0 ? user.get(0) :null;
	}
	
	class UserMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs,int agr1)throws SQLException{
			User user=new User();
			
		   user.setUsername(rs.getString("username"));
		   user.setPassword(rs.getString("password"));
		   user.setFirstname(rs.getString("firstname"));
		   user.setLastname(rs.getString("lastname"));
		   user.setEmail(rs.getString("email"));
		   user.setLoc(rs.getString("loc"));
		   user.setPhone(rs.getInt("phone"));
			return user;
		}
	}

}

