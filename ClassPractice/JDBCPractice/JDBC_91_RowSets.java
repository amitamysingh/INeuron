package ClassPractice.JDBCPractice;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBC_91_RowSets {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSetFactory=rowSetFactory.createJdbcRowSet();
		CachedRowSet cachedRowSetFactory=rowSetFactory.createCachedRowSet();
		WebRowSet webRowSetFactory=rowSetFactory.createWebRowSet();
		JoinRowSet joinRowSetFactory=rowSetFactory.createJoinRowSet();
		FilteredRowSet filteredRowSetFactory=rowSetFactory.createFilteredRowSet();
		
		System.out.println(jdbcRowSetFactory.getClass().getName());
		System.out.println(cachedRowSetFactory.getClass().getName());
		System.out.println(webRowSetFactory.getClass().getName());
		System.out.println(joinRowSetFactory.getClass().getName());
		System.out.println(filteredRowSetFactory.getClass().getName());
	}

}
