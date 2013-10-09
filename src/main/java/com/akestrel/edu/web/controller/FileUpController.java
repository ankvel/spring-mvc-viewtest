package com.akestrel.edu.web.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.akestrel.edu.model.AksMessage;
import com.akestrel.edu.model.DataTablesRequest;
import com.akestrel.edu.model.DataTablesResponse;
import com.akestrel.edu.model.FileMeta;

@Controller
public class FileUpController {

	private LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	private Long fileId = 0L;
	private FileMeta fileMeta = null;

	@RequestMapping(value = "/fileup/upload", method = RequestMethod.POST)
	public @ResponseBody
	LinkedList<FileMeta> upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			System.out.println(mpf.getOriginalFilename() + " uploaded! "
					+ files.size());

			if (files.size() >= 10) {
				files.pop();
			}

			fileMeta = new FileMeta();
			fileMeta.setId(fileId++);
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());

			try {
				fileMeta.setBytes(mpf.getBytes());

				// Bad!!!
				//FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
				//		"C:/Dev/temp/files/" + mpf.getOriginalFilename()));

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			files.add(fileMeta);
			return files;
		}

		return null;
	}

	@RequestMapping(value = "/fileup/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response, @PathVariable String value) {
		
		FileMeta getFile = null;
		for (FileMeta file: files) {
			if (file.getId().equals(Long.valueOf(value))) {
				getFile = file;
				break;
			}
		}
		
		try {
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ getFile.getFileName() + "\"");
			FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/fileup", method = RequestMethod.GET)
	public String fileup (AksMessage aksMessage, Model model) {						
		return "fileup";
	}
	
    @RequestMapping(value = "/fileup/doajax", method = RequestMethod.GET)
    public @ResponseBody DataTablesResponse<FileMeta> doAjax(
    		DataTablesRequest dataTableRequest,
            HttpServletRequest request
    		
    		) {
 

    	Enumeration<String> params = request.getParameterNames();
    	
    	// TODO delete this
    	System.out.println(request.getRequestURI());
    	System.out.println("asd");
    	
    	while (params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println(param + ": " + request.getParameter(param));
		}
    	//

    	DataTablesResponse<FileMeta> dataTablesResponse = new DataTablesResponse<FileMeta>();
    	
    	//dataTablesResponse.setColumns("fileName");
    	//dataTablesResponse.setEcho(dataTableRequest.getEcho());
    	dataTablesResponse.setTotalDisplayRecords(files.size());
    	dataTablesResponse.setTotalRecords(files.size());
    	
    	dataTablesResponse.setData(files);
    	
    	
    	
    	return dataTablesResponse;
        
    }
    
	
}
