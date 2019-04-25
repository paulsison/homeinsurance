<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Property Details</title>
<%@ include file="Header.html"%>
</head>
<body>
<h1>Property Details</h1>

<form action="postPropertyDetails" method="post">
		<div>
			<label>What is the market value of your home?</label> <input type="text" name="marketValue" />
		</div>
		<div>
			<label>What year was your home originally built?</label> <input type="text" name="yearBuilt" />
		</div>
		<div>
		<label>Square footage</label> <input type="text" name="squareFootage"/>sq ft
		</div>
		<div>
			<label>Dwelling Style:</label> <select name="dwellingStyle">
				<option value="1 story">1 story</option>
				<option value="1 and 1/2 stories">1 and 1/2 stories</option>
				<option value="2 stories">2 stories</option>
				<option value="2 and 1/2 stories">2 and 1/2 stories</option>
				<option value="3 stories">3 stories</option>				
			</select>
		</div>
		<div>
			<label>Roof Material</label> <select name="roofMaterial">
				<option value="concrete">Concrete</option>
				<option value="clay">Clay</option>
				<option value="rubber">Rubber</option>
				<option value="steel">Steel</option>
				<option value="tin">Tin</option>
				<option value="wood">Wood</option>				
			</select>
		</div>
		<div>
			<label>Type of Garage</label> <select name="garageType">
				<option value="attached">Attached</option>
				<option value="detached">Detached</option>
				<option value="basement">Basement</option>
				<option value="built in">Built In</option>
				<option value="none">None</option>				
			</select>
		</div>
		<div>
			<label>Number of full baths</label> <select name="fullBaths">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4 or more">4 or More</option>
			</select>
		</div>
		<div>
			<label>Number of half baths</label> <select name="halfBaths">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4 or more">4 or More</option>			
			</select>
		</div>
		<div>
			<label>Do you have a swimming pool?:</label> 
			<input type="radio" name="hasPool" value="1" />Yes 
			<input type="radio" name="hasPool" value="0" />No
		</div>	
		<div>
			<input type="submit" value="Continue" />
		</div>
	</form>

</body>
<%@ include file="Footer.html" %>
</html>