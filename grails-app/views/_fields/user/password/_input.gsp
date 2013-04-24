<div class="input-prepend">
	<span class="add-on"><i class="icon-lock"></i></span>
<%
	def attrs = [type: 'password', name: property, value: value]
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>