<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">

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
			<option value="volvo">Volvo</option>
			<option value="saab">Saab</option>
			<option value="fiat">Fiat</option>
			<option value="audi">Audi</option>
		</select> Kilometrering: <input id="km" type="text" name="km" /> <input type="submit"
			value="Submit" />
	</form>
</body>
	</html>
</jsp:root>