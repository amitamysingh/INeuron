package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wish")
public class WishServlet extends HttpServlet{
    public static final long serialVersionUID=1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        LocalDateTime dTime=LocalDateTime.now();
        int hour=dTime.getHour();


        writer.println("<h1><center>Current Date time is:: " +dTime+ "</center></h1>");

        if(hour<12)
            writer.println("<h2><center>Good Morning</center></h2>");

        else if(hour<16)
            writer.println("<h2><center>Good AfterNoon</center></h2>");

        else if(hour<16)
            writer.println("<h2><center>Good Evening</center></h2>");

        else
            writer.println("<h2><center>Good Night</center></h2>");

        writer.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}