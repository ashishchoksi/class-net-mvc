
<%@page import="java.util.HashMap"%>
<%@page import="com.classnet.model.Message"%>
<%@page import="com.classnet.model.Comment"%>
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
                        <div class="col-sm-6">
                            <h1>Messages</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">Message<li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <% HashMap<Integer,String> msg_types = new HashMap<Integer,String>() ; 
            	
            msg_types.put(1,"All Messages");
            msg_types.put(2,"CR Messages");
            msg_types.put(3,"Election Messages");
            msg_types.put(4,"SPC Messages");
            msg_types.put(5,"Acad Messages");
            String msg_type = msg_types.get((Integer)request.getAttribute("msg_type")).toString();
            %>
            <div class="col">
                
                
                <% ArrayList<Message> msgs = (ArrayList<Message>)request.getAttribute("msgs"); 
                
         			for(Message m : msgs){
         	
                %>
                <div class="card">
                    <div class="card-body">
                        <div class="tab-content">
                            <div class="active tab-pane" id="activity">
                                <!-- Post -->
                                <div class="post">
                                    <div class="user-block">
                                        <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg"
                                            alt="user image">
                                        <span class="username">
                                            <a href="#"><%=m.getTitle()%></a>
                                            <a href="delete-message?msgId=<%=m.getMessage_id()%>" class="float-right btn-tool">Delete</a>
                                        </span>
                                        <span class="description">Posted By - <%=m.getPosted_by().getSsid()%> (<%=m.getPosted_by().getStudent_name() %>) on <%=m.getMessage_date() %></span>
                                    </div>
                                    <!-- /.user-block -->
                                    <p>
                                    	
                                        <%=m.getContent()%>
                                        <% if(m.getDocuments().size() > 0) %><br/><br/> Documents <br/>
                                        <%  for(String s : m.getDocuments()) { 
                                            String path = "resources/student_docs/"+s;
                                        %>
                                        <a href="<%=path%>"><%=s%></a>
                                            <br>
                                        <% } %>
                                    </p>
            
                                    <p>
                                        <img src="${mres}/asset/icon/pin-empty.svg" alt="" style="width: 20px; height: 20px; margin-left: 5px; cursor: pointer;" onmouseover="pinHover(this);" onmouseout="pinUnhover(this);">
                                        <span class="float-right">
                                            <span class="text-sm blackHover" style="cursor:pointer;" onclick="commentBox_visibility('<%=m.getMessage_id()%>')">
                                                <i class="far fa-comments mr-1"></i> Comments (<%=m.getComments().size()%>)
                                            </span>
                                        </span>
                                    </p>
                                    
                                    
                                    
                                    <!-- // comment-- -->
                                    <div class="row" style="display: none;" id="<%=m.getMessage_id()%>">
                                        <div class="col">
                                            <div class="card">
                                                <!-- <div class="row"> -->
                                                    <!-- <div class="col"> -->
                                                    
                                                    <!-- handle comment -->
                                                    
                                                    <form method="post" action="comment">
                                                        <nav id="navbar-example2" class="navbar navbar-light bg-light" style="margin-bottom: 10px;">
                                                            <input class="form-control form-control-sm" type="text" placeholder="Type a comment" name="comment">
                                                            <input type="hidden" name="mid" value="<%= m.getMessage_id() %>" />
                                                        </nav>
                                                    </form>
                                                    
                                                    <!-- </div> -->
                                                <!-- </div> -->
                                                <div class="row">
                                                    
                                                    <div class="col scroll" >
                                                        
                                                        <% for( Comment c : m.getComments() ) { %>
                                                        
                                                        <!-- Single comment thread -->
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#"> <%=c.getSsid()%> </a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                <%=c.getComment_content()%>
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        
                                                        <% } %>
                                                            
                                                        <!-- /.user-block -->    
                                                        
                                                    </div>
                                                </div>
                                            
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <!-- // commennt--  -->
                                    
                                    
                                    
                                </div>
                                <!-- /.post -->
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <%} %>
                
                
               
                
              </div>
                <!-- /.nav-tabs-custom -->
            </div>
            <!-- /.content -->
        </div>
       
        <%@include file="./masters/footer_links.jsp" %>
        
        <!-- <select class="dropdown-menu btn btn-primary dropdown-toggle">
                                        <option><a class="dropdown-item" href="/view-message">All Messages</a></option>
                                        <option><a class="dropdown-item" href="/view-message?msgID=2" class="active">CR Messages</a></option>
                                        <option><a class="dropdown-item" href="/view-message?msgID=4">SPC Messages</a></option>
                                        <option><a class="dropdown-item" href="/view-message?msgID=3">Election Messages</a></option>
                                        <option><a class="dropdown-item" href="/view-message?msgID=5">Acad Messages</a></option>
                                    </select> -->