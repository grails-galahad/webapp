<div class="input-group">
	<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
<%
	def attrs = [type: 'text', name: property, value: value, class:'form-control']
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>