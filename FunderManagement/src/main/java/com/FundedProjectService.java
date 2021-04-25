package com;


import model.FundedProjects;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundedProjects")
public class FundedProjectService
{
		FundedProjects itemObj = new FundedProjects();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
		{
			return itemObj.readItems();
		}
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("projectName") String projectName,
							@FormParam("projectPrice") String projectPrice,
							@FormParam("projectDesc") String projectDesc)
						
		{
				String output = itemObj.insertItem(projectName, projectPrice, projectDesc);
				return output;
		}

		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateItem(String itemData)
		{
			//Convert the input string to a JSON object
			JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
			//Read the values from the JSON object
			String projectID = itemObject.get("projectID").getAsString();
			String projectName = itemObject.get("projectName").getAsString();
			String projectPrice = itemObject.get("projectPrice").getAsString();
			String projectDesc = itemObject.get("projectDesc").getAsString();
			
			String output = itemObj.updateItem(projectID, projectName, projectPrice, projectDesc);
			return output;
		}
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteItem(String itemData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String itemID = doc.select("itemID").text();
		 String output = itemObj.deleteItem(itemID);
		return output;
		}

		
}



