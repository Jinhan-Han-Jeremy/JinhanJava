/* JDBCapp2.java
 * Created on December 2, 2009, 1:27 PM
 * @author gscott */
import java.net.URL;
import java.sql.*;

class JDBCapp2  
{
  static Connection theConn;

  public static void main (String args[]) {
    try {
      // connection to an ACCESS MDB
      theConn = myConnection2.getConnection();
      ResultSet rs;
      Statement stmt;
      String sql;

      sql =  "select * from test where NumOfMajors>=2";
      stmt = theConn.createStatement();
      rs = stmt.executeQuery(sql);
//      System.out.println("Golfer               Sponsor             Majors");
            while (rs.next()) {
         System.out.println("field1= "+rs.getString(1)+
                                   "  field2="+rs.getString(2));
//         System.out.println(String.format("%-20s %-20s %2s ",rs.getString("Golfer"),
//                             rs.getString("Sponsor"),rs.getString("NumOfMajors")));
      }
      rs.close();
      stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    finally {
      try {
        if (theConn != null) theConn.close();
      }
      catch (Exception e) {
      }
    }

    }
  }

class myConnection2 {
  public static Connection getConnection() throws Exception {
    Driver d = (Driver)Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
    Connection c;
    String conString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=e:/cs3_java_net/jdbc_ms_access/blank.mdb";
    c = DriverManager.getConnection(conString, "Admin", "admin");
    return c;
   }
}
