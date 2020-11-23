
<%@page import="com.classnet.model.Message"%>
<%@page import="java.util.ArrayList"%>
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
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-3">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                        All Messages
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="#">All Messages</a>
                                        <a class="dropdown-item" href="#">CR Messages</a>
                                        <a class="dropdown-item" href="#">SPC Messages</a>
                                        <a class="dropdown-item" href="#">Ele. Messages</a>
                                        <a class="dropdown-item" href="#">My Pin Messages</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-7">
                            <!-- <form class="navbar-white navbar-light form-inline ml-3">
                                <div class="input-group input-group-sm" style="margin:3px auto; width:auto">
                                    <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                                    <div class="input-group-append">
                                        <button class="btn btn-navbar" type="submit">
                                            <i class="fas fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form> -->
                            <button type="submit" class="btn btn-danger" style="margin: auto; display: block;">View Deleted Message</button>
                            </div>
                            <div class="col-2">
                                <!-- <img src="./asset/icon/pin-empty.svg" alt="pin" style="width: 32px; height: 32px; float: right; cursor: pointer;" onmouseover="pinHover(this);" onmouseout="pinUnhover(this);"> -->
                                <button type="submit" class="btn btn-primary" style="float: right;">Post Message</button>
                            </div>
                        </div>
                        
                    </div><!-- /.card-header -->
                </div>
                
                <% ArrayList<Message> msgs = (ArrayList<Message>)request.getAttribute("msgs"); 
                
         			//out.println(msgs.get(0));
                	
         			
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
                                            <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                        </span>
                                        <span class="description">Posted By - <%=m.getPosted_by().getSsid()%> (<%=m.getPosted_by().getStudent_name() %>) on <%=m.getMessage_date() %></span>
                                    </div>
                                    <!-- /.user-block -->
                                    <p>
                                        <%=m.getContent()%>
                                    </p>
            
                                    <p>
                                        <img src="${mres}/asset/icon/pin-empty.svg" alt="" style="width: 20px; height: 20px; margin-left: 5px; cursor: pointer;" onmouseover="pinHover(this);" onmouseout="pinUnhover(this);">
                                        <span class="float-right">
                                            <span class="text-sm blackHover" style="cursor:pointer;" onclick="commentBox_visibility('comment3')">
                                                <i class="far fa-comments mr-1"></i> Comments (5)
                                            </span>
                                        </span>
                                    </p>
                                    <!-- // comment-- -->
                                    <div class="row" style="display: none;" id="comment3">
                                        <div class="col">
                                            <div class="card">
                                                <!-- <div class="row"> -->
                                                    <!-- <div class="col"> -->
                                                        <nav id="navbar-example2" class="navbar navbar-light bg-light" style="margin-bottom: 10px;">
                                                            <input class="form-control form-control-sm" type="text" placeholder="Type a comment">
                                                        </nav>
                                                        
                                                    <!-- </div> -->
                                                <!-- </div> -->
                                                <div class="row">
                                                    <div class="col scroll" >
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus architecto, ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium dolores numquam rem sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <!-- /.user-block -->    
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus
                                                                architecto, ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium
                                                                dolores numquam rem sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus architecto,
                                                                ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium dolores numquam rem
                                                                sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <!-- /.user-block -->
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus
                                                                architecto, ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium
                                                                dolores numquam rem sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus architecto,
                                                                ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium dolores numquam rem
                                                                sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <!-- /.user-block -->
                                                        <div class="user-block" style="padding-left: 5px;">
                                                            <img class="img-circle img-bordered-sm" src="${mres}/dist/img/user1-128x128.jpg" alt="user image">
                                                            <span class="username">
                                                                <a href="#">Jonathan Burke Jr.</a>
                                                                <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                                            </span>
                                                            <p class="description">
                                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque ea tempora dolore iure repellendus
                                                                architecto, ipsam voluptas et voluptatum perferendis recusandae nostrum excepturi accusamus accusantium
                                                                dolores numquam rem sapiente. Adipisci.
                                                            </p>
                                                            <!-- <span class="description">Shared publicly - 7:30 PM today</span> -->
                                                        </div>
                                                        <!-- //.user-block-->
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