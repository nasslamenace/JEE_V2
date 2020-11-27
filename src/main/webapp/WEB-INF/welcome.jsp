<%@page import="model.Student"%>
<%@page import="utils.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%--
        Main page which receive informations by the controler and display them thanks to the key defined in the controller
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>WELCOME</title>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/welcome.css" />
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/header.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <form method="logout" action="Controller">
        <div class="navbar1">
        <ul id="navbar-container">
            <img class="nav-button leftnav" id="logo" src="${pageContext.request.contextPath}/img/efrei.png">
            <li class="navright"><button type="submit" class="nav-button" name="logout">LOG OUT</button></li>
        </ul>
        </div>
        </form>
        <form method="btn_Detail" action="Controller">
        <div id="container">
            <div id="top">
                <h1 id="titre">Extranet myEfrei</h1>
                <img id="logo" src="${pageContext.request.contextPath}/img/efrei.png">
            </div>
            <hr>
            <div id="infos">
                    <img id="myefrei" src="${pageContext.request.contextPath}/img/myefrei.png">
                    <div id="text">
                        <h3>Bienvenue sur le portail des Tuteurs</h3>
                        <p>myEfrei est votre nouvelle plateforme extranet. Elle remplacera progressivement l'extranet campus groupe Efrei et deviendra à terme votre point d'accès unique aux applications et sites partenaires.</p>
                        <p>Le site évoluera prochainement et les fonctionnalités s'étofferont au fil des mois...</p> 
                    </div>
                </div>
                <div id="array">
                    <div id="title">
                        <h2 id="titre2">Liste de mes étudiants:</h2>
                    <table class="table">
                        <thead class="thead">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Prénom</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Mail</th>
                                <th scope="col">Groupe</th>
                                <th scope="col">Fiche Visite</th>
                                <th scope="col">Fiche éval</th>
                                <th scope="col">Sondage Web</th>
                                <th scope="col">Rapport Rendu</th>
                                <th scope="col">Soutenance</th>
                                <th scope="col">Visite planifié</th>
                                <th scope="col">Note Technique</th>
                                <th scope="col">Note Communication</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${keyListOfStudents}" var="student">                            
                                <tr>
                                    <td><input type="radio" value = "${student.ID}" name="one_student"></td>
                                    <td>${student.email}</td>
                                    <td>${student.firstName}</td>
                                    <td>${student.lastName}</td>
                                    <td>${student.level}</td>
                                    <td><input type="checkbox" name="VISITE_SHIT" value = "${student.ID}" ${student.getTab().getVisiteShit()}></td>
                                    <td><input type="checkbox" name="EVAL_SHIT_COMPANY" value = "${student.ID}" ${student.getTab().getEvalShitCompany()}></td>
                                    <td><input type="checkbox" name="WEB_SONDAGE" value = "${student.ID}" ${student.getTab().getWebSondage()}></td>
                                    <td><input type="checkbox" name="RAPPORT_SEND" value = "${student.ID}" ${student.getTab().getRapportSend()}></td>
                                    <td><input type="checkbox" name="ORAL_DONE" value = "${student.ID}" ${student.getTab().getOralDone()}></td>
                                    <td><input type="checkbox" name="VISIT_CHECK" value = "${student.ID}" ${student.getTab().getVisitCheck()}></td>
                                    <td><input type="text" name="Technical_grade" value="${student.getTab().getTechnical_Grade()}"></td>
                                    <td><input type="text" name="Communication_grade" value = "${student.getTab().getComm_Grade()}"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="bot">
                    <button class="btn btn-primary" type="submit" name="add">AJOUTER</button>
                    <button class="btn btn-primary" type="submit" name="validate" onclick="validation()">VALIDER</button>
                    <button class="btn btn-primary" type="submit" name="detail">DETAILS</button>
                </div>
            </form>
        </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>    
    </body>
</html>