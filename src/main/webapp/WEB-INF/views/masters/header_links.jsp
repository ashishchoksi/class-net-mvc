<%@page contentType="text/html" isELIgnored="false" pageEncoding="windows-1252"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ClassNet</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <spring:url value="/resources" var="mres" />  
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${mres}/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${mres}/plugins/daterangepicker/daterangepicker.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="${mres}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${mres}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="${mres}/plugins/jqvmap/jqvmap.min.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${mres}/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
  
  <!-- Select2 -->
  <link rel="stylesheet" href="${mres}/plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="${mres}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Bootstrap4 Duallistbox -->
  <link rel="stylesheet" href="${mres}/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
  
  <!-- Theme style -->
  <link rel="stylesheet" href="${mres}/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${mres}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${mres}/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="${mres}/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- Toastr -->
    <link rel="stylesheet" href="${mres}/plugins/toastr/toastr.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${mres}/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="${mres}/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  
  
  <style>
        .blackHover:hover{
            color: black;
            background-image: url();
        }
        .scroll {
            max-height: 300px;
            overflow-y: auto;
        }
    </style>
    <script>
        function pinHover(element) {
            element.setAttribute('src', '${mres}/asset/icon/pin-fill.svg');
        }

        function pinUnhover(element) {
            element.setAttribute('src', '${mres}/asset/icon/pin-empty.svg');
        }
        function commentBox_visibility(id) {
                var e = document.getElementById(id);
                if (e.style.display == 'block')
                    e.style.display = 'none';
                else
                    e.style.display = 'block';
            }
        function timeConversion(start,end){
            let sDate = new Date(start);
            let eDate = new Date(end);
            if(Math.abs(eDate.getFullYear()-sDate.getFullYear()))
                return  Math.abs(eDate.getFullYear() - sDate.getFullYear()) + " Year";
            if(Math.abs(eDate.getMonth() - sDate.getMonth()))
                return Math.abs(eDate.getMonth() - sDate.getMonth()) + " Months";
            if(Math.abs(eDate.getDay() - sDate.getDay()))
                return Math.abs(eDate.getDay() - sDate.getDay()) + " Days";
            if(Math.abs(eDate.getHours() - sDate.getHours()))
                return Math.abs(eDate.getHours() - sDate.getHours()) + " Hrs.";
            if(eDate.getMinutes() - sDate.getMinutes()){
                return Math.abs(eDate.getMinutes() - sDate.getMinutes()) + " Minutes";
            }
            if(eDate.getSeconds() - sDate.getSeconds()){
                return  Math.abs( eDate.getSeconds() - sDate.getSeconds() ) + " Seconds"
            }
        }
    </script>
  
  
</head>
