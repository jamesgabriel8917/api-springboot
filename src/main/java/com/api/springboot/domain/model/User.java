package com.api.springboot.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Essa anotacao faz com que a tabela tb_user criada tenha relacionamento um pra um com a tabela Account
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    //Essa anotacao faz com que a tabela tb_user criada tenha relacionamento um pra um com a tabela Card
    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    //notacao faz com que a tabela tenha relacionamento um para muitos,
    // FetchType.EAGER faz com que sempre que o usuario seja chamado ele traz com resultado as features
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}