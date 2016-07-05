/**
 * 
 */
package com.mindtree.awsfinalpresentation.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018439
 * 
 */
/*
 * ValueObjects Entity class for list of ValueObject
 */
@XmlRootElement(name = "valueobjects")
// Define the root element for a XML tree
public class ValueObjects {

	private List<ValueObject> list;

	public List<ValueObject> getList() {
		return list;
	}

	public void setList(List<ValueObject> list) {
		this.list = list;
	}

}
