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
                                            <p><%=entry.getKey()%></p>
                                        </div>
                                        <div class="icon">
                                            <i class="ion ion-person"></i>
                                        </div>
                                        <a href="/classnet/student-info" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
                                    </div>
                                </div>
                        <%   
                            }
                        %>
                    </div>
                    <div class="row" id="Btech-table">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">B.Tech Student</h3>

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
                                            <tr>
                                              <td>1.</td>
                                              <td>Name of student</td>
                                              <td>ID of student</td>
                                              <td><span class="badge bg-primary">CR</span></td>
                                            </tr>
                                            <tr>
                                                <td>2.</td>
                                                <td>Name of student</td>
                                                <td>ID of student</td>
                                                <td><span class="badge bg-success">SPC</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>              
                        </div>
                    </div>
                    <div class="row" id="Mtech-table">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">M.Tech Student</h3>
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
                                          <tr>
                                            <td>1.</td>
                                            <td>Name of student</td>
                                            <td>ID of student</td>
                                            <td><span class="badge bg-primary">CR</span></td>
                                          </tr>
                                          <tr>
                                            <td>2.</td>
                                            <td>Name of student</td>
                                            <td>ID of student</td>
                                            <td><span class="badge bg-success">SPC</span></td>
                                          </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" id="Mscit-table">
                        <div class="col">
              <div class="card">
                <div class="card-header">
                  <h3 class="card-title">MSc.IT Student</h3>

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
                <!-- /.card-header -->
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
                      <tr>
                        <td>1.</td>
                        <td>Name of student</td>
                        <td>ID of student</td>
                        <td><span class="badge bg-primary">CR</span></td>
                      </tr>
                      <tr>
                        <td>2.</td>
                        <td>Name of student</td>
                        <td>ID of student</td>
                        <td><span class="badge bg-success">SPC</span></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
          </div>

          <div class="row" id="Mdes-table">
            <div class="col">
              <div class="card">
                <div class="card-header">
                  <h3 class="card-title">M.Des Student</h3>

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
                <!-- /.card-header -->
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
                      <tr>
                        <td>1.</td>
                        <td>Name of student</td>
                        <td>ID of student</td>
                        <td><span class="badge bg-primary">CR</span></td>
                      </tr>
                      <tr>
                        <td>2.</td>
                        <td>Name of student</td>
                        <td>ID of student</td>
                        <td><span class="badge bg-success">SPC</span></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
          </div>


          <!-- /.content-wrapper -->

<%@include file="./masters/footer_links.jsp" %>