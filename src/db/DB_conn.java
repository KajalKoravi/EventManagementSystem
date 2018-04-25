
package db;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_conn {
    private Connection con;
    
    public DB_conn(){
    }
    public Connection connect(){
        if(con == null){
            MysqlDataSource  mdb = new MysqlDataSource();
            mdb.setDatabaseName(db_config.db);
            mdb.setUser(db_config.username);
            mdb.setPassword(db_config.password);
            try {
                con = mdb.getConnection();
            } catch (SQLException e) {
            }
        }
        return con;
    }
    
}