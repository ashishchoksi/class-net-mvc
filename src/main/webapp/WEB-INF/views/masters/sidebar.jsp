<%@page import="com.classnet.util.ViewManager" %>
<% 
            int id = ViewManager.getMyID(); 
            // id=1 - student
            // id=3 - ec_index
            // else - representative
        %>
        
        <%
            if(id == 1) {
            %>
                <%@include file="student_index.jsp" %>
            <%
            } else if(id == 3) {
            %>
                <%@include file="ec_index.jsp" %>
            <%
            } else {
            %>
                <%@include file="representative_index.jsp" %>
            <%
            }
        %>