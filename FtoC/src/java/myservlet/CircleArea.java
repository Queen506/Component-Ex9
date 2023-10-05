/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarun
 */
public class CircleArea extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void init()
            throws ServletException {
        System.out.println("Init"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("Destroy"); //To change body of generated methods, choose Tools | Templates.
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        String radiusStr = request.getParameter("radius");
        double radius = Double.parseDouble(radiusStr);
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        double circleArea = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        String circumferenceStr = twoDigits.format(circumference);
        String circleStr = twoDigits.format(circleArea);
        radiusStr = twoDigits.format(radius);
       
try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CircleArea</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> "+ " For the circle with radius = " + radiusStr +"</h1>");
            if ("Calculate Area".equals(action)) {
            out.println("<h1>Area is " + circleStr + "</h1>");
        } else if ("Calculate Circumference".equals(action)) {
            out.println("<h1>Circumference is " + circumferenceStr + "</h1>");
        } else {
            out.println("<h1>No calculation selected</h1>");
        }
            out.println("</body>");
            out.println("</html>");
            
        }finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
