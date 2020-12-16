<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/4
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/empsave" method="post" onsubmit="window.confirm('确定添加吗?')">
        <p>
            姓名:<input type="text" name="ename" value="">
        </p>
        <p>
            入职日期:<input type="date" name="hiredate" value="">
        </p>
        <p>
            薪资:<input type="text" name="sal" value="">
        </p>

        <span>
            <input type="submit" value="添加">
            <input type="reset" value="重置">
        </span>

    </form>
</body>
</html>
