<%-- 
    Document   : index
    Created on : 02/05/2018, 11:35:01
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression Language 3.0 Demo</title> 
        <style>
            table
            {
                border: 1px solid #ababab;
            }
            td
            {
                border: 2px solid #ababab;
            }
            th
            {
                border: 3px solid #ababab;
            }
            th, td
            {
                padding: 2px 15px 2px 15px;
            }
        </style>
    </head>
    <body>
        <p>
            <h1>Expression Language 3.0 Demo</h1>
            <h2>Creating Set</h2>
        </p>
        <p>Set of integers: ${[1, 2, 3, 4, 5]}</p>
        
        <p><h2>Creating List</h2></p>
        <p>List of flowers: ${["Aster", "Carnation", "Rose"]}</p>
        
        <p><h2>Creating Map</h2></p>
        <p>Map of Countries and Capitals: ${{"Canada":"Ottawa", "China":"Beijing", "France":"Paris"}}</p>
        
        <p><h2>Access Map Entry</h2></p>
        <p>Map of Countries and Capitals with Access Entry: ${{"Canada":"Ottawa", "China":"Beijing", "France":"Paris"}["Canada"]}</p>
        
        <p><h2>Static Method</h2></p>
        <p>
            <span>
                &radic;<span style="text-decoration: overline">&nbsp; 36 &nbsp;</span> = ${Math.sqrt(36)}
            </span>
        </p>
        
        <p><h2>Static Field</h2></p>
        <p>
            <span>&pi; = ${Math.PI}</span>
        </p>
        
        <p>Map ${[1, 2, 3, 4].stream().map(n -> Math.sqrt(n)).toList()}</p>
        
        <p><h2>Today is: </h2></p><p>${LocalDate.now()}</p>
        
        <p>Original List: ${["Ottawa", "Beijing", "Paris", "Berlin"]}</p>
        <p>Limit to 3 elements: ${["Ottawa", "Beijing", "Paris", "Berlin"].stream().limit(3).toList()}</p>
        <p>Sorted List: ${["Ottawa", "Beijing", "Paris", "Berlin"].stream().sorted().toList()}</p>
        <p>Average: ${[1,3,5,7].stream().average().get()}</p>
        <p>Sum: ${[1, 3, 5, 7].stream().sum()}</p>
        <p>Count: ${[1, 3, 5, 7].stream().count()}</p>
        <p>Min: ${[1, 3, 100, 1000].stream().min().get()}</p>
        <p>Max: ${[1, 3, 100, 1000].stream().max().get()}</p>
        <p>Map: ${[1, 3, 5].stream().map(x -> 2 * x).toList()}</p>
        <p>Map: ${["ottawa", "beijing", "paris", "berlin"].stream().map(x -> x.toUpperCase()).toList()}</p>
        <p>Filter: ${["Lima", "Beijing", "Paris", "Berlin"].stream().filter(x -> x.startsWith("B")).toList()}</p>
        <p>
            <ul>
                ${["Ottawa", "Beijing", "Paris", "Berlin"].stream().map(x -> "--><li>"+=x+="</li><!--").toList()}
            </ul>
        </p>
        
    </body>
</html>
