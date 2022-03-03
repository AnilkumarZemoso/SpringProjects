<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>

<link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Customer RelationShip Management- CRM</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button" value="Add Customer"
            onclick="window.location.href='showFormToAdd'; return false;"
            class="add-button" />

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="currentCustomer" items="${customerList}" >
                <c:url var="updateLink" value="/customer/showFormToUpdate" >
                    <c:param name="customerId" value="${currentCustomer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/deleteCustomer" >
                    <c:param name="customerId" value="${currentCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${currentCustomer.firstName}</td>
                    <td>${currentCustomer.lastName}</td>
                    <td>${currentCustomer.email}</td>
                    <td>
                    <a href="${updateLink}">Update</a>

                    <a href="${deleteLink}"
                        onclick="if(!(confirm('Are you sure to delete this Customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>