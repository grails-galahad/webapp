<div class="input-group">
	<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
<%
	def attrs = [type: 'email', name: property, value: value, class:'form-control']
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>