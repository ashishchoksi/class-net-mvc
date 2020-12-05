
<%@page import="javafx.util.Pair"%>
<%@page import="com.classnet.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@include file="./masters/header_links.jsp" %>

<body class="hold-transition sidebar-mini">
  <div class="wrapper">
     
      <%@include file="./masters/sidebar.jsp" %>
      
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
              <h1>All Students Details</h1>
            </div>
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item active">Program Student details</li>
              </ol>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>
		<% ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students"); 
			ArrayList<Pair<String,Integer>> progYears = (ArrayList<Pair<String,Integer>>) request.getAttribute("progYears");
			//out.print(progYears);
			String name = "-"+(String)request.getAttribute("prog_name");
		%>
      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-12">
				
              <div class="card">
                <div class="card-header">
                  <div class="btn-group">
                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                       <%= name.substring(1)%>
                                    </button>
                                    <div class="dropdown-menu">
                                    	<% for(Pair<String,Integer> p : progYears) {%>
                                        <a class="dropdown-item" href="<%= request.getContextPath()%>/view-program?progID=<%=p.getKey()%><%=name%>&year=<%=p.getValue()%>"><%=p.getValue() %></a>
                                        <%}%>
                                    </div>
                   </div>
                </div>
                <!-- /.card-header -->
                
                
                <div class="card-body">
                 <h3> Total Students  = <%=students.size() %></h3>
                  <table id="example1" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>Student ID</th>
                        <th>Student Name</th>
                        <th>Student Current Role</th>
                      </tr>
                    </thead>
                    <tbody>
                      	<% for(Student s : students){%>
                      	
                      		<tr>
                      			<td> <%=s.getSsid() %></td>
                      			<td> <%=s.getStudent_name() %></td>
                      			<td> <%=s.getStu_type().getStudent_type_name() %></td>
                      		</tr>
						<%} %>
                    </tbody>
                    
                    <tfoot>
                      <tr>
                        <th>Student ID</th>
                        <th>Student Name</th>
                        <th>Student Current Role</th>
                      </tr>
                    </tfoot>
                  </table>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    
    
    <%@include file="./masters/footer_links.jsp" %>