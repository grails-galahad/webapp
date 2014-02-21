<%@ page defaultCodec="html" %>
<div class="form-group ${invalid ? 'has-error has-feedback' : ''}">
	<label class="col-sm-4 control-label" for="${property}">${label}</label>
	<div class="col-sm-6">
		<%= widget %>
		<g:if test="${invalid}">
			<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			<span class="help-block">${errors.join('<br>')}</span>
		</g:if>
	</div>
</div>