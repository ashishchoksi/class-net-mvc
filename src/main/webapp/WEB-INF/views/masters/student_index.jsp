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
            <img src="${mres}/dist/img/user3-128x128.jpg" class="img-circle elevation-2" alt="User Image">
          </div>
          <%Student s = (Student)request.getSession().getAttribute("studobj");%>
          <div class="info">
            <a href="profile" class="d-block"><%=s.getStudent_name()%></a>
          </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2 ">
          <ul class="nav nav-pills nav-sidebar nav-legacy nav-child-indent flex-column" data-widget="treeview"
            role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

            <li class="nav-item">
              <a href="view-message" class="nav-link active">
                <i class="nav-icon fas fa-envelope"></i>
                <p>
                  Messages
                </p>
              </a>
            </li>

            <li class="nav-item">
              <a href="view-poll" class="nav-link">
                <i class="nav-icon fas fa-poll"></i>
                <p>
                  Poll
                </p>
              </a>
            </li>

            <!-- Add / Revoke Access -->


          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>
