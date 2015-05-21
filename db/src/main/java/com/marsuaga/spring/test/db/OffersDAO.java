package com.marsuaga.spring.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}


	public List<Offer> getOffers(){
	
		return jdbc.query("select * from offer", new RowMapper<Offer>(){

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Offer offer = new Offer();
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setEmail(arg0.getString("email"));
				offer.setText(arg0.getString("text"));
				return offer;
			}
			
		});
		
					
	}

}
