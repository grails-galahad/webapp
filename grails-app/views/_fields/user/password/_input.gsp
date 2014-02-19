<div class="input-group">
	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
<%
	def attrs = [type: 'password', name: property, value: value]
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>