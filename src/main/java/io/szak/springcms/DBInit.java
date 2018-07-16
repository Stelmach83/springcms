package io.szak.springcms;

import io.szak.springcms.dao.EntityDao;
import io.szak.springcms.entity.Article;
import io.szak.springcms.entity.Author;
import io.szak.springcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DBInit {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping("/initDb")
    @ResponseBody
    public String initDb() {
        Author a1 = new Author();
        a1.setFirstName("S.");
        a1.setLastName("King");
        Author a2 = new Author();
        a2.setFirstName("G.");
        a2.setLastName("Martin");
        Author a3 = new Author();
        a3.setFirstName("M.");
        a3.setLastName("Stel");
        Author a4 = new Author();
        a4.setFirstName("J.R.R.");
        a4.setLastName("Tolkien");
        Author a5 = new Author();
        a5.setFirstName("JK.");
        a5.setLastName("Rowlings");

        Category c1 = new Category();
        c1.setName("tech");
        c1.setDescription("tech related articles");
        Category c2 = new Category();
        c2.setName("cars");
        c2.setDescription("car related articles");
        Category c3 = new Category();
        c3.setName("art");
        c3.setDescription("art related articles");
        Category c4 = new Category();
        c4.setName("showbiz");
        c4.setDescription("showbiz related articles");
        Category c5 = new Category();
        c5.setName("sports");
        c5.setDescription("sports related articles");

        Article article1 = new Article();
        article1.setTitle("title1");
        article1.setAuthor(a1);
        article1.setContent("This is the content of the article1");
        Article article2 = new Article();
        article2.setTitle("title2");
        article2.setAuthor(a2);
        article2.setContent("This is the content of the article2");
        Article article3 = new Article();
        article3.setTitle("title3");
        article3.setAuthor(a3);
        article3.setContent("This is the content of the article3");
        Article article4 = new Article();
        article4.setTitle("title4");
        article4.setAuthor(a4);
        article4.setContent("This is the content of the article4");
        Article article5 = new Article();
        article5.setTitle("title5");
        article5.setAuthor(a5);
        article5.setContent("This is the content of the article5");

        entityDao.saveEntity(a1);
        entityDao.saveEntity(a2);
        entityDao.saveEntity(a3);
        entityDao.saveEntity(a4);
        entityDao.saveEntity(a5);

        entityDao.saveEntity(c1);
        entityDao.saveEntity(c2);
        entityDao.saveEntity(c3);
        entityDao.saveEntity(c4);
        entityDao.saveEntity(c5);

        entityDao.saveEntity(article1);
        entityDao.saveEntity(article2);
        entityDao.saveEntity(article3);
        entityDao.saveEntity(article4);
        entityDao.saveEntity(article5);

        article1.getCategoryList().add(c1);
        article1.getCategoryList().add(c2);
        article2.getCategoryList().add(c3);
        article2.getCategoryList().add(c2);
        article3.getCategoryList().add(c4);
        article3.getCategoryList().add(c5);
        article4.getCategoryList().add(c4);
        article4.getCategoryList().add(c5);
        article5.getCategoryList().add(c3);
        article5.getCategoryList().add(c1);

        entityDao.updateEntity(article1);
        entityDao.updateEntity(article2);
        entityDao.updateEntity(article3);
        entityDao.updateEntity(article4);
        entityDao.updateEntity(article5);

        return "Spring CMS database initialized.";
    }
}
