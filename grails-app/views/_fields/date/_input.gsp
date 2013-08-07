<div class="input-append datetime-picker">
    <input type="text" id="${property}" name="${property}" value="<g:formatDate date="${value}" formatName="datetimepicker.date.format" />" data-format="${g.message(code:'datetimepicker.js.date.format')}" placeholder="${g.message(code:'datetimepicker.date.format').toLowerCase()}" <g:if test="${required}">required</g:if> />
    <span class="add-on"><i class="icon-calendar"></i></span>
</div>
