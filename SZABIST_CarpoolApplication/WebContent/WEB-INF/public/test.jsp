<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(window).load(function(){
    $('#myModal').modal('show')});
</script>

 <script type="text/javascript">
function randomPin(){
	var t= prompt("Enter Your Pin No","");
	alert("THis is value"+t);
}
</script>
<!-- <script>
$.ajax({
    url: 'path/to/TestServlet',
    data: {
        postVariableName: t
    },
    type: 'POST'
});
</script> --> 
</head>
<body>
<!-- <h2>Example of creating Modals with Twitter Bootstrap</h2> -->

<!-- Button trigger modal -->
<!-- <button class = "btn btn-primary btn-lg" data-toggle = "modal" data-target = "#myModal">
   Launch demo modal
</button> -->

<!-- Modal -->
<div  id="myModal" class = "modal fade" id = "myModal" tabindex = "-1" role = "dialog" 
   aria-labelledby = "myModalLabel" aria-hidden = "true">
   
   <div class = "modal-dialog modal-sm">
      <div class = "modal-content">
         
         <div class = "modal-header">
            <button type = "button" class = "close" data-dismiss = "modal" aria-hidden = "true">
                  &times;
            </button>
            
            <h4 class = "modal-title" id = "myModalLabel">
               Verify Your Email
            </h4>
         </div>
         <form action="TestServlet" method="post">
         
         
         <div class = "modal-body">
         <div class="form-group">
            <label for="message-text" class="control-label">Enter Your Secret Pin No</label>
            <input type="text" class="form-control" id="recipient-name" name="pinNo">
           </div>
         
         
         </div>
         
         <div class = "modal-footer">
            
            
            <button type ="submit" class="btn btn-primary">Submit</button>
         </div>
         </form>
         
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
  
</div><!-- /.modal -->

</body>
</html>