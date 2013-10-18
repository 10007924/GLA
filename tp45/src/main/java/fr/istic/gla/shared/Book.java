package fr.istic.gla.shared;

/*
 * This class is an example of entity class
 */


public class Book implements BookItf {

	
	
    private Integer isbn;
    private String title;
    private String author;
    private int note;
    public Book() {
    }

    public Book(Integer isbn, String title, String author, int note) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.setNote(note);
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#getTitle()
	 */
    public String getTitle() {
        return title;
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#setTitle(java.lang.String)
	 */
    public void setTitle(String title) {
        this.title = title;
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#getAuthor()
	 */
    public String getAuthor() {
        return author;
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#setAuthor(java.lang.String)
	 */
    public void setAuthor(String author) {
        this.author = author;
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#getIsbn()
	 */
    public Integer getIsbn() {
        return isbn;
    }

    /* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#setIsbn(java.lang.Integer)
	 */
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

	/* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#getNote()
	 */
	public int getNote() {
		return note;
	}

	/* (non-Javadoc)
	 * @see fr.istic.gla.shared.BookItf#setNote(int)
	 */
	public void setNote(int note) {
		this.note = note;
	}
}
