
<%@ page import="javax.inject.Inject" %>
<%@ page import="java.util.List" %>
<%@ page import="essence.AbstractDB" %>
<%@ page import="essence.Sales" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Користувацька сторінка</title>
</head>
<body>
<%!
    @Inject
    AbstractDB dataBase;
%>
<h2>Продаж</h2>
<table border="2px">
    <tr>
        <td><b>Id</b></td>
        <td><b>Id товару </b></td>
        <td><b>Id продавця </b></td>
        <td><b>Кількість товару в продаця</b></td>
    </tr>
    <tr>
            <%
                List<Sales> salesList = dataBase.getSalesList();
                for (int i = 0; i < salesList.size(); i++) {
                    %>
    <tr>
        <td><%=salesList.get(i).getSalesId()%></td>
        <td><%=salesList.get(i).getProductId()%></td>
        <td><%=salesList.get(i).getSellerId()%></td>
        <td><%=salesList.get(i).getCountOfProducts()%></td>
    </tr>
    <%
        }
    %>
    </tr>
</table>
</body>
</html>
