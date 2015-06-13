<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
Diario:<br/>
<c:forEach var="turma" items="${turmas}">
	Disciplina: ${turma.disciplina.nome}<br/>
	Professor: ${turma.professor.nome}<br/>
	Inicio: ${turma.dataInicio}<br/>
	Fim: ${turma.dataFim}<br/>

	<c:forEach var="aluno" items="${turma.alunos}">
		${aluno.nome}<br/>
	</c:forEach>
	<br/><br/>
</c:forEach>