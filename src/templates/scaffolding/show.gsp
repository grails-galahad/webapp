<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title>\${message(code:"${domainClass.propertyName}.show.label", default:'') ?: message(code:'default.show.label', args:[entityName])}</title>
	</head>
	<body>
		<div class="row">
			
			<div class="col-md-3">
				<div class="well">
					<ul class="nav nav-pills nav-stacked">
						<li>
							<g:link class="list" action="index">
								<span class="glyphicon glyphicon-list"></span>
								\${message(code:"${domainClass.propertyName}.list.label", default:'') ?: message(code:'default.list.label', args:[entityName])}
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<span class="glyphicon glyphicon-plus"></span>
								\${message(code:"${domainClass.propertyName}.create.label", default:'') ?: message(code:'default.create.label', args:[entityName])}
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="col-md-9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="\${flash.message}">
				<bootstrap:alert class="alert-info">\${flash.message}</bootstrap:alert>
				</g:if>
                
				<dl class="dl-horizontal">
				<%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
				    if (GCU.isStaticProperty(domainClass.clazz, 'views')) excludedProps += domainClass.clazz.views?.show?.excludes ?: []
					allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
					if (GCU.isStaticProperty(domainClass.clazz, 'views') && domainClass.clazz.views?.show?.includes) {
					    allowedNames.retainAll(domainClass.clazz.views.show.includes)
					    excludedProps.removeAll(domainClass.clazz.views.show.includes)
				    }
					props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
					Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
					props.each { p -> %>
					
					<f:display bean="\${${propertyName}}" property="${p.name}"/>
					
				<%  } %>
				</dl>

				<g:form url="[resource:${propertyName}, action:'delete']" method="DELETE">
					<div class="form-group">
						<g:link class="btn btn-default" action="edit" id="\${${propertyName}?.id}">
							<span class="glyphicon glyphicon-pencil"></span>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<span class="glyphicon glyphicon-trash"></span>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>

		</div>
	</body>
</html>
