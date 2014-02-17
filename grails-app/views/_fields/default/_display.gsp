<div class="field">
	<dt><g:message code="${bean.domainClass.propertyName}.${persistentProperty.name}.label" default="${persistentProperty.naturalName}" /></dt>
	<%  if (persistentProperty.oneToMany || persistentProperty.manyToMany) { %>
		<g:if test="${bean."${property}"}">
			<g:each var="child" in="${bean."${property}"}">
			<dd><g:link controller="${persistentProperty.referencedDomainClass?.propertyName}" action="show" id="${child.id}">${child.encodeAsHTML()}</g:link></dd>
			</g:each>
		</g:if>
		<g:else>
			<dd>&nbsp;</dd>
		</g:else>
	<%  } else if (persistentProperty.manyToOne || persistentProperty.oneToOne) { %>
		<g:if test="${bean."${property}"}">
			<dd><g:link controller="${persistentProperty.referencedDomainClass?.propertyName}" action="show" id="${bean."${property}".id}">${value}</g:link></dd>
		</g:if>
		<g:else>
			<dd>&nbsp;</dd>
		</g:else>
	<%  } else { %>
		<dd>${value ?: raw('&nbsp;')}</dd>
	<%  } %>
</div>
