package biblio

class Book {

    String isbn
    String name
    String cover
    String edition
    String publisher
    Date datePublised
    Date dateCreated
    Category category
    static hasMany = [authors: Author]

    static constraints = {
        isbn blank: false, size: 10
        name blank: false, size: 3..50
        cover nullable: true
        edition nullable: true
        publisher blank: false, size: 3..50
    }

}
