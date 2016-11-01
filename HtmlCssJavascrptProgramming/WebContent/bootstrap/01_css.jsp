<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ page pageEncoding = "EUC-KR" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset = "UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- 부트스트랩 css 추가 -->
    <link href="../common/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
    <!-- 부트스트랩 jquery추가하기 -->
    <script type="text/javascript" src="../common/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>    
</head>
<body>
   Bootstrap
   <hr/>
   
   <br><br>Options<hr/>
   <!-- Standard button -->
   <button type="button" class="btn btn-default">Default</button>
   
   <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
   <button type="button" class="btn btn-primary">Primary</button>
   
   <!-- Indicates a successful or positive action -->
   <button type="button" class="btn btn-success">Success</button>
   
   <!-- Contextual button for informational alert messages -->
   <button type="button" class="btn btn-info">Info</button>
   
   <!-- Indicates caution should be taken with this action -->
   <button type="button" class="btn btn-warning">Warning</button>
   
   <!-- Indicates a dangerous or potentially negative action -->
   <button type="button" class="btn btn-danger">Danger</button>
   
   <!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
   <button type="button" class="btn btn-link">Link</button>
   
   <br><br>Bordered table<hr/>
   <table class="table table-bordered">
     <tr class="active">
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
     </tr>
     <tr class="success">
        <td>1</td>
        <td>제목1</td>
        <td>글쓴이1</td>
     </tr>
     <tr class="warning">
        <td>1</td>
        <td>제목1</td>
        <td>글쓴이1</td>
     </tr>
   </table>
   
   <br><br>Bordered table<hr/>
   <img src="../common/image/photo1.jpg" width="100px" height="100px" class="img-rounded">
   <img src="../common/image/photo1.jpg" width="100px" height="100px" class="img-circle">
   <img src="../common/image/photo1.jpg" width="100px" height="100px" class="img-thumbnail">
   
   <br><br>Components<hr/>
   <span class="glyphicon glyphicon-search" aria-hidden="true"></span>   
   
   <br><br>Split button dropdowns<hr/>
   <!-- Split button -->
   <div class="btn-group" style="width: 1000px;">
     <button type="button" class="btn btn-danger">Action</button>
     <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       <span class="caret"></span>
       <span class="sr-only">Toggle Dropdown</span>
     </button>
     <ul class="dropdown-menu">
       <li><a href="#">Action</a></li>
       <li><a href="#">Another action</a></li>
       <li><a href="#">Something else here</a></li>
       <li role="separator" class="divider"></li>
       <li><a href="#">Separated link</a></li>
     </ul>
   </div>
   
</body>
</html>