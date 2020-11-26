<aside class="control-sidebar control-sidebar-dark">
      <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
    
    <footer class="main-footer">
            <strong>� 2020-21 | Design by Class-Net Developers with the help of <a
                href="http://adminlte.io">AdminLTE.io</a></strong>
            <!-- All rights reserved. -->
            <div class="float-right d-none d-sm-inline-block">
              <b>Version</b> 0.0.1
            </div>
          </footer>
    
  </div>
  <!-- ./wrapper -->

    
        <!-- Toster -->
        <script src="${mres}/plugins/toastr/toastr.min.js"></script>
        <!-- jQuery -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="${mres}/plugins/jquery/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="${mres}/plugins/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
          $.widget.bridge('uibutton', $.ui.button)
        </script>
        <!-- Bootstrap 4 -->
        <script src="${mres}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- ChartJS -->
        <script src="${mres}/plugins/chart.js/Chart.min.js"></script>
        <!-- Sparkline -->
        <script src="${mres}/plugins/sparklines/sparkline.js"></script>
        <!-- JQVMap -->
        <script src="${mres}/plugins/jqvmap/jquery.vmap.min.js"></script>
        <script src="${mres}/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="${mres}/plugins/jquery-knob/jquery.knob.min.js"></script>
        <!-- daterangepicker -->
        <script src="${mres}/plugins/moment/moment.min.js"></script>
        <script src="${mres}/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- Tempusdominus Bootstrap 4 -->
        <script src="${mres}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
        <!-- Summernote -->
        <script src="${mres}/plugins/summernote/summernote-bs4.min.js"></script>
        <!-- overlayScrollbars -->
        <script src="${mres}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${mres}/dist/js/adminlte.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="${mres}/dist/js/pages/dashboard.js"></script>
        <!-- bs-custom-file-input -->
        <script src="${mres}/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${mres}/dist/js/demo.js"></script>
  

        <!-- Select2 -->
        <script src="${mres}/plugins/select2/js/select2.full.min.js"></script>
        <!-- Bootstrap4 Duallistbox -->
        <script src="${mres}/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
        <!-- InputMask -->
        <script src="${mres}/plugins/moment/moment.min.js"></script>
        <script src="${mres}/plugins/inputmask/min/jquery.inputmask.bundle.min.js"></script>
        <!-- date-range-picker -->
        <script src="${mres}/plugins/daterangepicker/daterangepicker.js"></script>

        <!-- bootstrap color picker -->
        <script src="${mres}/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>

        <!-- Bootstrap Switch -->
        <script src="${mres}/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>

        <!-- DataTables -->
        <script src="${mres}/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="${mres}/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="${mres}/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
        <script src="${mres}/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
        

        <!-- post message JS -->
        <script type="text/javascript">
            
            // poll toster
      $('#toastsDefaultInfoPoll').click(function() {
        $(document).Toasts('create', {
          class: 'bg-info', 
          title: 'Information',
          body: 'Click on Add button for adding more options. Remove button will remove selected row with entered data'
        })
      });
      
      
          var checkBox = document.getElementById("customSwitch1");
          var row_check = document.getElementById("newRow");
          var btn_check = document.getElementById("addRowMsg");
          var default_row_check = document.getElementById("inputFormRow");
  
          row_check.hidden = true;
          btn_check.hidden = true;
          default_row_check.hidden = true;
          checkBox.checked=false;
  
        // message toster
          $('.toastsDefaultInfo').click(function() {
        $(document).Toasts('create', {
          class: 'bg-info', 
          title: 'Information',
          body: 'If you wants to add document toggle want to add document button. want to add more than file ? click on add button'
        })
      });
      
      
          // add row message
          $("#addRowMsg").click(function () {
              var html = '';
              html += '<div id="inputFormRow">';
              html += '<div class="input-group mb-3">';
              html += '<div class="custom-file">';
              html += '<input type="file" name="title[]" class="form-control">';
              html += '<div class="input-group-append">';
              html += '<button id="removeRowMsg" type="button" class="btn btn-danger">Remove</button>';
              html += '</div>';
              html += '</div>';
  
              $('#newRow').append(html);
          });
  
          // remove row
          $(document).on('click', '#removeRowMsg', function () {
              $(this).closest('#inputFormRow').remove();
          });
  
          function checkFunction() {
  
  
              if (checkBox.checked == true) {
                  row_check.hidden = false;
                  btn_check.hidden = false;
                  default_row_check.hidden = false;
              } else {
                  row_check.hidden = true;
                  btn_check.hidden = true;
                  default_row_check.hidden = true;
              }
          }
  
      </script>
  
      <script type="text/javascript">
          $(document).ready(function () {
              bsCustomFileInput.init();
          });
      </script>


  <!-- Page script -->
  <script>
    $(function () {
      //Initialize Select2 Elements
      $('.select2').select2()

      //Initialize Select2 Elements
      $('.select2bs4').select2({
        theme: 'bootstrap4'
      })

      //Datemask dd/mm/yyyy
      $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
      //Datemask2 mm/dd/yyyy
      $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
      //Money Euro
      $('[data-mask]').inputmask()

      //Date range picker
      $('#reservationdate').datetimepicker({
        format: 'L'
      });
      //Date range picker
      $('#reservation').daterangepicker()
      //Date range picker with time picker
      $('#reservationtime').daterangepicker({
        timePicker: true,
        timePickerIncrement: 30,
        locale: {
          format: 'MM/DD/YYYY hh:mm A'
        }
      })
      //Date range as a button
      $('#daterange-btn').daterangepicker(
        {
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          startDate: moment().subtract(29, 'days'),
          endDate: moment()
        },
        function (start, end) {
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
        }
      )

      //Timepicker
      $('#timepicker').datetimepicker({
        format: 'LT'
      })

      //Bootstrap Duallistbox
      $('.duallistbox').bootstrapDualListbox()

      //Colorpicker
      $('.my-colorpicker1').colorpicker()
      //color picker with addon
      $('.my-colorpicker2').colorpicker()

      $('.my-colorpicker2').on('colorpickerChange', function (event) {
        $('.my-colorpicker2 .fa-square').css('color', event.color.toString());
      });

      $("input[data-bootstrap-switch]").each(function () {
        $(this).bootstrapSwitch('state', $(this).prop('checked'));
      });

    })
  </script>
  
  
  <!-- page script revoke-permission -->
  <script>
    $(function () {
      $("#example1").DataTable({
        "responsive": true,
        "autoWidth": false,
      });
      $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "responsive": true,
      });
    });
  </script>
  
  <!-- page script add-poll -->
  <script type="text/javascript">
    
      $('.toastrDefaultInfo').click(function() {          
        toastr.info('Click Add button for add more option. Click Remove for removing selected option')
      });
  
  </script>
  <!-- page script add-poll -->
  <script type="text/javascript">
        // add row
        $("#addRowpoll").click(function () {
            var html = '';
            html += '<div id="inputFormRowPoll">';
            html += '<div class="input-group mb-3">';
            html += '<input type="text" name="title[]" class="form-control m-input" placeholder="Enter option" autocomplete="on">';
            html += '<div class="input-group-append">';
            html += '<button id="removeRow" type="button" class="btn btn-danger">Remove</button>';
            html += '</div>';
            html += '</div>';
    
            $('#newRowpoll').append(html);
        });
    
        // remove row
        $(document).on('click', '#removeRow', function () {
            $(this).closest('#inputFormRowPoll').remove();
        });
    </script>
    
  
</body>

</html>