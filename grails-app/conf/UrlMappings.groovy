class UrlMappings {

    static mappings = {

        "/book/save"(controller: 'biblio', action: 'save')
        "/books/search"(controller: 'biblio', action: 'search')
        "/authors"(controller: 'biblio', action: 'authors')
        "/categories"(controller: 'biblio', action: 'categories')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
