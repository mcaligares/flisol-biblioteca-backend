package biblio

class Book {

    String isbn
    String name
    String url
    String cover
    String edition
    String publisher
    Date datePublised
    Date dateCreated
    Boolean enabled = true
    static belongsTo = [author: Author, category: Category]

    static constraints = {
        isbn unique: true, blank: false, minSize: 10, maxSize: 10
        name blank: false, minSize: 3, maxSize: 50
        url nullable: true
        cover nullable: true
        edition nullable: true
        publisher blank: false, minSize: 3, maxSize: 50
    }

}
