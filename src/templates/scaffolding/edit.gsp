<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title>\${message(code:"${domainClass.propertyName}.edit.label", default:'') ?: message(code:'default.edit.label', args:[entityName])}</title>
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
					<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
				</div>

				<g:if test="\${flash.message}">
				<bootstrap:alert class="alert-info">\${flash.message}</bootstrap:alert>
				</g:if>

				<g:hasErrors bean="\${${propertyName}}">
				<bootstrap:alert class="alert-danger">
				<ul>
					<g:eachError bean="\${${propertyName}}" var="error">
					<li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
					</g:eachError>
				</ul>
				</bootstrap:alert>
				</g:hasErrors>

				<fieldset>
					<g:form class="form-horizontal" url="[resource:${propertyName}, action:'update']" method="PUT" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
						<g:hiddenField name="version" value="\${${propertyName}?.version}" />
						<fieldset>
					        <f:with bean="${propertyName}">
						    <%  excludedProps = Event.allEvents.toList() << 'id' << 'version' << 'dateCreated' << 'lastUpdated'
            				    if (GCU.isStaticProperty(domainClass.clazz, 'views')) excludedProps += domainClass.clazz.views?.edit?.excludes ?: []
            					allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
								boolean hasHibernate = pluginManager?.hasGrailsPlugin('hibernate') || pluginManager?.hasGrailsPlugin('hibernate4')
								if (hasHibernate) {
									def GrailsDomainBinder = getClass().classLoader.loadClass('org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsDomainBinder')
									if (GrailsDomainBinder.newInstance().getMapping(domainClass)?.identity?.generator == 'assigned') {
										allowedNames << domainClass.identifier.name
									}
								}
            					if (GCU.isStaticProperty(domainClass.clazz, 'views') && domainClass.clazz.views?.edit?.includes) {
            					    allowedNames.retainAll(domainClass.clazz.views.edit.includes)
            					    excludedProps.removeAll(domainClass.clazz.views.edit.includes)
        					    }
            					props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) }
            					Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            					props.each { p -> %>
                                    <f:field property="${p.name}" input-class="${p.type == Boolean ? 'checkbox-control' : 'form-control'}"/>
            				<%  } %>
                            </f:with>
							<div class="form-group">
								<div class="col-sm-5 col-sm-offset-2">
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok"></span>
										<g:message code="default.button.update.label" default="Update" />
									</button>
									<button type="submit" class="btn btn-danger" name="_action_delete" formnovalidate>
										<span class="glyphicon glyphicon-trash"></span>
										<g:message code="default.button.delete.label" default="Delete" />
									</button>
								</div>
							</div>
						</fieldset>
					</g:form>
				</fieldset>

			</div>

		</div>
	</body>
</html>
