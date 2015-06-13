<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="nav.jsp"/>

<form id="${param.tipo}Form" action="${param.tipo}/salvar" method="post">
	<input id="id" name="${param.tipo}.id" type="hidden"/>
	<table>
		<c:forTokens var="field" items="${param.fields}" delims=";">
			<tr>
				<c:if test="${fn:startsWith(field, '_')}">
					<c:set var="fieldName" value="${fn:substring(field,1,fn:length(field))}"/>
					<td><label for="${fieldName}">${fieldName}</label></td>
					<td>
						<select id="${fieldName}" style="width:100%" name="${param.tipo}.${fieldName}.id">
							<c:forEach var="item" items="${requestScope[field]}">
								<option value="${item.id}">${item.nome}</option>
							</c:forEach>
						</select>
					</td>
				</c:if>
				<c:if test="${not fn:startsWith(field, '_')}">
					<td><label for="${field}">${field}</label></td>
					<td>
						<input id="${field}" style="width:100%" name="${param.tipo}.${field}" type="text"/>
					</td>
				</c:if>
				</td>
		</c:forTokens>
		<tr>
			<td colspan="2">	
				<input type="submit" value="Salvar"/><input type="reset" value="Limpar"/>
			</td>
		</tr>
	</table>
</form>
<br/>
<table id="${param.tipo}Table">
	<thead>
		<tr>
			<th>ID</th>
			<c:forTokens var="field" items="${param.fields}" delims=";">
				<th>${field}</th>
			</c:forTokens>
			<th>Excluir</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${lista}">
			<tr>
				<td class="id">${item.id}</td>
				<c:forTokens var="field" items="${param.fields}" delims=";">
					<c:if test="${fn:startsWith(field, '_')}">
						<td class="${fn:substring(field,1,50)}">${item[fn:substring(field,1,50)].nome}</td>
					</c:if>
					<c:if test="${not fn:startsWith(field, '_')}">
						<td class="${field}">${item[field]}</td>
					</c:if>
				</c:forTokens>
				<td><a href="${param.tipo}/remover?id=${item.id}">X</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="scripts.jsp">
	<jsp:param value="${param.tipo}" name="form"/>
</jsp:include>