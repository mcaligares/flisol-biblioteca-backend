import biblio.*
import grails.converters.JSON

class MarshallerBootStrap {

    def grailsLinkGenerator

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Book) {
            def result = [
                    id                       : it.id,
                    isbn                     : it.isbn,
                    name                     : it.name,
                    url                      : it.url,
                    cover                    : grailsLinkGenerator.resource(dir: 'assets/books', file: it.cover, absolute: true),
                    edition                  : it.edition,
                    publisher                : it.publisher,
                    datePublised             : it.datePublised?.format('dd-MM-yyyy'),
                    datePublisedTimestamp    : it.datePublised?.toTimestamp()?.getTime(),
                    dateCreated              : it.dateCreated?.format('dd-MM-yyyy'),
                    dateCreatedTimestamp     : it.dateCreated?.toTimestamp()?.getTime(),
                    author                   : it.author,
                    category                 : it.category
            ]
            if (it.hasErrors()) {
                result << [errors: it.errors.allErrors.collect { err -> err.code }]
            }
            return result
        }
        JSON.registerObjectMarshaller(Author) {
            def result = [
                    id                       : it.id,
                    lastName                 : it.lastName,
                    firstName                : it.firstName
            ]
            if (it.hasErrors()) {
                result << [errors: it.errors.allErrors.collect { err -> err.code }]
            }
            return result
        }
        JSON.registerObjectMarshaller(Category) {
            def result = [
                    id                       : it.id,
                    name                     : it.name
            ]
            if (it.hasErrors()) {
                result << [errors: it.errors.allErrors.collect { err -> err.code }]
            }
            return result
        }
    }

    def destroy = {
    }
}
