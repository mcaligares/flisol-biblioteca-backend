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

    @Transactional(readOnly = true)
    def search(BookSearchCommand command) {
        Book.createCriteria().list {
            if (command?.isbn) eq 'isbn', command.isbn
            if (command?.name) like 'name', "%${command.name}%"
            if (command?.edition) eq 'edition', command.edition
            if (command?.publisher) like 'publisher', "%${command.publisher}%"
            if (command?.datePublisedIni && command.datePublisedEnd) {
                between 'datePublised', command.datePublisedIni, command.datePublisedEnd
            } else if (command?.datePublisedIni) {
                lt 'datePublised', command.datePublisedIni
            }
            if (command?.authorLastName || command?.authorFirstName) {
                author {
                    if (command?.authorLastName) like 'lastName', "%${command.authorLastName}%"
                    if (command?.authorFirstName) like 'firstName', "%${command.authorFirstName}%"
                }
            }
        }
    }

}
