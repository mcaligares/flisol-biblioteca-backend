package biblio

import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Secured(['permitAll'])
class BiblioController {

    def bookService

    def save(BookCommand command) {
        if (request.method != 'POST') {
            response.status = 405
            render([error: 'method not allowed']) as JSON
        } else {
            Book book = bookService.save(command)
            render book as JSON
        }
    }

    def search(BookSearchCommand command) {
        List<Book> list = bookService.search(command)
        render (list as JSON)
    }

    def authors() {
        List<Author> list = Author.getAll()
        render ([authors: list] as JSON)
    }

    def categories() {
        List<Category> list = Category.getAll()
        render ([categories: list] as JSON)
    }

}
