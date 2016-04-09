package net.simple.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Answer {
	@XmlAttribute
	Boolean right;
	@XmlValue
	String text;
	public Boolean getRight() {
		return right;
	}
	public void setRight(Boolean right) {
		this.right = right;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
