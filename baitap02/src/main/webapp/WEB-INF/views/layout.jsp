<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>${pageTitle}</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    </head>
    <body class="p-4">
        <div class="container">
            <jsp:include page="${body}"/>
        </div>
    </body>
</html>
