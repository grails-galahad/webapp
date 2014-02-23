package bootstrap

import org.springframework.validation.Errors
import org.springframework.validation.FieldError
import org.springframework.web.servlet.support.RequestContextUtils as RCU

class BootstrapTagLib {

	static namespace = "bootstrap"
	
	def alert = { attrs, body ->
		out << '<div class="alert alert-dismissable ' << attrs.class.tokenize().join(" ") << '">'
		out << '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>'
		out << '<p>' << body() << '</p>'
		out << '</div>'
	}
	
	def paginate = { attrs ->
        def writer = out
        if (attrs.total == null) {
            throwTagError("Tag [paginate] is missing required attribute [total]")
        }

        def messageSource = grailsAttributes.messageSource
        def locale = RCU.getLocale(request)

        def total = attrs.int('total') ?: 0
		
        def action = (attrs.action ? attrs.action : (params.action ? params.action : "list"))
        def offset = params.int('offset') ?: 0
        def max = params.int('max')
        def maxsteps = (attrs.int('maxsteps') ?: 10)

        if (!offset) offset = (attrs.int('offset') ?: 0)
        if (!max) max = (attrs.int('max') ?: 10)

        def linkParams = [:]
        if (attrs.params) linkParams.putAll(attrs.params)
        linkParams.offset = offset - max
        linkParams.max = max
        if (params.sort) linkParams.sort = params.sort
        if (params.order) linkParams.order = params.order

        def linkTagAttrs = [action: action]
        if (attrs.controller) {
            linkTagAttrs.controller = attrs.controller
        }
        if (attrs.id != null) {
            linkTagAttrs.id = attrs.id
        }
        if (attrs.fragment != null) {
            linkTagAttrs.fragment = attrs.fragment
        }
        linkTagAttrs.params = linkParams

        def steps = maxsteps > 0
        int currentstep = (offset / max) + 1
        int firststep = 1
        int laststep = Math.round(Math.ceil(total / max))

		writer << '<ul class="pagination">'

		if (currentstep > firststep) {
			linkTagAttrs.class = 'prevLink'
			linkParams.offset = offset - max
			writer << '<li'
			if (currentstep == firststep) writer << ' class="disabled"'
			writer << '>'
			def prevLinkAttrs = linkTagAttrs.clone()
			prevLinkAttrs += [title: (attrs.prev ?: messageSource.getMessage('paginate.prev', null, messageSource.getMessage('default.paginate.prev', null, 'Previous', locale), locale))]
			writer << link(prevLinkAttrs, '<span class="glyphicon glyphicon-chevron-left"></span>')
			writer << '</li>'
		}

        if (steps && laststep > firststep) {
            linkTagAttrs.class = 'step'

            int beginstep = currentstep - Math.round(maxsteps / 2) + (maxsteps % 2)
            int endstep = currentstep + Math.round(maxsteps / 2) - 1

            if (beginstep < firststep) {
                beginstep = firststep
                endstep = maxsteps
            }
            if (endstep > laststep) {
                beginstep = laststep - maxsteps + 1
                if (beginstep < firststep) {
                    beginstep = firststep
                }
                endstep = laststep
            }

			for (int i in beginstep..endstep) {
                linkParams.offset = (i - 1) * max
				writer << '<li'
				if (currentstep == i) writer << ' class="active"'
				writer << '>'
                   writer << link(linkTagAttrs.clone()) {i.toString()}
				writer << '</li>'
            }
        }

		if (currentstep < laststep) {
			linkTagAttrs.class = 'nextLink'
			linkParams.offset = offset + max
			writer << '<li'
			if (currentstep == laststep) writer << ' class="disabled"'
			writer << '>'
			def nextLinkAttrs = linkTagAttrs.clone()
			nextLinkAttrs += [title: (attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, messageSource.getMessage('default.paginate.next', null, 'Next', locale), locale))]
			writer << link(nextLinkAttrs, '<span class="glyphicon glyphicon-chevron-right"></span>')
			writer << '</li>'
		}
		
		writer << '</ul>'
	}

}