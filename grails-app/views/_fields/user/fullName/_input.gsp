<div class="input-group">
	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
<%
	def attrs = [type: 'text', name: property, value: value, class:'form-control']
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>