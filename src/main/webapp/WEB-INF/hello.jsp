<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/hello.css" />
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <title>HELLO</title>
    </head>
    <body>
        <div id="container">
            <div id="top">
                <div id="logox">
                    <img class="logo" src="${pageContext.request.contextPath}/img/efrei.png" alt="Logo Efrei Paris">
                </div>
                <h3>Authentification</h3>
            </div>
            <div id="bottom">
                ${keyErrMess}
                <form name="frm_index" action="Controller">
                    
                <div class="form-group logs">
                    <label for="exampleInputEmail1" class="bmd-label-floating">Email address</label>
                    <input name="loginForm" type="email" class="form-control" id="exampleInputEmail1">
                    <span class="bmd-help">We'll never share your email with anyone else.</span>
                </div>
                <div class="form-group logs">
                    <label for="exampleInputPassword1" class="bmd-label-floating">Password</label>
                    <input name="passForm" type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div id="bot">
                     <button type="submit" class="btn btn-primary btn-raised sub" name="btn_Send" value="Send">CONNEXION</button>
                </div>
                </form>
            </div>  
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
        <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>
    </body>
</html>
 <%--
        Just a simple connexion page which send informations to the controler
--%>
        
