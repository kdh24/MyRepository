package com.mycompany.myweb.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Food;
import com.mycompany.myweb.dto.Light;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")	//context root 뒤의 / 다음 내용을 찾아 실행 해준다.
	public String index() {
		System.out.println("index() 실행1");	// 이거 같은 경우는 개발 후에 다 지워야 한다.
		logger.debug("index() 실행");	// 로그에 출력 -> 프로젝트가 실행되면 로그에 이게 뜬다.
									// 이것을 실행시키면 info 레벨에서 어느 클래스가 실행 시켰는지 보여준다.(현재는 HomeController)
									// 로그의 경우 안 지워도 출력 안되게 할 수 있다
									// 메소드 이름에 따라 로그 레벨이 달라진다.
									// main/resources 의 log4j.xml 의 level value 에서 지정할 수 있다.
		return "index";	// 이 이름과 views 폴더의 jsp 파일 이름이 같아야 한다.
	}

	@RequestMapping("/lightList")
	public String lightList(Model model) {
        List<Light> list = new ArrayList<>();
        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));

        list.add(new Light("light1.png", "light1_large.png", "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light2.png", "light2_large.png", "인테리어 조명2", "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light3.png", "light3_large.png", "인테리어 조명3", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light4.png", "light4_large.png", "인테리어 조명4", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light5.png", "light5_large.png", "인테리어 조명5", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));

        model.addAttribute("list", list);
		return "lightList";
	}
	
	@RequestMapping("/foodList")
	public String foodList(Model model){
		List<Food> list = new ArrayList<>();
		list.add(new Food("food01.png", "food01_large.png", "푸드1", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food02.png", "food02_large.png", "푸드2", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food03.png", "food03_large.png", "푸드3", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food04.png", "food04_large.png", "푸드4", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food05.png", "food05_large.jpg", "푸드5", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		
		list.add(new Food("food01.png", "food01_large.png", "푸드1", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food02.png", "food02_large.png", "푸드2", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food03.png", "food03_large.png", "푸드3", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food04.png", "food04_large.png", "푸드4", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		list.add(new Food("food05.png", "food05_large.jpg", "푸드5", "35,000", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		
		model.addAttribute("list", list);
		return "foodList";
		
	}
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request, HttpServletResponse response) {
		try{
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/resources/image/" + fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while((byteNum = is.read(values)) != -1){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
