<div class="input-prepend">
	<span class="add-on"><i class="icon-user"></i></span>
<%
	def attrs = [type: 'text', name: property, value: value]
	if (required) attrs.required = ''
	out << g.field(attrs)
%>
</div>