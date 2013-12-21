<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Kid Spy</title>
    <style>
        html, body, #map-canvas {
            height: 100%;
            margin: 0px;
            padding: 0px
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
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
                zoom: 3,
                center: new google.maps.LatLng(0, -180),
                mapTypeId: google.maps.MapTypeId.TERRAIN
            };
            var map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);
            var path = new Array(coordinates.length/2);
            console.log(path.length);
                for(var x = 0; x<path.length;x++){
                    path[x]=new google.maps.LatLng(coordinates[x*2], coordinates[(x*2)+1]);
            }
           // path[0] = new google.maps.LatLng[100,100];
           // path[1] = new google.maps.LatLng[0,0];
            var flightPath = new google.maps.Polyline({
                path: path,
                geodesic: true,
                strokeColor: '#FF0000',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });
            flightPath.setMap(map);
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

<div id="map-canvas"></div>
</body>
</html>

<script type="text/javascript"
        src="http://maps.googleapis.com/maps/api/js?libraries=geometry&v=3&key=AIzaSyBfcW0KZvzDQcydwhJ7iLtsTE0haAEBbT8&sensor=false">
</script>
