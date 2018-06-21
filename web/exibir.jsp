<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Pizzanet</title>
        <style>
            button#link{
                text-decoration: none;
                color: #117a8b;
            }
            button#link:hover{
                color: white;
            }
        </style>
    </head>
    <body class="bg-secondary">
        <div class="container-fluid bg-secondary">
            <nav class="navbar navbar-dark fixed-top bg-dark">
                <a href="index.html" class="navbar-brand">PizzaNet</a>

                <a href="cadastrar.html"><button class="btn bg-dark" id="link">Cadastrar</button></a>
                <a><button class="btn bg-dark" id="link" form="lista">Cardápio</button></a>
                <a href="atualizarID.html"><button class="btn bg-dark" id="link">Atualizar</button></a>
                <a href="excluir.html"><button class="btn bg-dark" id="link">Excluir</button></a>
            </nav>
            <form action="Servlet" method="POST" id="lista">
                <input type="hidden" value="listar" name="flag">
            </form>
        </div>
        <div class="container">
            <%
                String msg = String.valueOf(request.getAttribute("resposta"));
                out.print(msg);
            %>
        </div>
    </body>
</html>
