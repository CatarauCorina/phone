var app = angular.module('app', ['ngMaterial','ngMessages']);



    app.controller('AppCtrl',['$scope','$http', function($scope,$http){
    $scope.contacts=[]


    $scope.getData = function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/contacts/'
        }).then(function successCallback(data) {
          $scope.contacts=data.data
        }, function errorCallback(data) {
            console.log("error");
        });
    };


}]);