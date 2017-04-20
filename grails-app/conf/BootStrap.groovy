import biblio.*

class BootStrap {

    def init = { servletContext ->
        createProgrammingBooks()
        createFreeSoftwareBooks()
    }

    def destroy = {
    }

    private void createProgrammingBooks() {
        Category programming = new Category(name: 'Programación').save()

        Author rMartin = new Author(firstName: 'Robert Cecil', lastName: 'Martin').save()
        Book cleanCode = new Book(isbn:'0132350882', cover: 'cleancode.jpg', publisher:'Prentice Hall',
            name: 'Clean Code: A Handbook of Agile Software Craftsmanship', datePublised: new Date())
        cleanCode.author = rMartin
        cleanCode.category = programming
        cleanCode.save()

        Author sKrug = new Author(firstName: 'Steve', lastName: 'Krug').save()
        Book dontMakeMeThink = new Book(isbn:'0321965515', cover: 'dontmakemethink.jpg', publisher:'Prentice Hall',
            name: 'Dont Make Me Think, Revisited: A Common Sense Approach to Web Usability', datePublised: new Date())
        dontMakeMeThink.author = sKrug
        dontMakeMeThink.category = programming
        dontMakeMeThink.save()

        Author sMcConnell = new Author(firstName: 'Steve', lastName: 'McConnell').save()
        Book codeComplete = new Book(isbn:'0735619670', cover: 'dontmakemethink.jpg', publisher:'Prentice Hall',
            name: 'Code Complete: A Practical Handbook of Software Construction', datePublised: new Date())
        codeComplete.author = sMcConnell
        codeComplete.category = programming
        codeComplete.save()

        Author pSeibel = new Author(firstName: 'Peter', lastName: 'Seibel').save()
        Book coderAtWork = new Book(isbn:'1430219483', cover: 'codeatwork.jpg', publisher:'Prentice Hall',
            name: 'Coders at Work: Reflections on the Craft of Programming', datePublised: new Date())
        coderAtWork.author = pSeibel
        coderAtWork.category = programming
        coderAtWork.save()

        Author aHunt = new Author(firstName: 'Andrew', lastName: 'Hunt').save()
        Book pragmaticProgrammer = new Book(isbn:'020161622X', cover: 'pragmaticprogrammer.jpg', publisher:'Prentice Hall',
            name: 'The Pragmatic Programmer: From Journeyman to Master', datePublised: new Date())
        pragmaticProgrammer.author = aHunt
        pragmaticProgrammer.category = programming
        pragmaticProgrammer.save()

        Author jWilken = new Author(firstName: 'Jeremy', lastName: 'Wilken').save()
        Book ionicAction = new Book(isbn:'1633430081', cover: 'ionicinaction.jpg', publisher:'Prentice Hall',
            name: 'Ionic in Action: Hybrid Mobile Apps with Ionic and AngularJS', datePublised: new Date())
        ionicAction.author = jWilken
        ionicAction.category = programming
        ionicAction.save()

        Author sYusuf = new Author(firstName: 'Sani', lastName: 'Yusuf').save()
        Book ionicFramework = new Book(isbn:'B01AJST0W6', cover: 'ionicframework.jpg', publisher:'Prentice Hall',
            name: 'Ionic Framework By Example', datePublised: new Date())
        ionicFramework.author = sYusuf
        ionicFramework.category = programming
        ionicFramework.save()
    }

    private void createFreeSoftwareBooks() {
        Category freeSoftware = new Category(name: 'Software Libre').save()

        Author aSwartz = new Author(firstName: 'Aaron', lastName: 'Swartz').save()
        Book aSwartzBook = new Book(isbn:'162097066X', cover: 'theboywhocouldchangetheword.jpg', publisher:'Prentice Hall',
            name: 'The Boy Who Could Change the World', datePublised: new Date())
        aSwartzBook.author = aSwartz
        aSwartzBook.category = freeSoftware
        aSwartzBook.save()

        Author mLinsky = new Author(firstName: 'Marty', lastName: 'Linsky').save()
        Book mLinskyBook = new Book(isbn:'1422105768', cover: 'adaptativeleadership.jpg', publisher:'Prentice Hall',
            name: 'The Practice of Adaptive Leadership', datePublised: new Date())
        mLinskyBook.author = mLinsky
        mLinskyBook.category = freeSoftware
        mLinskyBook.save()

        Author cDiBona = new Author(firstName: 'Chris', lastName: 'DiBona').save()
        Book openSourceBook = new Book(isbn:'1565925823', cover: 'opensource.jpg', publisher:'Prentice Hall',
            name: 'Open Sources: Voices from the Open Source Revolution', datePublised: new Date())
        openSourceBook.author = cDiBona
        openSourceBook.category = freeSoftware
        openSourceBook.save()
    }
}
