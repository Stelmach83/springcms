package io.szak.springcms.controller;

import io.szak.springcms.dao.EntityDao;
import io.szak.springcms.entity.Article;
import io.szak.springcms.entity.Author;
import io.szak.springcms.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping("/articles")
    public String homePage(Model model) {
        List<Article> articleList = entityDao.loadSomeArticles(5);
        for (Article a : articleList) {
            String shortCont = a.getContent().substring(0, 100);
            a.setContent(shortCont);
        }
        List<Category> categoryList = entityDao.loadAllCategories();
        model.addAttribute("lista", articleList);
        model.addAttribute("categ", categoryList);
        return "articles";
    }

    @RequestMapping("/loadArticle/{id}")
    @ResponseBody
    public String loadById(@PathVariable Long id) {
        Article load = entityDao.loadArticleById(id);
        return load.toString();
    }
}
