'use strict';

angular
	.module('app', [
	    'ngResource',
	    'ngRoute',
	    'ngCookies',
	    'ngStorage',
	    'restangular',
	    'lodash'
    ])
    .config(['$routeProvider', function($routeProvider) {
    	$routeProvider
	    	.when('/', {
				templateUrl: 'view/pocetnaUser.html'
			})
    		.when('/admin', {
    			templateUrl: 'view/pocetna.html'
    		})
    		.when('/add/article', {
    			templateUrl: 'view/dodatiArtikl.html',
    			controller: 'AddArticleCtrl'
    		})
    		.when('/add/category', {
    			templateUrl: 'view/didatiKategoriju.html',
    			controller: 'AddCategoryCtrl'
    		})
    		.when('/add/podcategory', {
    			templateUrl: 'view/dodatiPodkategoriju.html',
    			controller: 'AddPodCategoryCtrl'
    		})
    		.when('/add/event', {
    			templateUrl: 'view/dodatiAkciju.html'
    		})
    		.when('/view/article', {
    			templateUrl: 'view/sveArtikle.html',
    			controller: 'AllArticleCtrl'
    		})
    		.when('/view/category', {
    			templateUrl: 'view/pregledKategorija.html',
    			controller: 'AllCategoryCtrl'
    		})
    		.when('/view/category/:id',{
    			templateUrl: 'view/sveArtikle.html',
    			controller: 'AllArticleByCategoryCtrl'
    		})
    		.when('/cart', {
    			templateUrl: 'view/cart.html',
    			controller: 'CartCrtl'
    		})
    }])
    
    .run(['Restangular', '$log', '$rootScope', '$http', '$location', '$localStorage', function(Restangular, $log, $rootScope, $http, $location, $localStorage) {
        Restangular.setBaseUrl("api");
        Restangular.setErrorInterceptor(function(response) {
            if (response.status === 500) {
                $log.info("internal server error");
                return true; // greska je obradjena
            }
            return true; // greska nije obradjena
        });
        /*
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = $localStorage.currentUser.token;
        }
        $rootScope.logout = function () {
        	LoginResources.logout();
        }
        $rootScope.getCurrentUserRole = function () {
            if (!LoginResources.getCurrentUser()){
              return "prazno";
            }
            else{
            	return LoginResources.getCurrentUser().rola;
            }
        }
        
        $rootScope.getCurrentUserName = function () {
            if (!LoginResources.getCurrentUser()){
              return "prazno";
            }
            else{
            	return LoginResources.getCurrentUser();
            }
        }
        
        $rootScope.isLoggedIn = function () {
            if (LoginResources.getCurrentUser()){
              return true;
            }
            else{
              return false;
            }
        }
        $rootScope.getCurrentState = function () {
          return $state.current.name;
        }
        */
        
    }])