<div class="input-group">
	<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
<%
	def attrs = [type: 'password', name: property, value: value, class:'form-control']
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>