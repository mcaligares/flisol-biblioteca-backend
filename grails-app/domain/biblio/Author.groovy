package biblio

class Author {

    String lastName
    String firstName
    static hasMany = [books: Book]

    static constraints = {
        lastName blank: false, size: 2..30
        firstName blank: false, size: 2..30
    }

}
