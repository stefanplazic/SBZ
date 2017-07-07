
'use strict';

angular.module('app')
	.controller('AddCategoryCtrl', ['$scope',
	    function($scope) {
		
		/**
		 * Dodavanje nove kategorije
		 */
		$scope.addCategory = function() {
			//Dodavanje zavrsiti
			console.log($scope.category)
		}
		
	}])
	.controller('AllCategoryCtrl', ['$scope',
	    function($scope) {
		

		/**
		 * Iscitati sve kategorije i prikayati ih
		 */
		$scope.category = [{id: 1, namePodCateogry: "Laptop"},
		                   {id: 2, namePodCateogry: "Desktop"},
		                   {id: 3, namePodCateogry: "Televizor"},
		                   {id: 4, namePodCateogry: "Telefon"},
		                   {id: 5, namePodCateogry: "Pratece oprema"},
		                   {id: 6, namePodCateogry: "MP3 Plyer"}]
		
	}])
	.controller('AddPodCategoryCtrl', ['$scope',
	    function($scope) {
		
		/**
		 * Dodavanje nove kategorije
		 */
		$scope.addPodCategory = function() {
			console.log("izspisati ");
			//dovrsiti ovo
		}
		
		/**
		 * Iscitati sve kategorije kako bi mogli da spojimo 
		 * podkategoriju sa kategorijom
		 */
		$scope.category = [{id: 1, namePodCateogry: "Laptop"},
		                   {id: 2, namePodCateogry: "Desktop"},
		                   {id: 3, namePodCateogry: "Televizor"},
		                   {id: 4, namePodCateogry: "Telefon"},
		                   {id: 5, namePodCateogry: "Pratece oprema"},
		                   {id: 6, namePodCateogry: "MP3 Plyer"}]
		
	}]);