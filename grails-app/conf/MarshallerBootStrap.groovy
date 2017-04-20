import biblio.*
import grails.converters.JSON

class MarshallerBootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Book) {
            return [
                    id                       : it.id,
                    isbn                     : it.isbn,
                    name                     : it.name,
                    cover                    : it.cover,
                    edition                  : it.edition,
                    publisher                : it.publisher,
                    datePublised             : it.datePublised?.format('dd-MM-yyyy'),
                    datePublisedTimestamp    : it.datePublised?.toTimestamp()?.getTime(),
                    dateCreated              : it.dateCreated?.format('dd-MM-yyyy'),
                    dateCreatedTimestamp     : it.dateCreated?.toTimestamp()?.getTime(),
                    author                   : it.author,
                    category                 : it.category,
                    errors                   : it.errors.allErrors.collect { err -> err.code }
            ]
        }
    }

    def destroy = {
    }
}
