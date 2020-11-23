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
                            <h1 class="font-weight-bold">Post Message</h1>
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
                                        Batch: Msc.IT
                                    </h3>

                                </div>
                                <div class="card-body">
                                    <div id="interactive">
                                    <form action="post-message" method="post">
                                        <h4 class="font-weight-normal ">
                                            <div class="form-group row">
                                                <!-- col-form-label -->
                                                <label for="inputEmail3" class="col-sm-auto col-form-label">Message
                                                    Title </label>  
                                                <div class="col-sm-8">
                                                    <!-- <input type="text" class="form-control" id="inputEmail3" placeholder="Enter Poll Title. Ex. Election Time"> -->
                                                    <input class="form-control form-control-lg" type="text"
                                                        placeholder="Enter Message Title" name="title">
                                                </div>
                                            </div>
                                        </h4>

                                        <div class="alert alert-light" role="alert">
											${error}
                                            <div class="col-lg-12">

                                                <label>Message Detail
                                                    <button type="button" class="btn btn-info btn-sm toastsDefaultInfo">
                                                        <i class="fas fa-info"></i>
                                                      </button>
                                                    
                                                </label>

                                                <div class="form-group">
                                                    <label>Message Content</label>
                                                    <textarea class="form-control" rows="3"
                                                        placeholder="Enter Message detail" name="msgContent"></textarea>
                                                </div>

                                                <div class="form-group">
                                                    <div class="custom-control custom-switch custom-switch-on-success">
                                                        <input type="checkbox" class="custom-control-input"
                                                            id="customSwitch1" onclick="checkFunction()">

                                                        <label class="custom-control-label" for="customSwitch1">Want to
                                                            add documents ?</label>
                                                    </div>
                                                </div>

                                                <div id="inputFormRow">
                                                    <div class="input-group mb-3">

                                                        <div class="custom-file">
                                                            <input type="file" name="title[]" class="form-control">
                                                            <!-- <label class="custom-file-label" for="customFile">Choose -->
                                                            <!-- file</label> -->
                                                        </div>
                                                        <div class="input-group-append">
                                                            <button id="removeRowMsg" type="button"
                                                                class="btn btn-danger">Remove</button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div id="newRow"></div>
                                                <button id="addRowMsg" type="button" class="btn btn-info">Add</button>
                                            </div>

                                        </div>
                                        <button type="submit" class="btn bg-gradient-success">Submit</button>
                                        </form>
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
   