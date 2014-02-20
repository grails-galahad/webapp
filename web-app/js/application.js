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

$('.datetime-picker').datetimepicker({
    language: 'en',
    pick12HourFormat: true,
    pickSeconds: false
});

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
