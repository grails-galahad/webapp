<div class="input-group datetime-picker">
    <input type="text" class="form-control" id="${property}" name="${property}" value="<g:formatDate date="${value}" formatName="datetimepicker.date.format" />" placeholder="${g.message(code:'datetimepicker.date.format').toLowerCase()}" <g:if test="${required}">required</g:if> />
    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
</div>
