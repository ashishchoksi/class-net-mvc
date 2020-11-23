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
                            <h1 class="font-weight-bold">Create Poll</h1>
                        </div>
                        
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <section class="content">
                <div class="container-fluid">
                    
                    <div class="row">
                        <div class="col-12">
                            <!-- interactive chart -->
                            
                            <!-- <h5>Poll: 1</h5> -->
                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="col-5 card-title">
                                        <i class="fa fa-users"></i>
                                        Beach: Msc.IT
                                    </h3>

                                </div>
                                <div class="card-body">
                                    <div id="interactive" >
                                        <h4 class="font-weight-normal "> 
                                            <div class="form-group row">
                                                <!-- col-form-label -->
                                                <label for="inputEmail3" class="col-sm-auto col-form-label">Poll Title </label> 
                                                <div class="col-sm-8">
                                                  <!-- <input type="text" class="form-control" id="inputEmail3" placeholder="Enter Poll Title. Ex. Election Time"> -->
                                                  <input class="form-control form-control-lg" type="text" placeholder="Enter Poll Title. Ex. Election Time">
                                                </div>
                                              </div>
                                        </h4>

                                        <div class="alert alert-light" role="alert">

                                            <div class="col-lg-12">
                                                
                                                <label>Options
                                                    <button type="button" class="btn btn-warning btn-sm toastrDefaultInfo"><i class="fas fa-info"></i></button>
                                                </label>

                                                <div id="inputFormRow">
                                                    <div class="input-group mb-3">
                                                        <input type="text" name="title[]" class="form-control m-input" placeholder="Enter Option" autocomplete="off">
                                                        <div class="input-group-append">                
                                                            <button id="removeRow" type="button" class="btn btn-danger">Remove</button>
                                                        </div>
                                                    </div>
                                                </div>
                                    
                                                <div id="newRow"></div>
                                                <button id="addRow" type="button" class="btn btn-info">Add</button>
                                            </div>

                                        </div>
                                        <button type="button" class="btn bg-gradient-success">Submit</button>
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

        </div>
        <!-- /.content-wrapper -->
        
        
        <%@include file="./masters/footer_links.jsp" %>