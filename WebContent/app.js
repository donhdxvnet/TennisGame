//Module "Tennis"
var app = angular.module("Tennis", []);

//Directive "game"
app.directive("game", function()
{
	return{
		restrict: 'E',
		templateUrl: 'game.html'
	}	
});

//Directive "players"
app.directive("players", function()
{
	return{
		restrict: 'E',
		templateUrl: "players.html"	
	};
});

//TennisController
app.controller(
		'TennisController',
		['$rootScope', '$http', '$location', '$q', function($rootScope, $http, $location, $q){
			
	//Tennis		
	var tennis = this;
	
	//player
	var url = "/Tennis/rest/TennisService/players";
	$http.get(url)
	.success(
		function(data){
			tennis.players = data;			
		}
	);	
	
	//setScore
	tennis.setScore = function(id)
	{			
		var url = "/Tennis/rest/TennisService/players/" + id + "/setscore";
		var setscore = $http.post(url);
		
		var url = '/Tennis/rest/TennisService/players';
		var players = $http.get(url);
		
		//Promise chaining
		$q.all([setscore, players]).then(function(result)
		{
			angular.forEach(result, function(response)
			{
				//tmp.push(response.data);
				if (response.data != "")
					tennis.players = response.data;			
			});
			//return tmp;
		});		
	}
		
}]);

