<%@page import="java.util.HashMap"%>
<%@page import="com.classnet.model.Student"%>
<%@page import="java.util.*"%>

<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <%@include file="./masters/sidebar.jsp" %>
        <div class="content-wrapper">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Assign Permission</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">Assign Permission</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>
            <section class="content">
                <div class="container-fluid">
                    <div class="card card-default">
                        <div class="card-header">
                            <h3 class="card-title">Assign Permission</h3>
<!--                            <div class="card-tools">
                                <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
                                <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i></button>
                            </div>-->
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-10 col-ld-10 col-sm-12">
                                    <form action="assign-role" method="post">
                                        <div class="form-group">
                                            <label>Select Student ID</label>
                                                <select class="form-control select2" style="width: 100%;" id="student_id" name="student_id">
                                                    <% ArrayList<Student> studs = (ArrayList<Student>)request.getAttribute("students"); 
                                                        for(Student s : studs){
                                                    %>
                                                            <option value="<%=s.getSsid()%>"><%=s.getSsid()%> - <%=s.getStudent_name()%></option>
                                                    <%   
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Select Student Role</label>
                                                <select class="form-control select2" style="width: 100%;" id="role_id" name="role_id">
                                                    <option selected="selected" value="2">Class Representative</option>
                                                    <option value="3">Election Representative</option>
                                                    <option value="4">Student Placement Counsel</option>
                                                    <option value="5">Academic Committee</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <button class="btn btn-primary">Assign</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <%@include file="./masters/footer_links.jsp" %>