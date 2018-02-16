package org.lrf.blogadmin.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class VideoController {

	static final String path = "/Users/luoruofeng/Desktop/abc/";

	// 删除文件
	@RequestMapping("/delete")
	public ModelAndView deleteFiles(@RequestParam("filename") String Fname) {
		System.out.println(Fname + "deleteteef");
		File tempfile = new File(path + Fname);
		return null;
	}

	// 上传视频
	@RequestMapping("/upload")
	@ResponseBody
	public String uploadVideo(@RequestParam("files[]") List<MultipartFile> files) {

		MultipartFile file = null;

		if (files != null && files.size() > 0) {
			file = files.get(0);
		} else {
			throw new RuntimeException();
		}

		System.out.println(file.getClass());

		String fileName = file.getOriginalFilename();
		File tempFile = new File(path + "/" + fileName);

		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdirs(); // 如果没有找到上传的目录就会创建这个目录
		}
		if (!file.isEmpty()) {
			BufferedOutputStream out;
			try {
				out = new BufferedOutputStream(new FileOutputStream(tempFile));
				out.write(file.getBytes());
				out.flush();
				out.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "SUCCESS";
	}

	@RequestMapping("/main")
	public ModelAndView main(Model model) {
		model.addAttribute("abc", "aaaaaaaaaaaaaa");
		return new ModelAndView("main");
	}
	
	@RequestMapping("/create_video")
	public ModelAndView createViedeo() {
		System.out.println("??");
		return new ModelAndView("b");
	}

	
	
	//luoruofeng

	@RequestMapping("/videos")
	public ModelAndView getVideos() {
		ModelAndView mv = new ModelAndView("video_manage");
		return mv;
	}
	
	@RequestMapping("/show_add_video")
	public ModelAndView showAddVideo() {
		ModelAndView mv = new ModelAndView("add_video");
		return mv;
	}
	
	@RequestMapping("/add_video")
	@ResponseBody
	public String addVideo() {
		return null;
	}

	@RequestMapping("/update_video")
	@ResponseBody
	public String updateVideo() {
		return null;
	}
	
}
