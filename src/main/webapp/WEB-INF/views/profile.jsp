<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini">
		<div class="wrapper">
		  <%@include file="./masters/ec_index.jsp" %>
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
											src="./dist/img/user4-128x128.jpg"
											alt="User profile picture">
										</div>

										<h3 class="profile-username text-center">Lopamudra</h3>

										<p class="text-muted text-center">MSc-IT</p>

										<ul class="list-group list-group-unbordered mb-3">
											<li class="list-group-item">
												<b>ID</b> <a class="float-right">201912***</a>
											</li>
											<li class="list-group-item">
												<b>E-Mail</b> <a class="float-right">201912***@daiict.ac.in</a>
											</li>
											<li class="list-group-item">
												<b>Contact</b> <a class="float-right">9876543210</a>
											</li>
										</ul>

									</div>
								</div>
							</div>
							<div class="col-md-9">
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
												<form class="form-horizontal">
													<div class="form-group row">
														<label for="inputOldPassword" class="col-sm-3 col-form-label">Old password</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputOldPassword" placeholder="Old password">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputNewPassword" class="col-sm-3 col-form-label">New password</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputNewPassword" placeholder="New password">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputReNewPassword" class="col-sm-3 col-form-label">Confirm new password</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" id="inputReNewPassword" placeholder="Retype new password">
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
												<form class="form-horizontal">
													<div class="form-group row">
														<label for="inputName" class="col-sm-2 col-form-label">Name</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="inputName" placeholder="Name">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputContact" class="col-sm-2 col-form-label">Contact number</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="inputContact" placeholder="Contact number">
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