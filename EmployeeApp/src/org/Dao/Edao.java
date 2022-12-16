package org.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.beans.Emp;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class Edao {
private JdbcTemplate template;

public JdbcTemplate getTemplate() {
	return template;
}

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int addEmp(Emp e)
{
	return template.update("insert into emp values(?,?)", new PreparedStatementSetter(){

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
		}
	});
}
public int delEmp(int id)
{
	return template.update("delete from emp where id=?", new PreparedStatementSetter(){
		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(1, id);
		}
	});
}
public int updateEmp(Emp e)
{
	return template.update("update emp set name=? wherte id=?", new PreparedStatementSetter(){
		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(2, e.getId());
			ps.setString(1, e.getName());
		}
	});
}
public List<Emp> show()
{
	return template.query("select * from emp", new RowMapper<Emp>(){
		@Override
		public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
			Emp e=new Emp();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			return e;
		}
	});
}
public List<Emp> showAll()
{
	return template.query("select * from emp", new ResultSetExtractor<List<Emp>>(){

		@Override
		public List<Emp> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Emp> al=new ArrayList<Emp>();
			while(rs.next())
			{
				Emp e=new Emp();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				al.add(e);
			}
			return al;
		}
		
	});
}
}
