<%-- 
    Document   : error
    Created on : Nov 28, 2020, 3:16:45 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@include file="./masters/header_links.jsp" %>
<body class="hold-transition sidebar-mini">
    <div class="wrapper">
        
<!--        <div class="content-wrapper">
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Error 404</h1>
                        </div>
                        <div class="col-sm-6">
                            
                        </div>
                    </div>
                </div>
            </section>
            <section class="content">
                
            </section>
        </div>-->
 <!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-warning"> 404</h2>

        <div class="error-content">
          <h3><i class="fas fa-exclamation-triangle text-warning"></i> Oops! Page not found.</h3>

          <p>
            We could not find the page you were looking for.
            Meanwhile, you may <a href="/classnet/login" >return to login</a> form.
          </p>

          
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
        <%@include file="./masters/footer_links.jsp" %>