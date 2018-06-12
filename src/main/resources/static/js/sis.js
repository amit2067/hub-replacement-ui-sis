var sisApp = angular.module('sisApp', [ 'ngRoute' ]);

sisApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/sisCustomers', {
		templateUrl : 'sisCustomers.html',
		controller : 'sisAppController'
	}).when('/sisApplications', {
		templateUrl : 'sisApplications.html',
		controller : 'sisAppController'
	}).otherwise({
		templateUrl : 'sisCustomers.html',
		controller : 'sisAppController'
	});
} ]);

sisApp
	.factory(
		'sisService',
		[
			'$http',
			'$q',
			function($http, $q) {
				return {
					getCustomers : function(customer) {
						return $http
							.get(
								'/getCustomers')
							.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console
										.error('Error while fetching customers');
									return $q
										.reject(errResponse);
								});
					},
					getApplications : function(application) {
						return $http
							.get(
								'/getApplications')
							.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console
										.error('Error while fetching applications');
									return $q
										.reject(errResponse);
								});
					},
					saveCustomer : function(customer) {
						return $http
							.post(
								'/updateCustomer', customer)
							.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console
										.error('Error while saving Customer');
									return $q
										.reject(errResponse);
								});
					},
					saveApplication : function(application) {
						return $http
							.post(
								'/updateApplication', application)
							.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console
										.error('Error while saving application');
									return $q
										.reject(errResponse);
								});
					},
					confirmAttendance : function(application) {
						return $http
							.post(
								'/confirmAttendance', application)
							.then(
								function(response) {
									return response.data;
								},
								function(errResponse) {
									console
										.error('Error while confirming attendance');
									return $q
										.reject(errResponse);
								});
					}
				};
			} ]);

sisApp.controller('sisAppController', [ '$scope', 'sisService',
	function($scope, sisService) {

		$scope.customers = [];
		$scope.applications = [];
		$scope.showCustEditSection = [];
		$scope.showAppEditSection = [];

		$scope.heis = [
			{
				name : "University of Leeds",
				code : "UNLE"
			},
			{
				name : "Manchester University",
				code : "MANU"
			},
			{
				name : "Glasgow University",
				code : "GLAU"
			}
		];

		$scope.courses = [
			{
				name : "Biology",
				code : "12345"
			},
			{
				name : "Chemistry",
				code : "34567"
			},
			{
				name : "Mathematics",
				code : "25678"
			},
			{
				name : "Computer Science",
				code : "15680"
			}
		];

		$scope.courseYears = [
			{
				name : "1",
				code : "1"
			},
			{
				name : "2",
				code : "2"
			},
			{
				name : "3",
				code : "3"
			}
		];

		$scope.getHEIName = function(heiCode) {
			var heiName = "";
			for (var i = 0; i < $scope.heis.length; i++) {
				if ($scope.heis[i].code == heiCode) {
					heiName = $scope.heis[i].name;
				}
			}
			return heiName;
		}

		$scope.getCourseName = function(courseCode) {
			var courseName = "";
			for (var i = 0; i < $scope.courses.length; i++) {
				if ($scope.courses[i].code == courseCode) {
					courseName = $scope.courses[i].name;
				}
			}
			return courseName;
		}

		$scope.getCustomers = function() {

			showOverLay('ProcessingOverlay', true, 6000);
			sisService.getCustomers().then(function(data) {
				$scope.customers = data;
				showOverLay('ProcessingOverlay', false, 6000);
				if (typeof $scope.customers != "undefined" && $scope.customers != null) {
					for (var i = 0; i < $scope.customers.length; i++) {
						$scope.showCustEditSection[$scope.customers[i].id] = false;
					}
				}
			}, function(errResponse) {
				console.error('Error while fetching customers');
				showOverLay('ProcessingOverlay', false, 6000);
			});
		}

		$scope.getApplications = function() {

			showOverLay('ProcessingOverlay', true, 6000);
			sisService.getApplications().then(function(data) {
				$scope.applications = data;
				showOverLay('ProcessingOverlay', false, 6000);
				if (typeof $scope.applications != "undefined" && $scope.applications != null) {
					for (var i = 0; i < $scope.applications.length; i++) {
						$scope.showAppEditSection[$scope.applications[i].id] = false;
					}
				}
			}, function(errResponse) {
				console.error('Error while fetching applications');
				showOverLay('ProcessingOverlay', false, 6000);
			});

		}

		$scope.showCustomers = function() {
			showOverLay('ProcessingOverlay', true, 6000);
			location.href = "#sisCustomers";
			showOverLay('ProcessingOverlay', false, 6000);
		}

		$scope.showApplications = function() {
			showOverLay('ProcessingOverlay', true, 6000);
			location.href = "#sisApplications";
			showOverLay('ProcessingOverlay', false, 6000);
		}

		$scope.editCustDetails = function(customerId) {
			for (var i = 0; i < $scope.customers.length; i++) {
				$scope.showCustEditSection[$scope.customers[i].id] = false;
				if ($scope.customers[i].id == customerId) {
					$scope.customer = angular.copy($scope.customers[i]);
				}
			}
			$scope.showCustEditSection[customerId] = true;
		};

		$scope.hideCustDetails = function(customerId) {
			$scope.showCustEditSection[customerId] = false;
		};

		$scope.saveCustomer = function(customer) {

			showOverLay('ProcessingOverlay', true, 6000);
			sisService.saveCustomer(customer).then(function(data) {
				showOverLay('ProcessingOverlay', false, 6000);
				$scope.getCustomers();
			}, function(errResponse) {
				console.error('Error while saving customer details');
				showOverLay('ProcessingOverlay', false, 6000);
			});
		}

		$scope.editAppDetails = function(appId) {
			for (var i = 0; i < $scope.applications.length; i++) {
				$scope.showAppEditSection[$scope.applications[i].id] = false;
				if ($scope.applications[i].id == appId) {
					$scope.application = angular.copy($scope.applications[i]);
				}
			}
			$scope.showAppEditSection[appId] = true;
		};

		$scope.hideAppDetails = function(appId) {
			$scope.showAppEditSection[appId] = false;
		};

		$scope.saveApplication = function(application) {

			showOverLay('ProcessingOverlay', true, 6000);
			sisService.saveApplication(application).then(function(data) {
				showOverLay('ProcessingOverlay', false, 6000);
				$scope.getApplications();
			}, function(errResponse) {
				console.error('Error while saving application details');
				showOverLay('ProcessingOverlay', false, 6000);
			});
		}

		$scope.confirmAttendance = function(application) {

			showOverLay('ProcessingOverlay', true, 6000);
			application.confirmedAtnInd = 'Y';
			application.createdBy = 'SIS';
			sisService.confirmAttendance(application).then(function(data) {
				showOverLay('ProcessingOverlay', false, 6000);
				$scope.getApplications();
			}, function(errResponse) {
				console.error('Error while confirming attendance');
				showOverLay('ProcessingOverlay', false, 6000);
			});
		}

		$scope.getCustomers();
		$scope.getApplications();

	} ]);