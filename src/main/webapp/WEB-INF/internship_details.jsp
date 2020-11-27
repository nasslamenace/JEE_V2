<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.Constants"%>
<!DOCTYPE html>
 <%--
        detail page which receive informations by the controler and display them thanks to the key defined in the controller
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/internship_details.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/header.css" />
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <title>DETAILS</title>
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
        <div id="container">
            <div id="top">
                <h1>Fiche des détails</h1>
                <img id="logo" src="${pageContext.request.contextPath}/img/efrei.png">
            </div>
            <div id="mid">
                <div id="ctop">
                    <div class="box" id="left">
                        <div class="hcont">
                            <h4>Details du stagiaire: ${Student.getFirstName()} ${Student.getLastName()}</h4>
                        </div>
                        <img src="${pageContext.request.contextPath}/img/pp.png" style="width: 100px; height: auto">
                        <table>
                            <tbody>
                                <tr>
                                    <td>Email:</td>
                                    <td>${Student.getEmail()}</td>
                                </tr>
                                <tr>
                                    <td>Nom:</td>
                                    <td>${Student.getLastName()}</td>
                                </tr>
                                <tr>
                                    <td>Prénom:</td>
                                    <td>${Student.getFirstName()}</td>
                                </tr>
                                <tr>
                                    <td>Groupe:</td>
                                    <td>${Student.getLevel()}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="box" id="right">
                        <div class="hcont">
                            <h4>Details de l'entreprise: ${Company.getName()}</h4>
                        </div>
                    <table>
                            <tbody>
                                <tr>
                                    <td>Nom:</td>
                                    <td>${Company.getName()}</td>
                                </tr>
                                <tr>
                                    <td>Adresse de l'entreprise:</td>
                                    <td>${Company.getAdress()}</td>
                                </tr>
                                <tr>
                                    <td>Maître d'apprentissage:</td>
                                    <td>${User.getFirst_name()} ${User.getLast_name()}</td>
                                </tr>
                                <tr>
                                    <td>Date de début:</td>
                                    <td>${Internship.getDate_Begin()}</td>
                                </tr>
                                <tr>
                                    <td>Date de fin:</td>
                                    <td>${Internship.getDate_End()}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="box" id="cbot" style="height: 300px;">
                    <div class="hcont">
                        <h4>Gestion du stage</h4>
                    </div>
                    <table>
                        <tbody>
                            <tr>
                                <td>Description de la mission:</td>
                                <td>${Internship.getMission_description()}</td>
                            </tr>
                            <tr>
                                <td>Commentaire:</td>
                                <td>${Internship.getCommentary()}</td>
                            </tr>
                            <tr>
                                <td>Remplir la fiche de visite:</td>
                                <td>XXXXX XXXXXX</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="bot">
                <button action="action" onclick="window.history.go(-1); return false;" type="submit" class="btn btn-raised btn-link">Retour</button>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>
    <body>
       
    </body>
</html>
