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

});