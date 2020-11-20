<%-- 
    Document   : ConfirmShop
    Created on : Nov 20, 2020, 5:51:45 PM
    Author     : black
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Dvdcatalog"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="Dvd" class="Model.Dvdcatalog" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Enumeration<String> attributes = request.getSession().getAttributeNames();
        Vector<Dvdcatalog> proList = new Vector<Dvdcatalog>();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            if(!(attribute.equals("WELD_S_HASH") || attribute.equals("entitymanager")))
                proList.add((Dvdcatalog) request.getSession().getAttribute(attribute));
        }
        Iterator<Dvdcatalog> itr = proList.iterator();
    %>
    <body>
        <center>
            <form name="confirm" action="ConfirmShopController">
                <table padding: 10px;>
                    <tr>
                        <th>DVD ID</th>
                        <th>DVD NAME</th>
                        <th>RATE</th>
                        <th>YEAR</th>
                        <th>PRICE</th>
                        <th>QUANTITY</th>
                    </tr>
                    <%
                        while(itr.hasNext()) {
                            Dvd = itr.next();
                                              
                            out.println("<tr>");
                            out.println("<td> "+ Dvd.getId()+ "</td>");
                            out.println("<td> "+ Dvd.getDvdname()+ "</td>");
                            out.println("<td> "+ Dvd.getRate()+ "</td>");
                            out.println("<td> "+ Dvd.getYyear()+ "</td>");
                            out.println("<td> "+ Dvd.getPrice()+ "</td>");
                            out.println("<td> "+ Dvd.getQuantity()+ "</td>");
                            out.println("<tr>");
                        }
                    %>
                </table>
                <button class="btn btn-light" type="submit" name="cancel" value="Cancel">Cancel</button>
                <button class="btn btn-success" type="submit" name="confirm" value="Confirm">Confirm</button>
<!--                <input type="submit" value="Delete" name="delete" />
                <input type="submit" value="Cancel" name="cancel" />-->
            </form>
        </center>
    </body>
</html>
