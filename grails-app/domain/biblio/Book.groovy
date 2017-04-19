package biblio

class Book {

    String isbn
    String name
    String cover
    String edition
    String publisher
    Date datePublised
    Date dateCreated
    static belongsTo = [author: Author, category: Category]

    static constraints = {
        isbn blank: false, minSize: 10, maxSize: 10
        name blank: false, minSize: 3, maxSize: 50
        cover nullable: true
        edition nullable: true
        publisher blank: false, minSize: 3, maxSize: 50
    }

}