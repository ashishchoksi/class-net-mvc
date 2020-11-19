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
                        
                        <div class="col-sm-12">
                            <!-- <div class="card">
                                <div class="card-header">
                                    <h1 class="card-title text-bold ">Active Poll</h1>
                                </div>
                            </div> -->
                            <!-- /.card -->
                            <h1 class="font-weight-bold">Active Poll</h1>
                        </div>
                        
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <section class="content">
                <div class="container-fluid">
                    
                    <div class="row">
                        <div class="col-12">
                            <!-- interactive chart -->
                            
                            <h5>Poll: 1</h5>
                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="col-5 card-title">
                                        <i class="far fa-user"></i>
                                        Created by
                                    </h3>

                                    <span class="col-6">
                                        <i class="far fa-clock"></i>
                                        5 hour remaining
                                    </span>

                                    <div class="card-tools">
                                        Start/End
                                        <i class="far fa-calendar"></i>
                                        :
                                        10:15 /
                                        15:15

                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="interactive" >
                                        <h4 class="font-weight-normal "> <i class="far fa-chart-bar"></i> My Poll
                                            Question Title </h4>

                                        <div class="alert alert-light" role="alert">
                                            <div class="form-check">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" name="exampleRadios"
                                                                aria-label="Radio button for following text input">
                                                        </div>
                                                    </div>
                                                    <label class="form-control" value="hello">Option 1</label>
                                                </div>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" name="exampleRadios"
                                                                aria-label="Radio button for following text input">
                                                        </div>
                                                    </div>
                                                    <label class="form-control" value="hello">Option 2</label>
                                                </div>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" name="exampleRadios"
                                                                aria-label="Radio button for following text input">
                                                        </div>
                                                    </div>
                                                    <label class="form-control" value="hello">Option 3</label>
                                                </div>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" name="exampleRadios"
                                                                aria-label="Radio button for following text input">
                                                        </div>
                                                    </div>
                                                    <label class="form-control" value="hello">Option 4</label>
                                                </div>
                                            </div>
                                            
                                            <button type="button" class="ml-3 mt-3 btn btn-primary btn-sm">Submit</button>
                                            <br/>
                                            
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body-->
                            </div>
                            <!-- /.card -->

                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->


                </div><!-- /.container-fluid -->
            </section>

            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        
                        <div class="col-sm-12">
                            <!-- <div class="card">
                                <div class="card-header">
                                    <h1 class="card-title text-bold ">Active Poll</h1>
                                </div>
                            </div> -->
                            <!-- /.card -->
                            <h1 class="font-weight-bold">Result of Poll</h1>
                        </div>
                        
                    </div>
                </div><!-- /.container-fluid -->
            </section>
            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <h5>No: 1</h5>
                            <div class="card">
                                <div class="card-header">
                                    <!-- <h3 class="card-title">Fixed Header Table</h3> -->
                                    <h4 class="font-weight-normal "> <i class="far fa-chart-bar"></i> My Poll
                                        Question Title 
                                        &nbsp
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-sm">
                                            <i class="fas fa-info"></i>
                                          </button>
<!-- 
                                        <button type="submit" class="btn btn-primary"><i
                                            class="fas fa-info"></i></button>     -->
                                    </h4>
                                    <div class="modal fade" id="modal-sm">
                                        <div class="modal-dialog modal-sm">
                                          <div class="modal-content">
                                            <div class="modal-header">
                                              <h4 class="modal-title">Poll Information</h4>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                              <p><b>Created By:</b> lopamudra </p>
                                              <p><b>Start Date/Time:</b> 20/12/2020 - 10:20 </p>
                                              <p><b>End Date/Time:</b> 20/12/2020 - 15:20 </p>
                                              <p><b>No of poll count:</b> 150 </p>
                                              <p><b>Your vote:</b> bhindi 10Kg </p>
                                            </div>
                                            <div class="modal-footer justify-content-between">
                                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                              <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
                                            </div>
                                          </div>
                                          <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                      </div>
                                      <!-- /.modal -->
                                    
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body p-0">
                                    <table class="table table-sm">
                                      <thead>
                                        <tr>
                                          <th style="width: 10px">#</th>
                                          <th>Option</th>
                                          <th>Vote</th>
                                          <th style="width: 40px">%</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <tr>
                                          <td>1.</td>
                                          <td>Option 1</td>
                                          <td>
                                            <div class="progress progress-xs">
                                              <div class="progress-bar progress-bar-danger" style="width: 55%"></div>
                                            </div>
                                          </td>
                                          <td><span class="badge bg-danger">55%</span></td>
                                        </tr>
                                        <tr>
                                          <td>2.</td>
                                          <td>Option 1</td>
                                          <td>
                                            <div class="progress progress-xs">
                                              <div class="progress-bar bg-warning" style="width: 70%"></div>
                                            </div>
                                          </td>
                                          <td><span class="badge bg-warning">70%</span></td>
                                        </tr>
                                        <tr>
                                          <td>3.</td>
                                          <td>Option 1</td>
                                          <td>
                                            <div class="progress progress-xs progress-striped active">
                                              <div class="progress-bar bg-primary" style="width: 30%"></div>
                                            </div>
                                          </td>
                                          <td><span class="badge bg-primary">30%</span></td>
                                        </tr>
                                        <tr>
                                          <td>4.</td>
                                          <td>Option 1</td>
                                          <td>
                                            <div class="progress progress-xs progress-striped active">
                                              <div class="progress-bar bg-success" style="width: 90%"></div>
                                            </div>
                                          </td>
                                          <td><span class="badge bg-success">90%</span></td>
                                        </tr>
                                      </tbody>
                                    </table>
                                  </div>
                            </div>
                            <!-- /.card -->
                            
                        </div>
                    </div>
                    <!-- /.row -->
                </div><!-- /.container-fluid -->
            </section>
            <!-- /.content -->
        </div>
        
        
<%@include file="./masters/footer_links.jsp" %>