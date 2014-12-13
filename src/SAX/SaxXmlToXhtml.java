/*
 * Copyright (c) 2014, Maxime Carro, Célia Strzelecki
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of xmlToXhtml nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package SAX;

import java.io.File;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Maxime Carro, Célia Strzelecki
 * @version 1.0
 * 
 */
public class SaxXmlToXhtml extends DefaultHandler
{
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	static final String SCHEMA_FILE = null;// TODO à modifier

	public void startDocument() throws SAXException
	{
		
	}

	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException
	{
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		
	}
	
	public void endDocument() throws SAXException
	{
		
	}

	/**
	 * Convert from a filename to a file URL.
	 */
	private static String convertToFileURL(String filename)
	{
		String path = new File(filename).getAbsolutePath();
		if (File.separatorChar != '/')
		{
			path = path.replace(File.separatorChar, '/');
		}
		if (!path.startsWith("/"))
		{
			path = "/" + path;
		}
		return "file:" + path;
	}

	static public void main(String[] args) throws Exception
	{
		String filename = null;
		boolean xsdValidate = false;// TODO à modifier

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals("-help"))
			{
				System.err.println("Usage: SaxXmlToXhtml <file.xml>");
			} else
			{
				filename = args[i];
				if (i != args.length - 1)
				{
					System.err.println("Usage: SaxXmlToXhtml <file.xml>");
				}
			}
		}
		if (filename == null)
		{
			System.err.println("Usage: SaxXmlToXhtml <file.xml>");
		}


		SAXParserFactory saxFactory = SAXParserFactory.newInstance();

		saxFactory.setNamespaceAware(true);

		saxFactory.setValidating(xsdValidate);

		SAXParser saxParser = saxFactory.newSAXParser();
		
		if (xsdValidate)
		{
			try
			{
				saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			} catch (SAXNotRecognizedException x)
			{
				System.err.println("Error: JAXP SAXParser property not recognized: " + JAXP_SCHEMA_LANGUAGE);
				System.err.println("Check to see if parser conforms to JAXP 1.2 spec.");
				System.exit(1);
			}
		}
		
		if (SCHEMA_FILE != null)
		{
			saxParser.setProperty(JAXP_SCHEMA_SOURCE, new File(SCHEMA_FILE));
		}
		
		XMLReader xmlReader = saxParser.getXMLReader();
		
		xmlReader.setContentHandler(new SaxXmlToXhtml());
		
		xmlReader.setErrorHandler(new MyErrorHandler(System.err));
		
		xmlReader.parse(convertToFileURL(filename));
	}
}
