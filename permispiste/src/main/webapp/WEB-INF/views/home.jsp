<%--
  Created by IntelliJ IDEA.
  User: lafay
  Date: 03/05/2017
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:include page="commun/header.jsp" />
<h1>Bienvenue sur Licence T Learning</h1>
<div class="jumbotron text-center">
    <p><img src="../../includes/images/LtL.png"></p>
    <p>Cette application permet de gérer votre apprentissage pour passez votre permis T ou TZ.</p>
</div>
<div class="row">
    <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${totalApprenants}</div>
                        <div>Nombre d'inscrits</div>
                    </div>
                </div>
            </div>
            <a href="/apprenants/">
                <div class="panel-footer">
                    <span class="pull-left">Voir les inscrits</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6">
        <div class="panel panel-green">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-send-o fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${totalParties}</div>
                        <div>Nombre de parties lanc&eacute;es</div>
                    </div>
                </div>
            </div>
            <a href="/actions/apprenant/all">
                <div class="panel-footer">
                    <span class="pull-left">Voir l'historique des parties</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6">
        <div class="panel panel-yellow">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-trophy fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${moyenneScores}</div>
                        <div>Score Moyen</div>
                    </div>
                </div>
            </div>
            <a href="/actions/apprenant/all">
                <div class="panel-footer">
                    <span class="pull-left">Voir l'historique des parties</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6">
        <div class="panel panel-red">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-calendar-o fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${nombrePartiesAujourdhui}</div>
                        <div>Parties programmées aujourd'hui</div>
                    </div>
                </div>
            </div>
            <a href="/inscrits/">
                <div class="panel-footer">
                    <span class="pull-left">Voir les inscriptions</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
</div>
<jsp:include page="commun/footer.jsp" />
