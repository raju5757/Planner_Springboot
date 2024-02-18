package com.planner.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.planner.dao.PlannerDao;
import com.planner.util.users;

@Repository
@CrossOrigin
public class PlannerDaoImpl implements PlannerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${database.name}")
	private String Schema;
	
	@Override
	public Object getUsers() {

		List<users> Result = new ArrayList<users>();
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema)

				.withProcedureName("getusers");

		Map<String, Object> inParamMap = new HashMap<String, Object>();

		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> resultData = simpleJdbcCall.execute(in);

		for (Entry<String, Object> e : resultData.entrySet()) {
			String key = e.getKey();
			if (e.getValue() instanceof List) {
				List obj = (List) e.getValue();
				for (int i = 0; i < obj.size(); i++) {
					users c = new users();
					Map map = (Map) obj.get(i);
					c.setId((Integer) map.get("Id"));
					c.setName((String) map.get("Name"));
				

					Result.add(c);
				
				}
			}

		}
		
		return Result;
	}
}
