 <!-- Main Sidebar Container -->
    <%@page import="com.classnet.model.Student"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
      <!-- Brand Logo -->
      <a href="#" class="brand-link">
        <img src="${mres}/images/DAIICT_logo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
          style="opacity: .8">
        <span class="brand-text font-weight-light">Class-Net</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
          <div class="image">
            <img src="${mres}/images/icons8-user-shield-64.png" class="img-circle elevation-2" alt="User Image">
          </div>
          <%Student s = (Student)request.getSession().getAttribute("studobj");%>
          <div class="info">
            <a href="profile" class="d-block"><%=s.getStudent_name() %></a>
          </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2 ">
          <ul class="nav nav-pills nav-sidebar nav-legacy nav-child-indent flex-column" data-widget="treeview"
            role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

            <li class="nav-item active">
              <a href="/classnet/" class="nav-link active">
                <i class="nav-icon fas fa-home"></i>
                <p>
                  Dashboard
                </p>
              </a>
            </li>

            <li class="nav-item has-treeview">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-envelope"></i>
                <p>
                  Manage Messages
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="view-message" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>View Messages</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="post-message" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Add Messages</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="my-message" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>My Messages</p>
                  </a>
                </li>
              </ul>
            </li>

            <li class="nav-item has-treeview">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-poll"></i>
                <p>
                  Manage Polls
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                  
                <li class="nav-item">
                  <a href="/classnet/add-poll" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Add polls</p>
                  </a>
                </li>
                
                <li class="nav-item">
                  <a href="/classnet/view-poll" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>View polls</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="/classnet/my-poll" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>My polls</p>
                  </a>
                </li>
              </ul>
            </li>

            <!-- Add / Revoke Access -->
            <li class="nav-item has-treeview">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-tachometer-alt"></i>
                <p>
                  Add/Revoke Permission
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="/classnet/assign-permission" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Assign Permission</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="/classnet/revoke-permission" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Revoke Permission</p>
                  </a>
                </li>
              </ul>
            </li>

            <li class="nav-item active">
              <a href="/classnet/logout" class="nav-link">
                <i class="far fas fa-sign-out-alt nav-icon"></i>
                <p>
                  Logout
                </p>
              </a>
            </li>

          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>