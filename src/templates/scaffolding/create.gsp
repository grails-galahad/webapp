<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">\${entityName}</li>
						<li>
							<g:link class="list" action="index">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li class="active">
							<g:link class="create" action="create">
								<i class="icon-plus icon-white"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.create.label" args="[entityName]" /></h1>
				</div>

				<g:if test="\${flash.message}">
				<bootstrap:alert class="alert-info">\${flash.message}</bootstrap:alert>
				</g:if>

				<g:hasErrors bean="\${${propertyName}}">
				<bootstrap:alert class="alert-error">
				<ul>
					<g:eachError bean="\${${propertyName}}" var="error">
					<li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
					</g:eachError>
				</ul>
				</bootstrap:alert>
				</g:hasErrors>

				<fieldset>
					<g:form class="form-horizontal" url="[resource:${propertyName}, action:'save']" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
						<fieldset>
					        <f:with bean="${propertyName}">
						    <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
            				    if (GCU.isStaticProperty(domainClass.clazz, 'views')) excludedProps += domainClass.clazz.views?.create?.excludes ?: []
            					allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
								boolean hasHibernate = pluginManager?.hasGrailsPlugin('hibernate') || pluginManager?.hasGrailsPlugin('hibernate4')
								if (hasHibernate) {
									def GrailsDomainBinder = getClass().classLoader.loadClass('org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsDomainBinder')
									if (GrailsDomainBinder.newInstance().getMapping(domainClass)?.identity?.generator == 'assigned') {
										allowedNames << domainClass.identifier.name
									}
								}
            					if (GCU.isStaticProperty(domainClass.clazz, 'views') && domainClass.clazz.views?.create?.includes) {
            					    allowedNames.retainAll(domainClass.clazz.views.create.includes)
            					    excludedProps.removeAll(domainClass.clazz.views.create.includes)
        					    }
            					props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) }
            					Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
            					props.each { p -> %>
                                    <f:field property="${p.name}"/>
            				<%  } %>
                            </f:with>
							<div class="form-actions">
								<button type="submit" class="btn btn-primary">
									<i class="icon-ok icon-white"></i>
									<g:message code="default.button.create.label" default="Create" />
								</button>
							</div>
						</fieldset>
					</g:form>
				</fieldset>
				
			</div>

		</div>
	</body>
</html>
