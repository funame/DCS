package net.simple.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {
public static void main(String[] args) throws JAXBException {
//http://howtodoinjava.com/jaxb/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/



File file=getFile("Test.xml");


JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
 
//We had written this file in marshalling example
Items items= (Items) jaxbUnmarshaller.unmarshal(file);
 
for(Item item : items.getItemList())
{
    System.out.println(item.getId()+")"+item.getQuestion());
    for (Answer answer : item.getAnswers().getAnswerList()) {
    	System.out.println(answer.getText()+"---"+answer.getRight());
	}
    System.out.println("--------------------");
    }
}

/**<h1>Hi i am javadoc</h1>
 * method for getting file from src/main/resources folder
 *@param fileName 
 *
 *
 *
 *
 *@author FUAD-PC
 * 
 */
private static File getFile(String fileName){
	File file=new File("src/main/resources/"+fileName);
	if (file.exists())  System.out.println("ok i found file");

	return file;   
	
}
}
