<%-- 
    Document   : test
    Created on : 2016/8/19, 下午 08:43:15
    Author     : mac
--%>

<%@page import="javax.naming.*"%>
<%@page import="au.com.wat2eat.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            try {
            AccountDAO dao = new AccountDAO_JavaDB_Impl();
            AccountDTO account = new AccountDTO();
            account.setId("kuramu1108");
            account.setPassword("123456");
            account.setGender("M");
            account.setAge(22);
            account.setNationality("Taiwanese");
            dao.create(account);
            AccountDTO r = dao.retreive("kuramu1108");
            out.println(r.getId());
            account.setAge(33);
            dao.update(account);
            r = dao.retreive("kuramu1108");
            out.println(r.getAge());
            dao.delete("kuramu1108");
            r = dao.retreive("kuramu1108");
            out.println(r.getAge());
        } catch (NamingException ex) {
            out.print(ex);
        }

        %>
        <h1>Hello World!</h1>
    </body>
</html>
