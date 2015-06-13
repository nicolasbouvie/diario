<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="aluno/incluir" method="post">
	<input type="hidden" name="turma" value="${turma.id}">
	<select name="aluno">
		<c:forEach var="aluno" items="${alunos}">
			<option value="${aluno.id}">${aluno.nome}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Incluir">
</form>

<c:forEach var="aluno" items="${turma.alunos}">
	<a href="turma/aluno/excluir?aluno=${aluno.id}&turma=${id}">X</a> ${aluno.nome}<br/>
</c:forEach>