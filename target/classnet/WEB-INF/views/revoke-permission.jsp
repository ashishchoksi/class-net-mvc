<%@include file="./masters/header_links.jsp" %>

<body class="hold-transition sidebar-mini">
  <div class="wrapper">
   
   <%@include file="./masters/ec_index.jsp" %>
      
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
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
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-12">

              <div class="card">
                <div class="card-header">
                  <h3 class="card-title">All Students</h3>
                </div>
                <!-- /.card-header -->
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
                      <tr>
                        <td>201912001</td>
                        <td>ina</td>
                        <td>CR</td>
                        <td> <a href="#" class="text-danger">Revoke</a> </td>
                      </tr>
                      <tr>
                        <td>201912002</td>
                        <td>mina</td>
                        <td>Acad</td>
                        <td> <a href="#" class="text-danger">Revoke</a> </td>
                      </tr>
                      <tr>
                        <td>201912003</td>
                        <td>diga</td>
                        <td>SPC</td>
                        <td> <a href="#" class="text-danger">Revoke</a> </td>
                      </tr>

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