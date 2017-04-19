package biblio

class Category {

    String name
    static hasMany = [books: Book]

    static constraints = {
        name blank: false, minSize: 3, maxSize: 50
    }

}
