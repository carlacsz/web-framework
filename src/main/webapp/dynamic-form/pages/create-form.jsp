<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create Form</title>
</head>

<body>
    <h1>Create Form</h1>
    <form action="CreateForm" method="post">
        <div class="mainHeader">
            <div class="mainHeaderTitle">
				<label for="form-name">Name</label>
                <input type="text" name="form-name"></div>
            <div class="mainHeaderDescription">
            </div>
        </div>
        <input type="submit" value="Submit" />
    </form>
</body>

</html>