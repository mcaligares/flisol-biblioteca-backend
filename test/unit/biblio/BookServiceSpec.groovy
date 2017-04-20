package biblio

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(BookService)
@Mock([Book, Author, Category])
class BookServiceSpec extends Specification {

    void "test create book"() {
        given:
        new Author(firstName: 'chuck', lastName: 'norris').save()
        new Category(name: 'lol').save()
        when:
        def book = service.save(validCommand)
        then:
        book.id != null
    }
    void "test create book without author"() {
        given:
        new Category(name: 'lol').save()
        when:
        def book = service.save(validCommand)
        then:
        book.hasErrors()
        book.errors.allErrors.codes[0].contains('nullable.author')
    }
    void "test create book without category"() {
        given:
        new Author(firstName: 'chuck', lastName: 'norris').save()
        when:
        def book = service.save(validCommand)
        then:
        book.hasErrors()
        book.errors.allErrors.codes[0].contains('nullable.category')
    }

    private BookCommand getValidCommand() {
        new BookCommand(isbn: '1234567890', name: 'pepelui', publisher: 'chuck', datePublised: new Date(), categoryId: 1, authorId: 1)
    }

    void "test try to create book with invalid command"() {
        when:
        def book = service.save(invalidCommand)
        then:
        book.hasErrors()
    }

    private BookCommand getInvalidCommand() {
        new BookCommand(isbn: '12345', name: 'pepelui', publisher: 'chuck', datePublised: new Date())
    }

    void "test update book"() {
        given:
        def author = new Author(firstName: 'chuck', lastName: 'norris').save()
        def category = new Category(name: 'lol').save()
        def book = createBook('1234567890', author, category)
        def command = new BookCommand(id:book.id, isbn: '1111111111', name: book.name, publisher: book.publisher,
            datePublised: book.datePublised, authorId: 1, categoryId: 1)
        when:
        def bookUpdated = service.save(command)
        then:
        bookUpdated.isbn == '1111111111'
    }
    private Book createBook(String isbn, Author author, Category category) {
        def book = new Book(isbn: isbn, name: "libro-$isbn", publisher: 'chuck', datePublised: new Date())
        book.author = author
        book.category = category
        book.save(flush: true)
    }

    void "test list book"() {
        given:
        def author = new Author(firstName: 'chuck', lastName: 'norris').save()
        def category = new Category(name: 'lol').save()
        5.times {
            createBook("123456789$it", author, category)
        }
        when:
        def list = service.search()
        then:
        list.size() == 5
    }
    void "test search by name book"() {
        given:
        def author = new Author(firstName: 'chuck', lastName: 'norris').save()
        def category = new Category(name: 'lol').save()
        5.times {
            createBook("123456789$it", author, category)
        }
        5.times {
            createBook("111111111$it", author, category)
        }
        when:
        def list = service.search(new BookSearchCommand(name:'libro-1111'))
        then:
        list.size() == 5
    }
    void "test search by author book"() {
        given:
        def author = new Author(firstName: 'chuck', lastName: 'norris').save()
        def category = new Category(name: 'lol').save()
        5.times {
            createBook("123456789$it", author, category)
        }
        5.times {
            createBook("111111111$it", author, category)
        }
        when:
        def list = service.search(new BookSearchCommand(authorLastName: 'norris'))
        then:
        list.size() == 10
    }
}
