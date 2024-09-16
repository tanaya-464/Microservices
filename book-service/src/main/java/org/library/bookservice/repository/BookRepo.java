package org.library.bookservice.repository;

import org.library.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book,Integer> {
    @Query(nativeQuery = true, value="select ca.id,ca.title,ca.author from library.book ca join library.author c on c.id=ca.author_id where ca.author_id=:authorId;")
    Book findAddressByCustomerId(@Param("authorId") int authorId);

}
