!function(){"use strict";angular.module("surveyApp").factory("serviceCall",["$http",function(o){function t(o,t){this.url={domain:localStorage.surveyAppServerSettings,method:t,name:o}}return t.prototype.call=function(t,e,n,r){var l=r||this.url.domain+"/"+this.url.name;console.log(l),console.log(this.url.method),console.log(t),o({method:this.url.method,url:l,data:t}).success(function(o,t,n,r){e(o,t,n,r)}).error(function(o,t,e,r){n(o,t,e,r)})},t}])}();