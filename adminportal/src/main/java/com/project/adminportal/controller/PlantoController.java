package com.project.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.adminportal.service.PlantService;
import com.project.adminportal.user.Plant;

@Controller
@RequestMapping("/plant")
public class PlantoController {
@Autowired
private PlantService plantService;
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPlant(Model model) {
		Plant plant= new Plant();
		model.addAttribute("plant", plant);
		return "addPlant";
	}
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String addPlantPost(@ModelAttribute("plant") Plant plant, HttpServletRequest request) {
		plantService.save(plant);

		
		 String uploadRootPath = request.getServletContext().getRealPath("imag");
		 System.out.println("uploadRootPath=" + uploadRootPath);
		

        File uploadRootDir = new File(uploadRootPath);
        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        
        MultipartFile plantImage = plant.getPlantImage();
        
        String name = plantImage.getOriginalFilename();
        System.out.println("Client File Name = " + name);

        if (name != null && name.length() > 0) {
            try {
                // Create the file at server
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + plant.getId()+".jpg");

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(plantImage.getBytes());
                stream.close();
                //

                System.out.println("Write file: " + serverFile);
            } catch (Exception e) {
                System.out.println("Error Write file: " + name);

            }
        }
        
		/*
		 * MultipartFile plantImage = plant.getPlantImage();
		 * 
		 * if(plantImage!=null) { System.out.println("The image is uploaded"); } try {
		 * 
		 * byte[] bytes = plantImage.getBytes();
		 * 
		 * 
		 * String name = plant.getId() + ".jpg";
		 * 
		 * BufferedOutputStream stream = new BufferedOutputStream( new
		 * FileOutputStream(new File("src/main/all/"+ name)));
		 * 
		 * if(stream!=null) { stream.write(bytes);
		 * System.out.println("The name is not null"); stream.close(); }
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		return "redirect:plantList";
	}
	
	@RequestMapping("/plantInfo")
	public String plantInfo(@RequestParam("id") Long id, Model model) {
		Optional<Plant> plant = plantService.findById(id);
		model.addAttribute("plant", plant);
		
		return "plantInfo";
	}
	
	@RequestMapping("/updatePlant")
	public String updatePlant(@RequestParam("id") Long id, Model model) {
		Optional <Plant> plant = plantService.findById(id);
		model.addAttribute("plant", plant);
		
		return "updatePlant";
	}
	@RequestMapping(value="/updatePlant", method=RequestMethod.POST)
	public String updatePlantPost(@ModelAttribute("plant") Plant plant, HttpServletRequest request) {
		plantService.save(plant);
		
		MultipartFile plantImage = plant.getPlantImage();
		
		/*
		 * if(!plantImage.isEmpty()) { try { byte[] bytes = plantImage.getBytes();
		 * String name = plant.getId() + ".png";
		 * 
		 * Files.delete(Paths.get("src/main/resources/static/imag/"+name));
		 * 
		 * BufferedOutputStream stream = new BufferedOutputStream( new
		 * FileOutputStream(new File("src/main/resources/static/imag/" + name)));
		 * stream.write(bytes); stream.close(); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */
		 return "redirect:/plant/plantInfo?id="+plant.getId();
		
	}
	  
	  @RequestMapping("/plantList")
		public String plantList(Model model) {
			List<Plant> plantList = plantService.findAll();
			model.addAttribute("plantList", plantList);		
			return "plantList";
			
		}
	
	
}
