package biblio

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

@Validateable
class BookCommand {

    Long id
    Long categoryId
    Long authorId
    String isbn
    String name
    String cover
    String edition
    String publisher
    @BindingFormat('yyyy-MM-dd')
    Date datePublised

    static constraints = {
        importFrom Book
        id nullable: true
    }

}
