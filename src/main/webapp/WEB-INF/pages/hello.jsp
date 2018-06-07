<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<h1>${message}</h1>
	<form method="post" action="saveFile"  enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="file" name="image" id="image"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add Document"/>
				</td>
			</tr>
		</table>
	</form>

	<img  src="data:image/jpeg;base64,${userImage}" />
</body>
</html>