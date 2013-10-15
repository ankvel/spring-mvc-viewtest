package com.akestrel.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.akestrel.edu.model.AksMessage;

public class AksMessageDaoJdbc implements AksMessageDao {

	private JdbcTemplate jdbcTemplate;
	
	private final static String GET_ALL_SQL = 
			"select id, author, content, some_date, created_date from aks_message";
	
	
	public AksMessageDaoJdbc(DataSource dataSource) {		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public AksMessage getMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMessage(AksMessage message) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AksMessage> getAllMessages() {
		return jdbcTemplate.query(GET_ALL_SQL, new AksMessageMapper());
	}
	
	private static final class AksMessageMapper implements RowMapper<AksMessage> {
		public AksMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
			AksMessage aksMessage = new AksMessage();
			aksMessage.setId(rs.getLong("id"));
			aksMessage.setAuthor(rs.getString("id"));
			
			aksMessage.setId(rs.getLong("id"));
			aksMessage.setAuthor(rs.getString("author"));
			aksMessage.setContent(rs.getString("content"));
			aksMessage.setSomeDate(new LocalDate(rs.getDate("some_date")));
			aksMessage.setCreatedDate(new DateTime(rs.getDate("created_date")));
			return aksMessage;
		}
	}	

}
