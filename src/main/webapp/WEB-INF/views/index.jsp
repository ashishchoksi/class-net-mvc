<%@page import="com.classnet.model.Student"%>
<%@page import="java.util.*"%>

<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
        <%@include file="./masters/ec_index.jsp" %>
        <div class="content-wrapper">
            <div class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <ol class="breadcrumb ">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">More</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <% String color[]=new String[]{"bg-info","bg-success","bg-warning","bg-danger"};
                            int i=0;
                            HashMap<String,Integer> map = (HashMap<String,Integer>)request.getAttribute("progCount");
                            for(Map.Entry<String,Integer> entry : map.entrySet()) {
//                            for(Student s : studs){
                        %>

                        <div class="col-lg-3 col-6">
                            <div class="small-box <%=color[i++%4]%>">
                                <div class="inner">
                                    <h3><%=entry.getValue()%></h3>
                                    <p><%=entry.getKey().substring(3)%></p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-person"></i>
                                </div>
                                <a href="<%= request.getContextPath()%>/view-program?progID=<%=entry.getKey()%>&year=0" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                        <%   
                            }
                        %>
                    </div>

                    <% 
                        HashMap<String,ArrayList<String>> ECList = (HashMap<String,ArrayList<String>>)request.getAttribute("ECList");
                        for(Map.Entry<String,ArrayList<String>> entry : ECList.entrySet()) {

                    %>
                    <div class="row" id="Btech-table">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title"><%= entry.getKey() %></h3>

                                    <!-- <div class="card-tools">
                                    <ul class="pagination pagination-sm float-right">
                                      <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                                      <li class="page-item"><a class="page-link" href="#">2</a></li>
                                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                                      <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                                    </ul>
                                    </div> -->
                                </div>
                                <div class="card-body p-0">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th style="width: 10px">#</th>
                                                <th>Name</th>
                                                <th>ID</th>
                                                <th style="width: 60px">Responsibility</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% int tab_index=1;
                                            for(String arrlist : entry.getValue() ) {
                                                String[] arr = arrlist.split(":");
                                            %>
                                            <tr>
                                                <td><%= tab_index++ %></td>
                                                <td><%= arr[0] %></td>
                                                <td><%= arr[1] %></td>
                                                <td><span class="badge bg-primary">EC</span></td>
                                            </tr>

                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>              
                        </div>
                    </div>
                    <% } %>

                    <!-- /.content-wrapper -->

                    <%@include file="./masters/footer_links.jsp" %>