package io.szak.springcms.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article implements EntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(length = 100)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
    @Column(length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated = new Date();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "article_category", joinColumns = {@JoinColumn(name = "article_id")}, inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories = new ArrayList<>();

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void addCategory(Category category) {
        categories.add(category);
        category.getArticles().add(this);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        category.getArticles().remove(this);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
