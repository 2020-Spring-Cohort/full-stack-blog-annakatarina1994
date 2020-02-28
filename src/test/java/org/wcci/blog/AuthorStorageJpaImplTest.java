package org.wcci.blog;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AuthorStorageJpaImplTest {
    @Test
    public void shouldStoreAuthor(){
        AuthorRepository authorRepo = mock(AuthorRepository.class);
        AuthorStorage underTest = new AuthorStorageJpaImpl(authorRepo);
        Author testAuthor = new Author("Arthur");
        underTest.store(testAuthor);
        verify(authorRepo).save(testAuthor);
    }
}
