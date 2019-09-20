<%@page isELIgnored="false" %>
<%@page import="java.util.*" %>
<%@page import="com.ssi.StudentModel" %>
<html>
<body>
<h3>Result-Page</h3>
<%-- 	<hr>
		<pre>
		Roll No  : ${info.id}
		Name     : ${info.name}
		Phn No 	 : ${info.phno}
		Marks	 : ${info.marks}
		</pre>
	<hr> --%>
	
	<pre>
	
		<%List<StudentModel> al = (List<StudentModel>)request.getAttribute("infoAll");
		
		
		for(StudentModel student:al)
		{
		
		%>
		<hr>
		<pre>
		Roll No  : <%=student.getId()%>
		Name     : <%=student.getName()%>
		Phn No 	 : <%=student.getPhno()%>
		Marks	 : <%=student.getMarks()%>
		</pre>
	<hr>
		 
		<%} %>
	
	</pre>
</body>
</html>