<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">\${entityName}</li>
						<li>
							<g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="\${flash.message}">
				<bootstrap:alert class="alert-info">\${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				<%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
				    if (GCU.isStaticProperty(domainClass.clazz, 'views')) excludedProps += domainClass.clazz.views?.show?.excludes ?: []
					allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
					if (GCU.isStaticProperty(domainClass.clazz, 'views') && domainClass.clazz.views?.show?.includes) {
					    allowedNames.retainAll(domainClass.clazz.views.show.includes)
					    excludedProps.removeAll(domainClass.clazz.views.show.includes)
				    }
					props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) }
					Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
					props.each { p -> %>
					
					<g:if test="\${${propertyName}?.${p.name}}">
					<f:display bean="\${${propertyName}}" property="${p.name}"/>
					</g:if>
					
				<%  } %>
				</dl>

				<g:form>
					<g:hiddenField name="id" value="\${${propertyName}?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="\${${propertyName}?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>

		</div>
	</body>
</html>
