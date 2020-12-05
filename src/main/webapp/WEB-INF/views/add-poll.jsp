<%@include file="./masters/header_links.jsp" %>
 
<body class="hold-transition sidebar-mini">
    <div class="wrapper">

        <%@include file="./masters/ec_index.jsp" %>
        <% 
	        String error = (String)request.getAttribute("notCompleteTransction");
	        String success = (String)request.getAttribute("completeTransction");
        %>
        
 		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
        
        <!--Error Modal -->
		<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Error</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <%= error %>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok...</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!--Success Modal -->
		<div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Success</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <%= success %>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok...</button>
		      </div>
		    </div>
		  </div>
		</div>
		        

        <!-- Content Wrapper. Contains page content -->
        
        <%
        	if(error != null){
        %>
        
        <script>
        	 $('#errorModal').modal('show');
       	</script>
        <%
        	}
        	if(success != null){
        %>
        	<script>
        	 	$('#successModal').modal('show');
       		</script>
        <%		
        	}
        %>
        
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
                    <form action="add-poll" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-12">
                            <!-- interactive chart -->

                            <!-- <h5>Poll: 1</h5> -->
                            <div class="card card-primary card-outline">
                              <!--   <div class="card-header">
                                    <h3 class="col-5 card-title">
                                        <i class="fa fa-users"></i>
                                        Beach: Msc.IT
                                    </h3>

                                </div>  -->
                                <div class="card-body">
                                    <div id="interactive" >
                           
                                        <h4 class="font-weight-normal "> 
                                            <div class="form-group row">
                                                <!-- col-form-label -->
                                                <label for="inputEmail3" class="col-sm-auto col-form-label">Poll Title </label> 
                                                <div class="col-sm-8">
                                                    <!-- <input type="text" class="form-control" id="inputEmail3" placeholder="Enter Poll Title. Ex. Election Time"> -->
                                                    <input class="form-control form-control-lg" type="text" name="poll_title" id="inputEmail3" placeholder="Enter Poll Title. Ex. Election Time">
                                                    
                                                </div>
                                            </div>
                                        </h4>

                                        <div class="alert alert-light" role="alert">

                                            <div class="col-lg-12">

                                                <label>Options
                                                   <!--  <button type="button" class="btn btn-info btn-sm" id="toastsDefaultInfoPoll">
                                                        <i class="fas fa-info"></i>
                                                    </button>  -->
                                                    <!--<button type="button" class="btn btn-warning btn-sm toastrDefaultInfo"><i class="fas fa-info"></i></button>-->
                                                </label>

                                                <div id="inputFormRowPoll">
                                                    <div class="input-group mb-3">
                                                        <input type="text" name="title[]" class="form-control m-input" placeholder="Enter Option" autocomplete="off">
                                                        <div class="input-group-append">                
                                                            <button id="removeRow" type="button" class="btn btn-danger">Remove</button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div id="newRowpoll"></div>
                                                <button id="addRowpoll" type="button" class="btn btn-info">Add</button>
                                            </div>

                                            <div class="form-group col-lg-6">
                                                <label for="startDate">Start Date/Time</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="far fa-clock"></i></span>
                                                    </div>
                                                    <input class="form-control" type="datetime-local"  id="startDate" name="start_date">
                                                </div>
                                                <!-- /.input group -->
                                            </div>
                                            <div class="form-group col-lg-6">
                                                <label for="endDate">End Date/Time</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="far fa-clock"></i></span>
                                                    </div>
                                                    <input class="form-control" type="datetime-local"  id="endDate" name="end_date">
                                                </div>
                                                <!-- /.input group -->
                                            </div>
                                            
                                            <!-- /.form group -->


                                        </div>
                                        <button type="submit" class="btn bg-gradient-success">Submit</button>
                     
                                    </div>

                                </div>
                                <!-- /.card-body-->
                            </div>
                            <!-- /.card -->
	                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </form>
                

                </div><!-- /.container-fluid -->
            </section>

        </div>
        <!-- /.content-wrapper -->
        
        


        <%@include file="./masters/footer_links.jsp" %>