package com.xwrokz.servlet;


import com.xwrokz.dto.UserDTO;
import com.xwrokz.service.UserService;
import com.xwrokz.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user", loadOnStartup = +1)
// if you want to create object before make request from client or while server starting , by using loadOnstartup = +1  atttribte
public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    public UserServlet(){

        System.out.println("object created ");
    }

//    String
//Servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("service method is invoked and it internally call respective doXXX methods ");
        // Retrieve form data
        String firstName = request.getParameter("firstName");

           // process
        String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        String houseNumber = request.getParameter("houseNumber");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String gender = request.getParameter("gender");




        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setHouseNumber(houseNumber);
        user.setStreet(street);
        user.setCity(city);
        user.setDistrict(district);
        user.setState(state);
        user.setPincode(pincode);
        user.setGender(gender);

        System.out.println(user.toString());

        userService.validateAndAddInfo(user);

        // it will provide response
//        PrintWriter printWriter=response.getWriter();
//        printWriter.print("");

        // forwarding one servlet to the another resources(servlet, html file, jsp file) is called servlet chaining.
        // RequestDispatcher interface help us to achieve Servlet chianing
//        request.setAttribute("fName", firstName);   // setAttribute help us add data into the scope which available to files in project
//        RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
//        dispatcher.forward(request, response);


        request.setAttribute("register", " User registration successfull");   // setAttribute help us add data into the scope which available to files in project
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

//    @Override
//    public void destroy() {
//        super.destroy();
//        System.out.println("object is destroyed");
//    }




}

