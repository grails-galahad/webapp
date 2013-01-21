class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			}
		}

		"/"(view:"/home/index")
		"403"(view:'/errors/403')
		"404"(view:'/errors/404')
		"500"(view:'/errors/error') // Map to /errors/500 for go live
		"503"(view:'/errors/503')
	}
}
