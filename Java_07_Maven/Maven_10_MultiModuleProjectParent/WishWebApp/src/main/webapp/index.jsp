<%@ page import="com.pwskills.service.WishMessageService"%>
<h1 style="color:red; text-align:center;">
    <%= new WishMessageService().wishMessage("Sachin")%>
</h1>
