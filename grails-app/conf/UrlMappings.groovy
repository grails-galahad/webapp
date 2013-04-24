class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			}
		}

		"/"(controller:"home")
		"403"(view:'/errors/403')
		"404"(view:'/errors/404')
		"500"(view:'/errors/500')
		"503"(view:'/errors/503')
	}
}
