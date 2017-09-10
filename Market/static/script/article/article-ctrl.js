
'use strict';

angular.module('app')
	.controller('AddArticleCtrl', ['$scope',
	    function($scope) {
		
		/**
		 * Iscitati sve kategorije kako bi artikl povezali sa kategorijom
		 */
		$scope.category = [{id: 1, namePodCateogry: "Laptop"},
		                   {id: 2, namePodCateogry: "Desktop"},
		                   {id: 3, namePodCateogry: "Televizor"},
		                   {id: 4, namePodCateogry: "Telefon"},
		                   {id: 5, namePodCateogry: "Pratece oprema"},
		                   {id: 6, namePodCateogry: "MP3 Plyer"}]
		
		/**
		 * Dodati artikl
		 */
		$scope.addArticle = function() {
			console.log("povezati")
		}
		
	}])
	.controller('AllArticleCtrl', ['$scope',
	    function($scope) {
		
		/**
		 * Iscitati sve artikle
		 */
		$scope.article = [{id: 1, nameArticle: 'artil1'},
		                  {id: 2, nameArticle: 'artil2'},
		                  {id: 3, nameArticle: 'artil3'},
		                  {id: 4, nameArticle: 'artil4'},
		                  {id: 5, nameArticle: 'artil5'}]
		
	}])
	.controller('AllArticleByCategoryCtrl', ['$scope', '$routeParams',
	    function($scope, $routeParams) {
		var id = $routeParams.id;
		/**
		 * Iscitati sve artikle date kategorije id je parametar za pretragu
		 */
		
		$scope.article = [{id: 1, nameArticle: 'artil1'},
		                  {id: 2, nameArticle: 'artil2'},
		                  {id: 3, nameArticle: 'artil3'},
		                  {id: 4, nameArticle: 'artil4'},
		                  {id: 5, nameArticle: 'artil5'}]
		
	}]);