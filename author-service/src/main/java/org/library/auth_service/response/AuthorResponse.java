package org.library.auth_service.response;

public class AuthorResponse {
    private int id;
    private String name;
    private String email;

    private BookResponse bookResponse;

    public BookResponse getBookResponse() {
        return bookResponse;
    }

    public void setBookResponse(BookResponse bookResponse) {
        this.bookResponse = bookResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
