package com.marsuaga.spring.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
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
	
	
	@Transactional
	public int[] create(List<Offer> offers){
		SqlParameterSource[] params=SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offer (id, name, text, email) values(:id,:name, :text, :email)", params);
		
	}
	
	public boolean update(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offer set name=:name, text=:text, email=:email where id=:id", params) == 1;

	}
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offer (name, text, email) values(:name, :text, :email)", params) == 1;
	}
	public boolean delete(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offer where id= :id", params) == 1;
	}
	public Offer getOffer(int id){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("select * from offer where id = :id", params,
				new RowMapper<Offer>(){

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
