<%@ page import="javax.inject.Inject" %>
<%@ page import="essence.AbstractDB" %>
<%@ page import="essence.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="essence.Seller" %>
<%@ page import="essence.Sales" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сторінка адміністратора</title>
    <style type="text/css">
        table{
            margin: 20px 20px;
            padding: 10px 10px;
            border: 2px;
            text-align: center;
        }
    </style>
</head>
<body>
<div>

    <table border="2px">
        <h2>Продукти</h2>
        <tr>
            <td><b>Id</b></td>
            <td><b>Назва</b></td>
            <td><b>Ціна</b></td>
            <td></td>
        </tr>
        <%!
            @Inject
            AbstractDB dataBase;
        %>
        <%
            List<Product> products = dataBase.getProductList();
            for (int i = 0; i < products.size(); i++) {
        %>
        <tr>
            <td><%=products.get(i).getProductId()%></td>
            <td><%=products.get(i).getProductName()%></td>
            <td><%=products.get(i).getPrice()%></td>
            <td>
            <form action="/deleteProduct" method="get">
                <input type="hidden" name="productId" value="<%=products.get(i).getProductId()%>">
                <input class="butt" type="submit" value="Видалити">
            </form>
        </td>
        </tr>
        <%
            }
        %>
        <form action="/addProduct" method="get">
            <tr>
                <td></td>
                <td>
                    <input type="text" name="addProductName">
                </td>
                </td>
                <td>
                    <input type="text" name="addProductCost">
                </td>
                <td>
                    <input class="butt" type="submit" value="Додати">
                </td>
            </tr>
        </form>
    </table>

    <form method="get" action="/updateProduct">
        <select name="id">
            <%
                for (int i = 0; i < products.size(); i++) {
            %>
            <option><%=products.get(i).getProductId()%></option>
            <%
                }
            %>
        </select>
        <input type="text" name="name" placeholder="ПIБ">
        <input type="text" name="price" placeholder="Ціна">
        <input type="submit" value="Редагувати">
    </form>
</div>
<div>
    <h2>Продавець</h2>
    <table border="2px">
        <tr>
            <td><b>Id</b></td>
            <td><b>Ім'я</b></td>
            <td></td>
        </tr>
        <tr>
                <%
                List<Seller> sellers = dataBase.getSellerList();
                for (int i = 0; i < sellers.size(); i++) {
                    %>
        <tr>
            <td><%=sellers.get(i).getSellerId()%></td>
            <td><%=sellers.get(i).getSellerName()%></td>
            <td>
                <form action="/deleteSeller" method="get">
                    <input type="hidden" name="sellerId" value="<%=sellers.get(i).getSellerId()%>">
                    <input class="butt" type="submit" value="Видалити">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tr>
        <form action="/addSeller" method="get">
            <tr>
                <td></td>
                <td>
                    <input type="text" name="addSellerName">
                </td>
                <td>
                    <input class="butt" type="submit" value="Додати">
                </td>
            </tr>
        </form>
    </table>
    <form method="get" action="/updateSeller">
        <select name="id">
            <%
                for (int i = 0; i < sellers.size(); i++) {
            %>
            <option><%=sellers.get(i).getSellerId()%></option>
            <%
                }
            %>
        </select>
        <input type="text" name="sellerName" placeholder="ПІБ">
        <input type="submit"  value="Редагувати">
    </form>
</div>
<div>
    <h2>Продаж</h2>
    <table border="2px">
        <tr>
            <td><b>Id</b></td>
            <td><b>Id товару </b></td>
            <td><b>Id продавця </b></td>
            <td><b>Кількість товару в продаця</b></td>
            <td></td>
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

            <td>
                <form action="/deleteSales" method="get">
                    <input type="hidden" name="salesId" value="<%=salesList.get(i).getSalesId()%>">
                    <input class="butt" type="submit" value="Видалити">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tr>
        <form action="/addSales" method="get">
            <tr>
                <td></td>
                <td>
                    <input type="text" name="addProductId">
                </td>
                <td>
                    <input type="text" name="addSellerId">
                </td>
                <td>
                    <input type="text" name="addCountOfProducts">
                </td>
                <td>
                    <input class="butt" type="submit" value="Додати">
                </td>
            </tr>
        </form>
    </table>
    <form method="get" action="/updateSales">
        <select name="id">
            <%
                for (int i = 0; i < salesList.size(); i++) {
            %>
            <option><%=salesList.get(i).getSalesId()%></option>
            <%
                }
            %>
        </select>
        <input type="text" name="productId" placeholder="Id продукту">
        <input type="text" name="sellerId" placeholder="Id продавця">
        <input type="text" name="countOfProducts" placeholder="Кількість товару у продавця">
        <input type="submit"  value="Редагувати">
    </form>
</div>
</body>
</html>

