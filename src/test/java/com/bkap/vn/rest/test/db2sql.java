package com.bkap.vn.rest.test;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://msdn.microsoft.com/en-US/library/ms187510(SQL.120).aspx
 */
public class db2sql {

   /* RESTORE FILELISTONLY
    FROM DISK = 'D\:Test.bak'
    GO*/

    public static void main(String[] args){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=shop_online", "sa", "quanghoa1993");
            Statement stmt = conn.createStatement();
            String strSelect = "BACKUP DATABASE shop_online  \n" +
                    " TO DISK = 'D:\\shop_online.Bak'  \n" +
                    "   WITH FORMAT,  \n" +
                    "      MEDIANAME = 'Z_SQLServerBackups',  \n" +
                    "      NAME = 'Full Backup of shop_online';";
            stmt.execute(strSelect);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}