<g:if test="${value}">
    <div class="field">
    	<dt><g:message code="${bean.domainClass.propertyName}.${persistentProperty.name}.label" default="${persistentProperty.naturalName}" /></dt>
    	<%  if (persistentProperty.oneToMany || persistentProperty.manyToMany) { %>
    		<g:each var="child" in="${bean."${property}"}">
    		<dd><g:link controller="${persistentProperty.referencedDomainClass?.propertyName}" action="show" id="${child.id}">${child.encodeAsHTML()}</g:link></dd>
    		</g:each>
    	<%  } else if (persistentProperty.manyToOne || persistentProperty.oneToOne) { %>
    		<dd><g:link controller="${persistentProperty.referencedDomainClass?.propertyName}" action="show" id="${bean."${property}".id}">${value}</g:link></dd>
    	<%  } else { %>
    		<dd>${value}</dd>
    	<%  } %>
	</div>
</g:if>
