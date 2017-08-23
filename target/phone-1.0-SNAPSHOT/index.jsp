<html ng-app="app">
<head>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Angular Material style sheet -->
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
        <!-- load bootstrap and fontawesome via CDN -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />

        <!-- SPELLS -->
        <!-- load angular and angular route via CDN -->
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>

        <!-- Angular Material Library -->
        <script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>

        <script type="text/javascript" src="js/app.js"></script>
    </head>
<body >
<center>


    <div  ng-controller="AppCtrl" layout="column" layout-align="center center" layout-fill="layout-fill" ng-init="getData()">
        <h1>PhoneBook</h1>
        <div>
            <button ng-click="isReverse = false">Asc</button>
            <button ng-click="isReverse = true">Desc</button>
        </div>


        <md-content>
            <md-list flex="">
                <md-list-item class="lightBlue" class="md-4-line"  ng-click="null" ng-repeat="c in contacts| orderBy:c.name :isReverse" >
                    <div class="md-list-item-text" layout="column">
                        <h3>{{c.name}}</h3>
                        <h4>{{c.phone }}</h4>
                        <p>{{ c.address }}</p>

                    </div>
                    <md-divider></md-divider>
                </md-list-item>


            </md-list>
        </md-content>
    </div>
</center>
</body>
</html>
