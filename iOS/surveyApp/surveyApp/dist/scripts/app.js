!function(){"use strict";angular.module("surveyApp",["ngRoute"]).config(["$locationProvider","$routeProvider",function(e,r){r.when("/",{templateUrl:"partials/home.html",controller:"homeController"}).when("/survey",{templateUrl:"partials/survey.html",controller:"surveyController"}).when("/surveyEnd",{templateUrl:"partials/surveyEnd.html",controller:"surveyEndController"}).when("/settings",{templateUrl:"partials/settings.html",controller:"settingsController"}).otherwise({redirectTo:"/"})}])}();