<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tweet tweet</title>
</head>
<body>
<h2>List of Students</h2>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">Add new</button>
<table class="table table-stripped">
    <thead>
    <tr>
        <td>Tweet ID</td>
        <td>Tweet</td>
        <td>Author</td>
        <td>Published date</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <!-- <tr th:each="student:$(nazwa z modelu!! w StudentController)">       -->
    <tr th:each="tweet:${tweets}">
        <td th:text="${tweet.id}">Id</td>
        <td th:text="${tweet.message}">Tweet</td>
        <td th:text="${tweet.author.login}">Author</td>
        <td th:text="${tweet.publishedAt}">Published date</td>
        <td><a th:href="@{/students/getOne/(id=${student.id})}" class="btn btn-warning">Edit</a></td>
        <td><a th:href="@{/students/delete/(id=${student.id})}" class="btn btn-danger" id="deleteButton">Delete</a></td>
    </tr>
</table>

<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <form th:action="@{/students/addNew}" method="post">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New Student</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Id:</label>
                        <textarea class="form-control" id="message-text" name="id"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Name:</label>
                        <textarea class="form-control" id="message-text" name="name"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Department:</label>
                        <textarea class="form-control" id="message-text" name="department"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Updated By:</label>
                        <textarea class="form-control" id="message-text" name="updatedBy"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Updated On:</label>
                        <textarea class="form-control" id="message-text" name="updatedOn"></textarea>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
