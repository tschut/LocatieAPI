<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function handleForm() {
		var kmlintForm = document.getElementById("kmlint");
		var kmlint = kmlintForm.options[kmlintForm.selectedIndex].text;
		var km = document.getElementById("km").value;
		alert("boe " + kmlint + "@" + km);
	}
</script>
<head>
<title>LocatieAPI</title>
</head>
<body>
	<form action="javascript:handleForm()">
		Kilometerlint: <select id="kmlint" name="kmlint">
			<c:forEach var="item" items="${linten}">
				<option value="<c:out value='${item}' />">
					<c:out value='${item}' /></option>
			</c:forEach>
		</select> Kilometrering: <input id="km" type="text" name="km" /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>