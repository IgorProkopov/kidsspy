<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <title>Kid Spy</title>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script type="text/javascript" src="../../resources/js/jquery-2.0.3.js"></script>
    <script>
        var l=0;
        var coordinates;

        function setLength(){
           coordinates = new Array(l);
        }

        //var coordinates = new Array(220);
        function setCoordinates(index, value) {
            if(index == 0)
                setLength();
            coordinates[index] = value;
        }

        function initialize() {
            //var coordinates = ${message};
                    //[<c:forEach items="${message}" var="coord"> coord    </c:forEach>];

            var mapOptions = {
                maxZoom:50,
                minZoom: 3,
                zoom: 3,
                center: new google.maps.LatLng(0, -180),
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                streetViewControl: false
            };
            var map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);
            var path = new Array(coordinates.length/2);
            console.log(path.length);
                for(var x = 0; x<path.length;x++){
                    path[x]=new google.maps.LatLng(coordinates[x*2], coordinates[(x*2)+1]);
            }

            var flightPath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FF0000',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            flightPath.setMap(map);

            if(typeof path != 'undefined'){
                console.log("Creating marker!")
                var marker = new google.maps.Marker({
                    position: path[path.length],
                    map: map,
                    title: 'Hello World!'
                });
            }
        }

        google.maps.event.addDomListener(window, 'load', initialize);

    </script>
</head>
<body>

    <c:forEach var="item" items="${message}" varStatus="loop">
    <script>
        l++;
    </script>

    </c:forEach>

<c:forEach var="item" items="${message}" varStatus="loop">
    <script>
        setCoordinates(${loop.index}, ${item});
    </script>
</c:forEach>

    <form:form id="info" action="${pageContext.request.contextPath}/getnames" method="POST">
        <input type="text" id="name" name="name" placeholder="Name">
        <input type="text" id="date" name="date" placeholder="Date {dd.mm.yyyy}">
        <input type="submit" id="confirm">
    </form:form>

    <form:form id="addForm">
        <input type="text" id="name" name="name" placeholder="Name">
        <input type="text" id="pass" name="pass" placeholder="Password">
        <input type="button" id="confirm" onclick="addUser();">
    </form:form>

<div id="map-canvas"></div>

<script>
    function addUser() {
        $.ajax({
            type: "POST",
            url: "/addUser",
            data: {
                "name": $("#name").val(),
                "pass": $("#name").pass()
            }
        }).done(function(response) {
            console.log(response);
        });
    }
</script>
</body>
</html>

<script type="text/javascript"
        src="http://maps.googleapis.com/maps/api/js?libraries=geometry&v=3&key=AIzaSyBfcW0KZvzDQcydwhJ7iLtsTE0haAEBbT8&sensor=false">
</script>
