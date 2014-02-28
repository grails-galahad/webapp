/* Scaffolding */
$(document).ready(function() {

$('tr.clickable').click(function() {
    var href
    $(this).find("a").each(function() {
        if (!href) href = $(this).attr('href');
        $(this).attr('href', 'javascript:void(0)');
    });
    if (href) window.location = href;
});

$('.datetime-picker').datetimepicker();
$('th.asc').append('<span class="glyphicon glyphicon-arrow-down"></span>');
$('th.desc').append('<span class="glyphicon glyphicon-arrow-up"></span>');
$('fieldset.embedded .form-group input').addClass('form-control');

resizeMainContainer();

});

function resizeMainContainer() {
	var mainContainer = $('.container.main');
	var footer = $('footer');
	var newHeight = mainContainer.height() + ($(window).height() - (footer.offset().top + footer.outerHeight()));
	if (newHeight > parseInt(mainContainer.css('min-height'))) {
		mainContainer.css('min-height', newHeight);
	}
}
