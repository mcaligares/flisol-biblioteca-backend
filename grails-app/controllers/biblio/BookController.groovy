package biblio

import grails.converters.JSON

class BookController {

    def bookService

    def save(BookCommand command) {
        Book book = bookService.save(command)
        render book as JSON
    }

    def search(BookSearchCommand command) {
        List<Book> list = bookService.search(command)
        render ([list] as JSON)
    }

}
