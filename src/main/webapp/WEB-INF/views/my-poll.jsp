<!-- <%@page import="com.classnet.model.Student"%> -->
<%@page import="java.util.HashMap"%>
<%@page import="com.classnet.model.Poll"%>
<%@page import="java.util.*"%>

<%@include file="./masters/header_links.jsp" %>
 
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        
        <%@include file="./masters/ec_index.jsp" %>
        
        <% 
	        String error = (String)request.getAttribute("notCompleteTransction");
	        String success = (String)request.getAttribute("completeTransction");
        %>
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
        
                

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        
                        <div class="col-sm-12">
                            <h1  class="font-weight-bold">My Poll</h1>
                        </div>
                        
                    </div>
                </div>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                          <div class="card">
                          <%
                          	ArrayList<Poll> poll = (ArrayList<Poll>)request.getAttribute("myPoll");
                          	if(poll.size() == 0){
                          %>
                          	<div class="card-body table-responsive p-0">
                          		<h3> Oops...! Not Found Any Recored...  </h3>
                          	</div>
                          <%
                          	}
                          	else{
                          %>
                            
                            <div class="card-body table-responsive p-0">
                              <table class="table table-hover text-nowrap">
                                <thead>
                                  <tr>
                                    <th>#</th>
                                    <th>Created Date</th>
                                    <th>Poll Question</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <%  
                                       
                                      
                                           			//out.println(msgs.get(0));
                                                  	
                                                 //out.print(msgs.size());
                                                 int i=1;
                                                 
                                           			for(Poll p : poll){
                                           				//out.println(m.getDocuments().size());
                                                  %>
                                  <tr>
                                    <td><%= i %> </td>
                                    <td><%= p.getPollDate().getDay()%>/<%= p.getPollDate().getMonth() +1 %>/<%= p.getPollDate().getYear()-100 %> </td>
                                    <td><%= p.getPollTitle() %></td>
                                
                                     
									
									<!--<td><button type="submit" class="btn btn-danger" formaction="my-poll?poll_id=">Delete</span></td>-->
									
                                    <%  if(p.getStatus()==0){ %>
                                      <td><span class="tag tag-success">Finished</span></td>
                                    <%  } else { %>
                                      <td><span class="tag tag-success">Active</span></td>
                                    <% } %>
                                    <td>
                                    <form action="my-poll" method="post">
                                    <input type="hidden" name="poll_id" value="<%= p.getPollid() %>">
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#p<%= p.getPollid() %>" >Delete</span>
                                    </td>
                                  </tr>
                                  <% i+=1; %>
                                  
                                  <div class="modal fade" id="p<%= p.getPollid() %>">
                                    <div class="modal-dialog modal-sm">
                                      <div class="modal-content">
                                        <div class="modal-header">
                                          <h4 class="modal-title">Delete Poll</h4>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                          <p>Are you sure you want to delete this poll?</p>
                                          
                                        </div>
                                        <div class="modal-footer justify-content-between">
                                          <button type="button" class="btn btn-success" data-dismiss="modal">No</button>
                                          <button type="submit" class="btn btn-danger" >Yes</button>
                                        </div>
                                      </div>
                                      <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                  </div>
                                  <!-- /.modal -->
                                  </form>
                                  <% } %>
                                </tbody>
                              </table>
                            </div>
                            <!-- /.card-body -->
                            <%
                            	} 
                            %>
                          </div>
                          <!-- /.card -->
                        </div>
                      </div>
                      <!-- /.row -->
                </div><!-- /.container-fluid -->
            </section>
            <!-- /.content -->
        </div>
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
        
        

        
<%@include file="./masters/footer_links.jsp" %>
    