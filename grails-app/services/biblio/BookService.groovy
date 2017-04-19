package biblio

import grails.transaction.Transactional

@Transactional
class BookService {

    def save(BookCommand command) {
        Book book = command.validate() && command.id ? Book.get(command.id) : new Book()
        if (command.validate()) {
            book.properties = command.properties
            book.author = Author.get(command.authorId)
            book.category = Category.get(command.categoryId)
            book.save()
        } else {
            book.errors = command.errors
        }
        return book
    }

}
