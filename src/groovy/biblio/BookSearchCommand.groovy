package biblio

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

@Validateable
class BookSearchCommand {

    String isbn
    String name
    String edition
    String publisher
    @BindingFormat('yyyy-MM-dd')
    Date datePublisedIni
    @BindingFormat('yyyy-MM-dd')
    Date datePublisedEnd
    String authorLastName
    String authorFirstName

}
