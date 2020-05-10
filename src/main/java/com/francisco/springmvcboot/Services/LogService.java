package com.francisco.springmvcboot.Services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
public class LogService {

	@Autowired
	JdbcTemplate jt;

	public List<String[]> getLogs(Timestamp start, Timestamp end, String user, String operation, String entity,
			Integer limit) {
		System.out.println("getlogs = " + start + "," + end + "," + user + "," + operation + "," + entity + "," + limit);
		ArrayList<String[]> loglist = new ArrayList<>();
		String queryTxt = "SELECT * FROM logs WHERE datetime BETWEEN '" + start + "' AND '"
				+ end + "' ";
		if (!user.equals("all"))
			queryTxt += "AND user = '" + user + "'";
		if (!operation.equals("all"))
			queryTxt += "AND operation = '" + operation + "'";
		if (!entity.equals("all"))
			queryTxt += "AND entity = '" + entity + "'";
		queryTxt += " ORDER BY datetime DESC";
		if (limit!=0)
			queryTxt += " LIMIT " + limit;

		SqlRowSet query = jt.queryForRowSet(queryTxt);
		String id,date;
		System.out.println("query = " + queryTxt);
		while (query.next()) {
			id = String.valueOf(query.getInt(1));
			if (query.getString(2).equals("getAll")) {
				operation = "List";
			} else {
				operation = query.getString(2).toUpperCase().charAt(0) + query.getString(2).substring(1);
			}
			entity = query.getString(3);
			date = query.getTimestamp(4).toString();
			user = query.getString(5);
			loglist.add(new String[] { id, operation, entity, date, user });
		}
		return loglist;
	}


}
