package net.simple.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Answers {
@XmlElement(name = "answer")
List<Answer>  answerList;

public List<Answer> getAnswerList() {
	return answerList;
}

public void setAnswerList(List<Answer> answerList) {
	this.answerList = answerList;
}




}
