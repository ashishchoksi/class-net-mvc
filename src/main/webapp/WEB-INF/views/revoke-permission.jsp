<%@page import="java.util.HashMap"%>
<%@page import="com.classnet.model.Student"%>
<%@page import="java.util.*"%>

<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
    <%@include file="./masters/ec_index.jsp" %>
        <div class="content-wrapper">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Revoke Permission</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">Revoke Permission</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">All Students</h3>
                                </div>
                                <div class="card-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Student ID</th>
                                                <th>Student Name</th>
                                                <th>Student Current Role</th>
                                                <th>Edit Role</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% ArrayList<Student> studs = (ArrayList<Student>)request.getAttribute("students"); 
                                                for(Student s : studs){
                                            %>
                                                    <tr>
                                                        <td><%=s.getSsid()%></td>
                                                        <td><%=s.getStudent_name()%></td>
                                                        
                                                        <td><%=s.getStu_type().getStudent_type_name() %></td>
                                                        
                                                        <td> <a href="revoke-permission?id=<%=s.getSsid()%>" class="text-danger">Revoke</a> </td>
                                                    </tr>
                                            <%   
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Student ID</th>
                                                <th>Student Name</th>
                                                <th>Student Current Role</th>
                                                <th>Edit Role</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>    
        <%@include file="./masters/footer_links.jsp" %>
        
        
        
        
         <!--  s.getType_id()==2?"Class Representative":(s.getType_id()==3?"Election Representative":(s.getType_id()==4?"SPC member":"Academic Committee")) %>
        -->
                                                        