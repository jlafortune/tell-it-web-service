package net.lafortu.tellit.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="article")
@NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
public class Article {
	@XmlElement(required=true)
	private int articleId;
	
	@XmlElement(required=true)
	private String title;
	
	@XmlElement(required=true)
	private String text; 

	@Id
	@Column(name="article_id")
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
