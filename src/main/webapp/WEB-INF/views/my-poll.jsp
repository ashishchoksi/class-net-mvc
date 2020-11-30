<!-- <%@page import="com.classnet.model.Student"%> -->
<%@page import="java.util.HashMap"%>
<%@page import="com.classnet.model.Poll"%>
<%@page import="java.util.*"%>

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
                            
                            <div class="card-body table-responsive p-0">
                              <table class="table table-hover text-nowrap">
                                <thead>
                                  <tr>
                                    <th>#</th>
                                    <th>Created Date</th>
                                    <th>Poll Question</th>
                                    <th>Action</th>
                                    <th>Status</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <% ArrayList<Poll> poll = (ArrayList<Poll>)request.getAttribute("myPoll"); 
                                       
                                      
                                           			//out.println(msgs.get(0));
                                                  	
                                                 //out.print(msgs.size());
                                                 int i=1;
                                                if(poll != null) 
                                           			for(Poll p : poll){
                                           				//out.println(m.getDocuments().size());
                                                  %>
                                  <tr>
                                    <td><%= i %> </td>
                                    <td><%= p.getPollDate() %></td>
                                    <td><%= p.getPollTitle() %></td>
                                      <td>
                                    <form action="my-poll" method="post">
                                    <input type="hidden" name="poll_id" value="<%= p.getPollid() %>">
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-sm" >Delete</span></td> 
									</form>
									<!--<td><button type="submit" class="btn btn-danger" formaction="my-poll?poll_id=">Delete</span></td>-->
									
                                    <%  if(p.getStatus()==0){ %>
                                      <td><span class="tag tag-success">Finished</span></td>
                                    <%  } else { %>
                                      <td><span class="tag tag-success">Active</span></td>
                                    <% } %>
                                  </tr>
                                  <% i+=1; } %>
                                  
                                  <div class="modal fade" id="modal-sm">
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
                                </tbody>
                              </table>
                            </div>
                            <!-- /.card-body -->
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
    