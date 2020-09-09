package com.demo.hateoas;

public class Link {

	private String link;
	private String rel;

	public Link() {
		super();
	}

	public Link( String rel, String link) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	@Override
	public boolean equals(Object obj) {
		Link link = (Link)obj;
		return link.getLink().equals(this.getLink()) && link.getRel().equals(this.getRel());
	}
	
	@Override
	public int hashCode() {
		return this.link.hashCode();
	}
}
