<div class="input-append date datepicker" data-date="<g:formatDate date="${value}" formatName="datepicker.date.format" />" data-date-format="${g.message(code:'datepicker.date.format').toLowerCase()}">
    <input type="text" id="${property}" name="${property}" value="<g:formatDate date="${value}" formatName="datepicker.date.format" />" placeholder="${g.message(code:'datepicker.date.format').toLowerCase()}" <g:if test="${required}">required</g:if> >
	<span class="add-on"><i class="icon-calendar"></i></span>
</div>
