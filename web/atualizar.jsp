<%@page import="br.com.pizzanet.modelo.Pizza"%>
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
            <nav class="navbar navbar-dark bg-dark">
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
                Pizza pi = (Pizza) request.getAttribute("pizza");
            %>
            <form action="Servlet" method="POST">
                <fieldset>
                    <legend>Atualizar</legend>
                    <input type="hidden" value="atualizar" name="flag">
                    <input type="hidden" value=<%out.print("\"" + pi.getId() + "\"");%> name="idPizza">
                    <p>Nome Pizza:<input type="text" name="nomePizza" maxlength="25" size="25" value=<%out.print("\"" + pi.getNomePizza() + "\"");%> ></p>
                    <p>Grande<input type="radio" value="Grande" name="tamanhoPizza"<%if (pi.getTamanhoPizza().equals("Grande")) {
                            out.print("checked");
                        }%>>
                        Broto<input type="radio" value="Broto" name="tamanhoPizza" <%if (pi.getTamanhoPizza().equals("Broto")) {
                                out.print("checked");
                            }%>></p>
                    <p>Preço: R$<input type="number" step="0.01" name="precoPizza" value=<%out.print("\"" + pi.getPrecoPizza() + "\"");%>></p>
                    <p>Ingredientes:</p>
                    <p><textarea name="ingredientesPizza" rows="4" cols="32" maxlength="120"><%out.print(pi.getIngredientesPizza());%></textarea></p>
                    <p><input type="submit" value="Atualizar"></p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
