<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry" %>
<%@page import="com.classnet.model.Poll"%>
<%@page import="java.util.*"%>

<%@include file="./masters/header_links.jsp" %>

<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        
       <%@include file="./masters/sidebar.jsp" %>
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
					<% ArrayList<Poll> pRemaining = (ArrayList<Poll>)request.getAttribute("pRemaining"); 
                        			Map<Integer,String> optionData = new HashMap<>();
                        			if(pRemaining.size() == 0){
                        	%>
                        	<div class="row">
                        		<div class="col-12">
                    
	                        	<div class="card">
		                        	<div class="card-body table-responsive p-0">
		                          		<h3> Oops...! Not Found Any Recored...  </h3>
		                          	</div>
	                          	</div>
	                          	
	                          	</div>
							</div>
                        	<%			
                        			}
                        			else{
                        					for(Poll p : pRemaining){
                            //out.println(m.getDocuments().size());
                        %>
                    
                    <div class="row">
                        <div class="col-12">
                            <!-- interactive chart -->
                            <!-- <h5>Poll: 1</h5> -->
                            <div class="card card-primary card-outline">
                                <div class="card-header">
                                    <h3 class="col-5 card-title">
                                        <i class="far fa-user"></i>
                                        Created by :  
                                        <%= p.getPollStuName() %>
                                    </h3>

                                    <span class="col-6">
                                        <i class="far fa-clock"></i>
                                        End Time :
                                        <%= p.getEndDate().getHours()%>:<%= p.getEndDate().getMinutes() %>
                                    </span>

                                    <div class="card-tools">
										<i class="far fa-calendar"></i>
										End Date :
										<%= p.getEndDate().getDay()%>/<%= p.getEndDate().getMonth() +1 %>/<%= p.getEndDate().getYear()-100 %> 
									</div>

                                </div>
                                <div class="card-body">
                                    <div id="interactive" >
                                        <h4 class="font-weight-normal "> <i class="far fa-chart-bar"></i> 
                                            <%= p.getPollTitle() %>
                                        </h4>
                                        <form action="view-poll" method="post">
                                        <div class="alert alert-light" role="alert">
                                            <div class="form-check">
                                                <input type="hidden" name="poll_id" value="<%= p.getPollid() %>">
                                                <%
                                                    optionData = p.getPollOptionData();
                                                if(optionData != null)
                                                for (Map.Entry e : optionData.entrySet()){
                                            
                                                %>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" name="poll_option_id" value="<%= e.getKey() %>"
                                                                aria-label="Radio button for following text input" required>
                                                        </div>
                                                    </div>
                                                    <label class="form-control" ><%= e.getValue() %></label>
                                                </div>
                                                <% } %>
                                                
                                            </div>
                                            
                                            <button type="submit" class="ml-3 mt-3 btn btn-primary btn-sm" style="">Submit</button>
                                            <br/>
                                            
                                        </div>
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
                    <% } %>
				<% } %>

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
                	<%
                            	ArrayList<Poll> pFineshed = (ArrayList<Poll>)request.getAttribute("pFineshed"); 
                            	
                                if(pFineshed.size() == 0) {
                     %>
                     		<div class="row">
                        		<div class="col-12">
                    
	                        	<div class="card">
		                        	<div class="card-body table-responsive p-0">
		                          		<h3> Oops...! Not Found Any Recored...  </h3>
		                          	</div>
	                          	</div>
	                          	
	                          	</div>
							</div>
                        	<%			
                        			}
                        			else{
                            		for(Poll p : pFineshed){
                            			int tAns=0;
                            			Map<Integer,Integer> totalAns = new HashMap<>();
                                    	Map<Integer,String> data = new HashMap<>();
                            			data = p.getPollOptionData();
                            			totalAns = p.getPollAnsCount();
                            			if(totalAns != null){
                            				for(Map.Entry e : totalAns.entrySet()){
                            					tAns += (int)e.getValue();
                            				}
                            			}
                            %>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <!-- <h3 class="card-title">Fixed Header Table</h3> -->
                                    <h4 class="font-weight-normal "> <i class="far fa-chart-bar"></i>
                                    	<%= p.getPollTitle() %> 
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#p<%= p.getPollid()%>">
                                            <i class="fas fa-info"></i>
                                          </button>
<!-- 
                                        <button type="submit" class="btn btn-primary"><i
                                            class="fas fa-info"></i></button>     -->
                                    </h4>
                                    <div class="modal fade" id="p<%= p.getPollid()%>">
                                        <div class="modal-dialog modal-sm">
                                          <div class="modal-content">
                                            <div class="modal-header">
                                              <h4 class="modal-title">Poll Information</h4>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                              <p><b>Created By:</b> <%= p.getPollStuName() %> </p>
                                              <p><b>Start Date/Time:</b><%= p.getStartDate().getDay()%>/<%= p.getStartDate().getMonth() +1 %>/<%= p.getStartDate().getYear()-100 %> - <%= p.getStartDate().getHours()%>:<%= p.getStartDate().getMinutes() %> </p>
                                              <p><b>End Date/Time:</b> <%= p.getEndDate().getDay()%>/<%= p.getEndDate().getMonth() +1 %>/<%= p.getEndDate().getYear()-100 %> - <%= p.getEndDate().getHours()%>:<%= p.getEndDate().getMinutes() %></p>
                                              <p><b>No of poll count:</b> <%= tAns %> </p>
                                              <p><b>Your vote:</b> <%= p.getPollMyAns() %> </p>
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
                                      <%
                                      	if(data != null){
                                      		int temp =1;
                                      		for(Map.Entry e : data.entrySet()){
                                         		float pr = 0; 
                                      			if(totalAns.get(e.getKey()) != null){
                                      				pr = (totalAns.get(e.getKey())*100)/tAns;
                                      			}
                                    
                                      %>
                                        <tr>
                                          <td><%= temp %></td>
                                          <td><%= e.getValue() %></td>
                                          <td>
                                            <div class="progress progress-xs">
                                              <div class="progress-bar progress-bar-danger" style="width: <%= pr %>%"></div>
                                            </div>
                                          </td>
                                          <td><span class="badge bg-danger"><%= pr %>%</span></td>
                                        </tr>
                                        <% 
                                        		temp+=1;
                                        	} 
                                      	}
                                        %>
                                      </tbody>
                                    </table>
                                  </div>
                            </div>
                            <!-- /.card -->
                            
                        </div>
                    </div>
                    <% } } %>
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