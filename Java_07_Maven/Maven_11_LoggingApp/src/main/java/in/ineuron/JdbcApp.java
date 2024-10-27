package in.ineuron;

import java.sql.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class JdbcApp {

    private static Logger logger= Logger.getLogger(JdbcApp.class);

    static{
        SimpleLayout layout = new SimpleLayout();
        ConsoleAppender appender = new ConsoleAppender(layout);
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
    }

    public static void main(String[] args) {

        logger.debug("Control entering main");

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            logger.debug("Driver loaded successfully");

            String url="jdbc:mysql://localhost:3306/mydb";
            String username="root";
            String password = "root@123";

            connection = DriverManager.getConnection(url,username,password);
            logger.info("Connection established successfully");

            statement = connection.createStatement();
            logger.debug("Statement object created");

            String selectQuery = "select stdid,sname,age,saddress from student";
            resultSet=statement.executeQuery(selectQuery);
            logger.info("ResultSetObject is created by executing query");

            while(resultSet.next()){
                System.out.println(resultSet.getInt("stdid")+"\t"+resultSet.getString("sname")+"\t" +
                        resultSet.getInt("age")+"\t"+resultSet.getString("saddress"));
            }

        }catch(SQLException se){
            se.printStackTrace();
            logger.error("SQL Exception occured -> "+se.getMessage()+" ==> "+ se.getErrorCode());

        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            logger.error("ClassNotFoundException occured");

        }catch(Exception e){
            e.printStackTrace();
            logger.fatal("Unknown Exception occured");

        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }

            }catch(SQLException se){
                se.printStackTrace();
                logger.error("SQL Exception occured -> "+se.getMessage()+" ==> "+ se.getErrorCode());


            }catch(Exception e){
                e.printStackTrace();
                logger.fatal("Unknown Exception occured");


            }
            try{
                if(statement != null){
                    statement.close();
                }

            }catch(SQLException se){
                se.printStackTrace();
                logger.error("SQL Exception occured -> "+se.getMessage()+" ==> "+ se.getErrorCode());


            }catch(Exception e){
                e.printStackTrace();
                logger.fatal("Unknown Exception occured");


            }
            try{

                if(connection != null){
                    connection.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
                logger.error("SQL Exception occured -> "+se.getMessage()+" ==> "+ se.getErrorCode());

            }catch(Exception e){
                e.printStackTrace();
                logger.fatal("Unknown Exception occured");


            }

        }
        logger.debug("Control exiting main");

    }
}
