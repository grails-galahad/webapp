<div class="input-group datetime-picker">
    <input type="text" class="form-control" id="${property}" name="${property}" value="<g:formatDate date="${value}" formatName="datetimepicker.date.format" />" data-format="${g.message(code:'datetimepicker.js.date.format')}" placeholder="${g.message(code:'datetimepicker.date.format').toLowerCase()}" <g:if test="${required}">required</g:if> />
    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
</div>
