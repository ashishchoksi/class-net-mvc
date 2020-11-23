
<%@include file="./masters/header_links.jsp" %>

<body class="hold-transition sidebar-mini">
  <div class="wrapper">
      
    <!-- Main Sidebar Container -->
    <%@include file="./masters/ec_index.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
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
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <!-- SELECT2 EXAMPLE -->
          <div class="card card-default">
            <div class="card-header">
              <h3 class="card-title">Assign Permission</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse"><i
                    class="fas fa-minus"></i></button>
                <button type="button" class="btn btn-tool" data-card-widget="remove"><i
                    class="fas fa-times"></i></button>
              </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <div class="row">
                <div class="col-md-10 col-ld-10 col-sm-12">

                  <div class="form-group">
                    <label>Select Student ID</label>
                    <select class="form-control select2" style="width: 100%;">
                      <option selected="selected">201912001</option>
                      <option>201912001</option>
                      <option>201912002</option>
                      <option>201912003</option>
                      <option>201912004</option>
                      <option>201912005</option>
                      <option>201912006</option>
                    </select>
                  </div>


                  <!-- Student Role -->
                  <div class="form-group">
                    <label>Select Student Role</label>
                    <select class="form-control select2" style="width: 100%;">
                      <option selected="selected">CR</option>
                      <option>CR</option>
                      <option>Acad</option>
                      <option>SPC</option>
                    </select>
                  </div>

                  <!-- Student Role -->
                  <div class="form-group">
                    <button class="btn btn-primary">Assign</button>
                  </div>

                </div>

              </div>
              <!-- /.row -->


            </div>
            <!-- /.card-body -->

          </div>
          <!-- /.card -->

        </div><!-- /.container-fluid -->
      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <%@include file="./masters/footer_links.jsp" %>