<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        <%@include file="./masters/sidebar.jsp" %>
        <div class="content-wrapper">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Profile</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">User Profile</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>
            <section class="content">
                <div class="container-fluid">

                    <div class="row">

                        <div class="col-md-3">

                            <div class="card card-primary card-outline">
                                <div class="card-body box-profile">
                                    <div class="text-center">
                                        <img class="profile-user-img img-fluid img-circle"
                                             src="${mres}/images/DAIICT_logo.png"
                                             alt="User profile picture">
                                    </div>

                                    <h3 class="profile-username text-center">${name}</h3>

                                    <p class="text-muted text-center">${pgm}</p>

                                    <ul class="list-group list-group-unbordered mb-3">
                                        <li class="list-group-item">
                                            <b>ID</b> <a class="float-right">${ssid}</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>E-Mail</b> <a class="float-right">${email}</a>
                                        </li>
                                        <!--                                        <li class="list-group-item">
                                                                                    <b>Contact</b> <a class="float-right">9876543210</a>
                                                                                </li>-->
                                    </ul>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <% if((String)request.getAttribute("success_msg") != null) { %>
                            <div class="alert alert-success alert-dismissible">
                                ${success_msg}
                                <button type="button" class="close" data-dismiss="alert" alia-label=""Close>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <% } if((String)request.getAttribute("err_msg") != null) { %>
                            <div class="alert alert-danger alert-dismissible">
                                ${err_msg}
                                <button type="button" class="btn btn-danger btn-sm " data-toggle="modal" data-target="#modal-default">
                                    <i class="fas fa-info"></i>
                                </button>
                                <button type="button" class="close" data-dismiss="alert" alia-label=""Close>
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <% } %>
<!--                            <h3 style="color:red;"> ${err_msg} </h3> error message 
                            <h3 style="color:green;"> ${success_msg} </h3> success message -->

                            <div class="modal fade" id="modal-default">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Reasons for error to occur</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <h4>Change Password section</h4>
                                            <b>1. </b><p>Password Length must grater than 5 characters</p>
                                            <b>2. </b><p>New password and confirm password miss match</p>
                                            <b>3. </b><p>Old Password is incorrect</p>
                                            <br>
                                            <h4>Update Profile section</h4>
                                            <b>1. </b><p>Invalid name</p>
                                            
                                            <b style="color: red">There is some problem from our side!</b>
                                        </div>
                                        <div class="modal-footer justify-content-between">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->

                            <div class="card">
                                <div class="card-header p-2">
                                    <ul class="nav nav-pills">
                                        <li class="nav-item"><a class="nav-link" href="#updatePasswordSection" data-toggle="tab">Change Password</a></li>
                                        <li class="nav-item"><a class="nav-link active" href="#updateProfileSection" data-toggle="tab">Update Profile</a></li>
                                    </ul>
                                </div>

                                <div class="card-body">
                                    <div class="tab-content">
                                        <div class="tab-pane" id="updatePasswordSection">

                                            <form class="form-horizontal" action="profilePassword" method="POST">
                                                <div class="form-group row">
                                                    <label for="inputOldPassword" class="col-sm-3 col-form-label">Old password</label>
                                                    <div class="col-sm-9">
                                                        <input type="password" class="form-control" name="old_pass" id="inputOldPassword" placeholder="Old password" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="inputNewPassword" class="col-sm-3 col-form-label">New password</label>
                                                    <div class="col-sm-9">
                                                        <input type="password" class="form-control" name="new_pass" id="inputNewPassword" placeholder="New password" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="inputReNewPassword" class="col-sm-3 col-form-label">Confirm new password</label>
                                                    <div class="col-sm-9">
                                                        <input type="password" class="form-control" name="conf_new_pass" id="inputReNewPassword" placeholder="Retype new password" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="offset-sm-3 col-sm-9">
                                                        <button type="submit" class="btn btn-danger">Change password</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="active tab-pane" id="updateProfileSection">
                                            <form class="form-horizontal" action="profileUpdate" method="POST">
                                                <div class="form-group row">
                                                    <label for="inputName" class="col-sm-2 col-form-label">Name</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="name" id="inputName" placeholder="Name">
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <div class="offset-sm-2 col-sm-10">
                                                        <button type="submit" class="btn btn-danger">Update</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <%@include file="./masters/footer_links.jsp" %>