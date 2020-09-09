package com.demo.hateoas;

public class Link {

	private String link;
	private String rel;

	public Link() {
		super();
	}

	public Link(String link, String rel) {
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
		return 1;
	}
}
