package biblio

class Category {

    String name
    static hasMany = [books: Book]

    static constraints = {
        name blank: false, size: 3..50
    }

}
