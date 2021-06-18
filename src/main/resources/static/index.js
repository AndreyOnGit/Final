angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/student/api/v1/students';

    $scope.fillTable = function (current_page = 1) {
        $http({
            url: contextPath,
            method: 'GET',
            params: {
                page: current_page
            }
        }).then(function (response) {
            $scope.StudentPage = response.data;
              $scope.PaginationArray = $scope.generatePageIndices(1,$scope.StudentPage.totalPages);
        });
    };

     $scope.generatePageIndices = function(firstPage,lastPage){
        let arr = [];
        for (let i = firstPage; i<lastPage+1; i++){
            arr.push(i);
            }
        return arr;
     }


    $scope.submitCreateNewStudent = function () {
        $http.post(contextPath, $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };

    $scope.submitUpdateStudent = function () {
        $http.post(contextPath, $scope.updateStudent)
            .then(function (response) {
                $scope.updateStudent = null;
                $scope.fillTable();
            });
    };

    $scope.deleteStudentById = function (studentId) {
        $http({
          url: contextPath + '/' + studentId,
          method: 'DELETE'
        }).then(function (response) {
            $scope.fillTable();
        });
    };

    $scope.fillTable();
});