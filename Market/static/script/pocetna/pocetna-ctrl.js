'use strict';

angular.module('app')
	.controller('PocetnaCtrl', ['$scope',
	    function($scope) {
		
		/**
		 * Trena iscitati broj svih korisnike i jos neke podatke po zelji
		 * 
		 */
		$scope.allUser = 1202548;
		
		
		/**
		 * Treba iscitati broj svih prodatih artikala
		 */
		$scope.allBuyArticle = 125488;
		
		
		/**
		 * Procenat posecenosti iscitati sve korisnike i iscitati danas ulogovane korisnike
		 */
		$scope.userProcent = 25;
		
		
		/**
		 * Iscitati sve registrovane artikle i prikazati
		 */
		$scope.allArticle = 120000
		
	}]);