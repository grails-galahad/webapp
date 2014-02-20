<div class="input-group">
	<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
<%
	def attrs = [type: 'email', name: property, value: value, class:'form-control']
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>