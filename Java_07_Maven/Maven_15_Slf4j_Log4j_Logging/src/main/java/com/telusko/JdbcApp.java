package com.telusko;



import java.sql.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcApp {

    private static Logger logger = LoggerFactory.getLogger(JdbcApp.class);

//    static {
//        PropertyConfigurator.configure("/Users/amitkumarsingh/Documents/JavaPgm/Maven_15_Slf4j_Log4j_Logging/src/main/java/com/telusko/cfgs/log4j.properties");
//    }

    public static void main(String[] args) {

        logger.debug("Control entering main");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            logger.debug("Driver loaded successfully");

            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "root@123";

            connection = DriverManager.getConnection(url, username, password);
            logger.info("Connection established successfully");

            statement = connection.createStatement();
            logger.debug("Statement object created");

            String selectQuery = "select stdid,sname,age,saddress from student";
            resultSet = statement.executeQuery(selectQuery);
            logger.trace("ResultSetObject is created by executing query");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("stdid") + "\t" + resultSet.getString("sname") + "\t" +
                        resultSet.getInt("age") + "\t" + resultSet.getString("saddress"));
            }

        } catch (SQLException se) {
            se.printStackTrace();
            logger.error("SQL Exception occured -> " + se.getMessage() + " ==> " + se.getErrorCode());

        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            logger.error("ClassNotFoundException occured");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unknown Exception occured");

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (SQLException se) {
                se.printStackTrace();
                logger.error("SQL Exception occured -> " + se.getMessage() + " ==> " + se.getErrorCode());


            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Unknown Exception occured");


            }
            try {
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException se) {
                se.printStackTrace();
                logger.error("SQL Exception occured -> " + se.getMessage() + " ==> " + se.getErrorCode());


            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Unknown Exception occured");


            }
            try {

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                logger.error("SQL Exception occured -> " + se.getMessage() + " ==> " + se.getErrorCode());

            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Unknown Exception occured");


            }

        }
        logger.debug("Control exiting main");

    }
}
