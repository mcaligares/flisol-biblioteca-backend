package biblio

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(BiblioController)
@Mock([Book, Author, Category])
class BiblioControllerSpec extends Specification {

    void setup() {
        controller.bookService = Mock(BookService)
    }

    void "test save book"() {
        given:
        String isbn = '1234567890'
        1 * controller.bookService.save(_) >> { new Book(isbn: isbn)}
        when:
        def model = controller.save(validCommand)
        then:
        response.json.isbn == isbn
    }
    private BookCommand getValidCommand() {
        new BookCommand(isbn: '1234567890', name: 'pepelui', publisher: 'chuck', datePublised: new Date(), categoryId: 1, authorId: 1)
    }

    void "test search book"() {
        expect:
        1 == 1
    }


}
