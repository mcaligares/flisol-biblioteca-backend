package biblio

class Author {

    String lastName
    String firstName
    static hasMany = [books: Book]

    static constraints = {
        lastName blank: false, minSize: 2, maxSize: 30
        firstName blank: false, minSize: 2, maxSize: 30
    }

}
